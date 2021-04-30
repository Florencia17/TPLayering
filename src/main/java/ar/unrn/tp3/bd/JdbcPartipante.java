package ar.unrn.tp3.bd;

import ar.unrn.tp3.modelo.Participante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPartipante {
    private Connection dbConn;

    private void setupBaseDeDatos() throws SQLException {
        String url = "jdbc:derby://localhost:1527/participantes";
        String user = "app";
        String password = "app";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    public void createParticipante(Participante participante){

        try {
            PreparedStatement st = dbConn.prepareStatement(
                    "insert into participantes(nombre, telefono, region) values(?,?,?)");
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
            st.close();
        } catch (SQLException e){
            throw new RuntimeException("No se pudo registrar el participante");
        }
    }
}
