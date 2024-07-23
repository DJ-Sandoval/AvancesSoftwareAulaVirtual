package Modelo;

public class Alumno {
    // Atributos
    private int id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String pais;
    private String sexo;
    private String estado;

    // Constructor sin parámetros
    public Alumno() {
    }

    // Constructor con parámetros
    public Alumno(int id, String nombre, String apellido, String usuario, String clave, String pais, String sexo,
            String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.pais = pais;
        this.sexo = sexo;
        this.estado = estado;
    }

    // Métodos get y set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
    

   
    
    
    
}
