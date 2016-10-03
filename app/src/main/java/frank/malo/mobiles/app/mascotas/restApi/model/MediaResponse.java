package frank.malo.mobiles.app.mascotas.restApi.model;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 01/10/2016.
 */

public class MediaResponse {
    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
