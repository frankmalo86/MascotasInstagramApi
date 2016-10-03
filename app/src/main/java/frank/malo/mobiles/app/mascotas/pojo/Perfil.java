package frank.malo.mobiles.app.mascotas.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Frank on 02/10/2016.
 */

public class Perfil implements Serializable{
    private String nombre;
    private String id;
    private String urlFoto;
    private ArrayList<Mascota> mascotas;

    public Perfil() {
    }

    public Perfil(String nombre, String urlFoto, ArrayList<Mascota> mascotas) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.mascotas = mascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
