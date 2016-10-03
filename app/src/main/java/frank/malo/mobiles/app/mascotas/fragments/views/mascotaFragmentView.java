package frank.malo.mobiles.app.mascotas.fragments.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.presentador.IMascotaFragmentPresenter;
import frank.malo.mobiles.app.mascotas.presentador.MascotaFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotaFragmentView extends Fragment implements IMascotaFragmentView {

    private RecyclerView rvMascotas;
    private IMascotaFragmentPresenter presenter;

    public MascotaFragmentView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new MascotaFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void genearLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }

}
