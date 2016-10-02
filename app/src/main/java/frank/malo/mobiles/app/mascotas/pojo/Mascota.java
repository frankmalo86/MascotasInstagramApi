package frank.malo.mobiles.app.mascotas.pojo;

import java.io.Serializable;

/**
 * Created by Frank on 14/09/2016.
 */
//serializo el objeto para mandarlo completo a la siguiente actividad
public class Mascota implements Serializable{

    private int id;
    private String nombre;
    private String  urlFoto;
    private int puntaje ;

    public Mascota() {}

    public Mascota(String nombre, String urlFoto, int puntaje) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.puntaje = puntaje;
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

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
