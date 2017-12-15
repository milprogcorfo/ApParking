/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class BDUsuario {

    Connection con;

    public BDUsuario() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/apparking", "root", "123456");
        } catch (SQLException se) {
            System.err.println("Error de conexión: " + se.getMessage()); // Si no se logra conectar a la BD...
            try {
                if (con != null) {
                    con.close(); // ... Se intenta cerrar la conexión.
                }
            } catch (SQLException se2) {
                System.err.println("Error al intentar cerrar conexión: " + se.getMessage());
            }
        }
    }

    public boolean agregarConductor(Usuario c) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (rut, primNombre, segNombre, apPaterno, apMaterno, nacimiento, patente, direccion, email, telefono, pass, esPropietario) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, c.getRut());
            ps.setString(2, c.getPrimNombre());
            ps.setString(3, c.getSegNombre());
            ps.setString(4, c.getApPaterno());
            ps.setString(5, c.getApMaterno());
            ps.setString(6, c.getNacimiento());
            ps.setString(7, c.getPatente());
            ps.setString(8, c.getDireccion());
            ps.setString(9, c.getTelefono());
            ps.setString(10, c.getEmail());
            ps.setString(11, c.getPass());
            ps.setInt(12, c.getEsPropietario());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    public boolean logIn(String user, String pass) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT rut, pass "
                    + "FROM usuario "
                    + "WHERE rut= '" + user + "' AND pass= '" + pass + "' "
            );
//            ps.setString(1, user);
//            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                if (rs.getString("rut").equals(user) && rs.getString("pass").equals(pass)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException se) {
            System.out.println("Error de conexión: " + se.getMessage());
            return false;
        }
    }
}
