package frank.malo.mobiles.app.mascotas.pojo;

import java.io.Serializable;

/**
 * Created by Frank on 14/09/2016.
 */
//serializo el objeto para mandarlo completo a la siguiente actividad
public class Mascota implements Serializable{

    private int id;
    private String nombre;
    private int foto;
    private int puntaje ;

    public Mascota() {}

    public Mascota(int foto, String nombre) {
        this.nombre = nombre;
        this.foto = foto;
        this.puntaje = 0;  //valor inicial cuando se instancia la clase
    }

    public Mascota(int foto, String nombre, int puntaje) {
        this.nombre = nombre;
        this.foto = foto;
        this.puntaje = puntaje;  //valor inicial cuando se instancia la clase
    }

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

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
