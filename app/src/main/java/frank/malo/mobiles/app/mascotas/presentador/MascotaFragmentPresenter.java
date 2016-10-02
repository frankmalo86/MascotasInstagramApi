package frank.malo.mobiles.app.mascotas.presentador;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.activities.MascotasDummy;
import frank.malo.mobiles.app.mascotas.db.MascotaBD;
import frank.malo.mobiles.app.mascotas.fragments.views.IMascotaFragmentView;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;

/**
 * Created by Frank on 28/09/2016.
 */

public class MascotaFragmentPresenter implements IMascotaFragmentPresenter {

    private final IMascotaFragmentView iMascotaFragmentView;
    private final Context context;
    private MascotaBD mascotasBd;
    private ArrayList<Mascota> mascotas;

    public MascotaFragmentPresenter(final IMascotaFragmentView iMascotaFragmentView, Context context) {
        this.iMascotaFragmentView = iMascotaFragmentView;
        this.context = context;
        obtenerMascotas();
        mostrarMascotasRV();

        ImageView img5Stars = (ImageView) ((Fragment)iMascotaFragmentView).getActivity().findViewById(R.id.img5Stars);
        img5Stars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ArrayList<Mascota> mascotas5 = obtener5MejoresMascotas();
                Intent intent = new Intent(((Fragment)iMascotaFragmentView).getActivity(), MascotasDummy.class);
                for (int i=0; i<mascotas5.size(); i++){
                    intent.putExtra(((Fragment)iMascotaFragmentView).getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas5.get(i));
                }
                ((Fragment)iMascotaFragmentView).startActivity(intent);
            }
        });
    }

    @Override
    public void obtenerMascotas() {
        mascotasBd = new MascotaBD(this.context);
        mascotas = mascotasBd.obtenerTodasMascotas();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotaFragmentView.inicializarAdaptadorRV(iMascotaFragmentView.crearAdaptador(this.mascotas));
        iMascotaFragmentView.genearLinearLayoutVertical();
    }

    @Override
    public ArrayList<Mascota> obtener5MejoresMascotas() {
        mascotasBd = new MascotaBD(this.context);
        return mascotasBd.obtener5MejoresMascotas();
    }
}
