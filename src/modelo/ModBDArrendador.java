package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModBDArrendador {

    Connection con;

    public ModBDArrendador() {
        try {
            // Cambiar nombre y variables de base de datos.
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/apparking", "root", "123456");
        } catch (SQLException se) {
            System.err.println("Error de conexión: " + se.getMessage());
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se2) {
                System.err.println("ERROR CLOSE CONN" + se.getMessage());
            }
        }
    }

    public ArrayList<ModArrendador> buscarEst(String ciudad) { //, String dir) {
        try {
            PreparedStatement st = con.prepareStatement(
                    "SELECT * "
                    + "FROM arrendador "
                    + "WHERE ciudad = ? "
            //+ "AND dir = ? "
            );
            st.setString(1, ciudad);
            //st.setString(2, "%"+dir+"%");

            ResultSet rs = st.executeQuery();
            ArrayList<ModArrendador> resultado = new ArrayList<>();
            while (rs.next()) {
                ModArrendador a = new ModArrendador();

                a.setRut(rs.getString("rut"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setCiudad(rs.getString("ciudad"));
                a.setDir(rs.getString("dir"));
                a.setPlaza(Integer.parseInt(rs.getString("plaza")));
                a.setFono(rs.getString("fono"));
                a.setMail(rs.getString("mail"));
                resultado.add(a);
            }
            rs.close();
            st.close();
            return resultado;
        } catch (SQLException se) {
            System.err.println("ERROR SELECT " + se.getMessage());
        }

        return null;
    }

    public int Reservar(String mod) {
        try {
            ModArrendador qwe = new ModArrendador();
            PreparedStatement st = con.prepareStatement(
                    //                "UPDATE arrendador "+
                    "SELECT plaza "
                    + "FROM arrendador "
                    + "WHERE rut = ? ");

            st.setString(1, mod);
            ResultSet rs = st.executeQuery();
            int a = rs.getInt("plaza");
            a--;

            rs.close();
            st.execute();
            st.close();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE arrendador "
                    + "SET plaza=? "
                    + "WHERE rut = ?"
            );
            ps.setInt(1, a);
            ps.setString(2, mod);

            return a;

        } catch (SQLException se) {
            System.err.println("ERROR EXECUTE: " + se.getMessage());
            return 0;
        }
    }
}
