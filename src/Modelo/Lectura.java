package Modelo;

public class Lectura {
    // Atributos
    private int id;
    private int id_alumno;
    private String favorito;
    private String resenia;
    private String estado;
    
    // Constructor vació
    public Lectura() {
    }

    // Constructor con parámetros
    public Lectura(int id, int id_alumno, String favorito, String resenia, String estado) {
        this.id = id;
        this.id_alumno = id_alumno;
        this.favorito = favorito;
        this.resenia = resenia;
        this.estado = estado;
    }

    // Métodos get y set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_alumno() {
        return id_alumno;
    }
    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }
    public String getFavorito() {
        return favorito;
    }
    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }
    public String getResenia() {
        return resenia;
    }
    public void setResenia(String resenia) {
        this.resenia = resenia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
