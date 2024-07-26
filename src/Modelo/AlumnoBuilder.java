package Modelo;

public class AlumnoBuilder {
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String pais;
    private String sexo;
    private String estado;

    public AlumnoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public AlumnoBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AlumnoBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public AlumnoBuilder setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public AlumnoBuilder setClave(String clave) {
        this.clave = clave;
        return this;
    }

    public AlumnoBuilder setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public AlumnoBuilder setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public AlumnoBuilder setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Alumno build() {
        return new Alumno(id, nombre, apellido, usuario, clave, pais, sexo, estado);
    }
}
