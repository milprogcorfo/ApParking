/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alejandro
 */
public class BDArrendador {

    Connection con;

    public BDArrendador() {
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

    public String agregarArrendador(Arrendador a) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Arrendador (rut, nombre, apellido, ciudad, dir, plaza, fono, mail, pass) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, a.getRut());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setString(4, a.getCiudad());
            ps.setString(5, a.getDir());
            ps.setInt(6, a.getPlaza());
            ps.setString(7, a.getFono());
            ps.setString(8, a.getMail());
            ps.setString(9, a.getPass());
            ps.execute();
            ps.close();
            return "OK";
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return "SQL";
        } catch (NumberFormatException nfe) {
            return "NUMBER";
        }
    }

    public boolean modArrendador(Arrendador a) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Arrendador (rut, nombre, apellido, ciudad, dir, plaza, fono, mail, pass) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, a.getRut());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setString(4, a.getCiudad());
            ps.setString(5, a.getDir());
            ps.setInt(6, a.getPlaza());
            ps.setString(7, a.getFono());
            ps.setString(8, a.getMail());
            ps.setString(9, a.getPass());
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
