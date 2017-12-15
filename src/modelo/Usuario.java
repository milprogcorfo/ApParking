/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alejandro
 */
public class Usuario {

    private int id;
    private String rut;
    private String primNombre;
    private String segNombre;
    private String apPaterno;
    private String apMaterno;
    private String nacimiento;
    private String patente;
    private String direccion;
    private String email;
    private String telefono;
    private String pass;
    private int esPropietario;

    public Usuario() {
    }

    public Usuario(int id, String rut, String primNombre, String segNombre, String apPaterno, String apMaterno, String nacimiento, String patente, String direccion, String email, String telefono, String pass, int esPropietario) {
        this.id = id;
        this.rut = rut;
        this.primNombre = primNombre;
        this.segNombre = segNombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nacimiento = nacimiento;
        this.patente = patente;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.pass = pass;
        this.esPropietario = esPropietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPrimNombre() {
        return primNombre;
    }

    public void setPrimNombre(String primNombre) {
        this.primNombre = primNombre;
    }

    public String getSegNombre() {
        return segNombre;
    }

    public void setSegNombre(String segNombre) {
        this.segNombre = segNombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEsPropietario() {
        return esPropietario;
    }

    public void setEsPropietario(int esPropietario) {
        this.esPropietario = esPropietario;
    }
}
