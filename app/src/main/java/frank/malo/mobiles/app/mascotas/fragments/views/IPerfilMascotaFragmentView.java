package frank.malo.mobiles.app.mascotas.fragments.views;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.adaptadores.PerfilAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.pojo.Perfil;

/**
 * Created by Frank on 02/10/2016.
 */

public interface IPerfilMascotaFragmentView {

    public void generarGridLayout();

    public PerfilAdaptador crearAdaptador(Perfil perfil);

    public void inicializarAdaptadorRV(PerfilAdaptador perfilAdaptador);

    public void mostrarPerfil(Perfil perfil);

}
