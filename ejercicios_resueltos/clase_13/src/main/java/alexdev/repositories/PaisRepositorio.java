package alexdev.repositories;

import alexdev.models.ConexionDB;
import alexdev.models.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PaisRepositorio {
    //Importante obtener la conexion a DB para realizar consultas.
    private Connection getConnection() throws SQLException {
        return ConexionDB.getConnection();
    }
    public void insertPaisDB(Pais pais){
        try(PreparedStatement stmt = getConnection().prepareStatement(
                """
                        INSERT INTO Paises values(
                        ?
                        );
                        """
        )){
            stmt.setString(1, pais.getNombre());
            stmt.executeUpdate();
            System.out.println("Ingreso de datos en la tabla Paises.");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error en la insercion... "+e.getMessage());
        }
    }
    public void clearPaisesDB(){
        try(
                Statement stmt = getConnection().createStatement();){
            stmt.executeUpdate("""
                    DELETE FROM Paises;
                    """);

            System.out.println("Informacion de paises eliminada correctamente...");
        } catch (SQLException e) {
            throw new RuntimeException("Hubo un error al intentar eliminar informacion de la tabla paises: "+e.getMessage());
        }
    }
}
