package frank.malo.mobiles.app.mascotas.fragments.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.activities.MascotasDummy;
import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.presentador.IMascotaFragmentPresenter;
import frank.malo.mobiles.app.mascotas.presentador.MascotaFragmentPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class mascotaFragmentView extends Fragment implements IMascotaFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IMascotaFragmentPresenter presenter;

    public mascotaFragmentView() {
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





    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        ImageView img5Stars = (ImageView) getActivity().findViewById(R.id.img5Stars);
        img5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarMascotas();
                enviarDatos();
            }
        });
        return v;
    }




    public void ordenarMascotas(){
        Collections.sort(mascotas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota m1, Mascota m2) {
                if (m1.getPuntaje() > m2.getPuntaje())  return -1;
                else if (m1.getPuntaje() == m2.getPuntaje())  return 0;
                else return 1;
            }
        });
    }


    /*ImageView img5Stars = (ImageView) getActivity().findViewById(R.id.img5Stars);
        img5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Mascota> mascotas5 = presenter.obtener5MejoresMascotas();
                Intent intent = new Intent(getActivity(), MascotasDummy.class);
                for (int i=0; i<mascotas5.size(); i++){
                    intent.putExtra(getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas5.get(i));
                }
                startActivity(intent);
            }
        });

    public void enviarDatos(){
        Intent intent = new Intent(getActivity(), MascotasDummy.class);
        int tamanio = getResources().getTextArray(R.array.pmascotas).length;
        for (int i=0; i<tamanio; i++){
            //todo: validar que no se sobrepase el tamaño de la cantidad de mascotas en el arrayList
            intent.putExtra(getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas.get(i));
        }
        startActivity(intent);
    }*/


}
