package modelo;

public class ModArrendador {

    private String rut;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String dir;
    private int plaza;
    private String fono;
    private String mail;

    public ModArrendador() {
    }

    public ModArrendador(String rut, String nombre, String apellido, String ciudad, String dir, int plaza, String fono, String mail) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.dir = dir;
        this.plaza = plaza;
        this.fono = fono;
        this.mail = mail;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getPlaza() {
        return plaza;
    }

    public void setPlaza(int plaza) {
        this.plaza = plaza;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
