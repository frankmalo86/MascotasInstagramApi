package frank.malo.mobiles.app.mascotas.fragments.views;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 28/09/2016.
 */

public interface IMascotaFragmentView {

    public void genearLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
