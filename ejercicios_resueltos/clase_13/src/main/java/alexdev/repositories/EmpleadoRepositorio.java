package alexdev.repositories;

import alexdev.models.ConexionDB;
import alexdev.models.Departamento;
import alexdev.models.Empleado;
import alexdev.models.Pais;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositorio {
    //Importante obtener la conexion a DB para realizar consultas.
    private Connection getConnection() throws SQLException {
        return ConexionDB.getConnection();
    }
    public void insertEmpleadoDB(Empleado empleado){
        try(PreparedStatement stmt = getConnection().prepareStatement(
                """
                        INSERT INTO Empleados\s
                        VALUES(
                        ?,
                        ?,
                        ?,
                        ?,
                        ?);
                        """)){

            stmt.setString(1, empleado.getDNI());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido());
            stmt.setString(4, empleado.getNacionalidad().getNombre());
            stmt.setString(5, empleado.getDepartamento().getNombre());
            stmt.executeUpdate();

            System.out.println("Empleado agregado a la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error en el ingreso de nuevos datos en la tabla Empleados: "+e.getMessage());
        }
    }
    public void updateEmpleadoDB(Empleado empleado){
        try (PreparedStatement stmt = getConnection().prepareStatement(
                """
                        UPDATE Empleados
                        SET nombre= ?, apellido= ?, pais_FK = ?, departamento_FK = ?\s
                        WHERE dni = ?;
                        """)
        ){
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getNacionalidad().getNombre());
            stmt.setString(4, empleado.getDepartamento().getNombre());
            stmt.setString(5, empleado.getDNI());

            stmt.executeUpdate();
            System.out.println("Modificacion realizada con exito, en tabla Empleados.");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error al intentar modificar la tabla Empleados: "+e.getMessage());
        }
    }
    public Empleado findEmpleadoDB(String dni){
        Empleado empleadoEncontrado = null;
        try (PreparedStatement stmt =getConnection().prepareStatement(
                """
                        SELECT e.dni, e.nombre, e.apellido, e.pais_fk as pais, d.nombre as departamento, d.presupuesto
                        FROM Empleados as e
                        INNER JOIN Departamentos as d
                        ON e.departamento_FK = d.nombre
                        WHERE e.dni = ?;
                        """
        )){
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                empleadoEncontrado = new Empleado();
                empleadoEncontrado.setDNI(rs.getString("dni"));
                empleadoEncontrado.setNombre(rs.getString("nombre"));
                empleadoEncontrado.setApellido(rs.getString("apellido"));
                empleadoEncontrado.setNacionalidad(
                        new Pais(
                                rs.getString("pais"))
                );
                empleadoEncontrado.setDepartamento(
                        new Departamento(
                                rs.getString("departamento"),
                                Double.parseDouble(rs.getString("presupuesto"))
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return empleadoEncontrado;
    }
    public List<Empleado> findToDepartament(String departamento){
        List<Empleado> empleados = new ArrayList<>();
        try(PreparedStatement stmt = getConnection().prepareStatement(
                """
                        SELECT e.dni, e.nombre, e.apellido, e.pais_fk as pais, d.nombre as departamento, d.presupuesto
                        FROM Empleados as e
                        INNER JOIN Departamentos as d
                        ON e.departamento_FK = d.nombre
                        WHERE e.departamento_FK = ?
                        ORDER BY e.nombre;
                        """
        )){
            stmt.setString(1, departamento);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                empleados.add(
                        new Empleado(
                                rs.getString("dni"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                new Pais(
                                        rs.getString("pais")
                                ),
                                new Departamento(
                                        rs.getString("departamento"),
                                        Double.parseDouble(rs.getString("presupuesto"))
                                )
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }
    public void clearEmpleadosDB(){
        try(
                Statement stmt = getConnection().createStatement();){
            stmt.executeUpdate("""
                    DELETE FROM Empleados;
                    """);

            System.out.println("Informacion de empleados eliminada correctamente...");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error al intentar eliminar informacion de la tabla Departamentos: "+e.getMessage());
        }
    }
}
