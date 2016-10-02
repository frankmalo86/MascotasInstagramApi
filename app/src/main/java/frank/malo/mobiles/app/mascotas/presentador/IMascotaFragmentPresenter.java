package frank.malo.mobiles.app.mascotas.presentador;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 28/09/2016.
 */

public interface IMascotaFragmentPresenter {

    public void obtenerMascotas();

    public void mostrarMascotasRV();

    public ArrayList<Mascota> obtener5MejoresMascotas();

}
