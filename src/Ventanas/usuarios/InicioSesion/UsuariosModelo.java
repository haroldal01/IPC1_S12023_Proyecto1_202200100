
package Ventanas.usuarios.InicioSesion;

public class UsuariosModelo
{
    // -------------------------------------------------------------------------
    String correo;
    String nombre;
    String apellido;
    String contraseña;
    String dpi;
    String sexo;
    String nacionalidad;
    String alias;
    String telefono;
    String rol;
    // -------------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "UsuariosModelo{" + "correo=" + correo + ", nombre=" + nombre + 
                ", apellido=" + apellido + ", contrase\u00f1a=" + contraseña + 
                ", dpi=" + dpi + ", sexo=" + sexo + ", nacionalidad=" +
                nacionalidad + ", alias=" + alias + ", telefono=" + telefono +
                ", rol=" + rol + '}';
    }
    // -------------------------------------------------------------------------
    public UsuariosModelo(){
        
    }
    
    
    public UsuariosModelo(
            String correo2, String nombre2, String apellido2,
            String contraseña2, String dpi2, String sexo2, String nacionalidad2,
            String alias2, String telefono2, String rol2)
    {
       this.correo = correo2;
       this.nombre = nombre2;
       this.apellido = apellido2;
       this.contraseña = contraseña2;
       this.dpi = dpi2;
       this.sexo = sexo2;
       this.nacionalidad = nacionalidad2;
       this.alias = alias2;
       this.telefono = telefono2;
       this.rol = rol2;
        
    }
    
    // -------------------------------------------------------------------------
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo2) {
        this.correo = correo2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre2) {
        this.nombre = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido2) {
        this.apellido = apellido2;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña2) {
        this.contraseña = contraseña2;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi2) {
        this.dpi = dpi2;
    }
    /*
    public String getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }*/

    public String getSexo() {
        return sexo;
    }

    public void setGenero(String sexo2) {
        this.sexo = sexo2;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad2) {
        this.nacionalidad = nacionalidad2;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias2) {
        this.alias = alias2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono2) {
        this.telefono = telefono2;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol2) {
        this.rol = rol2;
    }
    
}
