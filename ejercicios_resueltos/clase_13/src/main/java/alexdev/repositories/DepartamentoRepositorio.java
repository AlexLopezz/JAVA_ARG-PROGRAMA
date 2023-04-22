package alexdev.repositories;

import alexdev.models.ConexionDB;
import alexdev.models.Departamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorio {
    //Importante obtener la conexion a DB para realizar consultas.
    private Connection getConnection() throws SQLException {
        return ConexionDB.getConnection();
    }

    public void insertDepartamentoDB(Departamento departamento){
        try(
                PreparedStatement stmt = getConnection().prepareStatement(
                        """
                                INSERT INTO Departamentos(nombre, presupuesto)\s
                                VALUES(?, ?);
                                """);
                ){
            stmt.setString(1,departamento.getNombre());
            stmt.setString(2,String.valueOf(departamento.getPresupuesto()));
            stmt.executeUpdate();
            System.out.println("Creacion de departamento correctamente insertado.");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error al insertar un nuebo registro: "+e.getMessage());
        }
    }
    public List<Departamento> allDepartamentDB(){
        List<Departamento> departamentos = new ArrayList<>();
        try(
                Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(
                        """
                                SELECT nombre, presupuesto
                                FROM Departamentos
                                ORDER BY nombre;
                                """)
                ){
            while (rs.next()){
                departamentos.add(
                        new Departamento(
                                rs.getString("nombre"),
                                Double.parseDouble(rs.getString("presupuesto"))
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error a la hora de filtrar todos los departamentos: "+e.getMessage());
        }
        return departamentos;
    }
    public void deleteDepartmentDB(String departamento){
        try(
                PreparedStatement stmt = getConnection().prepareStatement(
                        """
                                DELETE FROM Departamentos
                                WHERE nombre = ?
                                """
                );
        ){
            stmt.setString(1, departamento);
            stmt.executeUpdate();

            System.out.println("Departamento eliminado correctamente.");

        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error al momento de eliminar un departamento"+e.getMessage());
        }
    }

    public void clearDepartamentosDB(){
        try(
                Statement stmt = getConnection().createStatement();){
            stmt.executeUpdate("""
                    DELETE FROM Departamentos;
                    """);

            System.out.println("Informacion de departamentos eliminada correctamente...");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error al intentar eliminar informacion de la tabla Departamentos: "+e.getMessage());
        }
    }
}
