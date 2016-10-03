package frank.malo.mobiles.app.mascotas.fragments.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.adaptadores.MascotaAdaptador;
import frank.malo.mobiles.app.mascotas.adaptadores.PerfilAdaptador;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.pojo.Perfil;
import frank.malo.mobiles.app.mascotas.presentador.IMascotaFragmentPresenter;
import frank.malo.mobiles.app.mascotas.presentador.IPerfilMascotaFragmentPresenter;
import frank.malo.mobiles.app.mascotas.presentador.MascotaFragmentPresenter;
import frank.malo.mobiles.app.mascotas.presentador.PerfilMascotaFragmentPresenter;

/**
 * Created by Frank on 02/10/2016.
 */

public class PerfilMascotaFragmentView extends Fragment implements IPerfilMascotaFragmentView {
    Perfil perfil;
    private RecyclerView rvMiMascota;
    private IPerfilMascotaFragmentPresenter presenter;

    public PerfilMascotaFragmentView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        presenter = new PerfilMascotaFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvMiMascota.setLayoutManager(glm);
    }

    @Override
    public PerfilAdaptador crearAdaptador(Perfil perfil) {
        return new PerfilAdaptador(perfil, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(PerfilAdaptador perfilAdaptador) {
        rvMiMascota.setAdapter(perfilAdaptador);
    }

    @Override
    public void mostrarPerfil(Perfil perfil){
        CircularImageView imgfotoPerfil = (CircularImageView)getActivity().findViewById(R.id.imgPerfil);
        TextView tvNombrePerfil = (TextView)getActivity().findViewById(R.id.tvNombrePerfil);

        tvNombrePerfil.setText(perfil.getNombre());
        Picasso.with(getContext())
                .load(perfil.getUrlFoto())
                .placeholder(R.drawable.ic_dog)
                .into(imgfotoPerfil);

    }
}
