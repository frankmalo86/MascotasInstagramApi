package frank.malo.mobiles.app.mascotas.presentador;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import frank.malo.mobiles.app.mascotas.R;
import frank.malo.mobiles.app.mascotas.activities.Mascotas5Estrellas;
import frank.malo.mobiles.app.mascotas.db.UsuarioBD;
import frank.malo.mobiles.app.mascotas.fragments.views.IMascotaFragmentView;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.pojo.Usuario;
import frank.malo.mobiles.app.mascotas.restApi.EndPointApi;
import frank.malo.mobiles.app.mascotas.restApi.adapter.RestInstagramApiAdapter;
import frank.malo.mobiles.app.mascotas.restApi.model.MediaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Frank on 28/09/2016.
 */

public class MascotaFragmentPresenter implements IMascotaFragmentPresenter {

    private final IMascotaFragmentView iMascotaFragmentView;
    private final Context context;
    private ArrayList<Mascota> mascotasRecientesUsuario = new ArrayList<Mascota>();

    public MascotaFragmentPresenter(final IMascotaFragmentView iMascotaFragmentView, Context context) {
        this.iMascotaFragmentView = iMascotaFragmentView;
        this.context = context;
        obtenerMascotasRecientesUsuario();

        ImageView img5Stars = (ImageView) ((Fragment)iMascotaFragmentView).getActivity().findViewById(R.id.img5Stars);
        img5Stars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ArrayList<Mascota> mascotas5 = obtener5MejoresMascotas(mascotasRecientesUsuario);
                Intent intent = new Intent(((Fragment)iMascotaFragmentView).getActivity(), Mascotas5Estrellas.class);
                int tamanio = mascotas5.size() < 5 ? mascotas5.size() : 5;
                for (int i=0; i<tamanio; i++){
                    intent.putExtra(((Fragment)iMascotaFragmentView).getResources().getTextArray(R.array.pmascotas)[i].toString(), mascotas5.get(i));
                }
                ((Fragment)iMascotaFragmentView).startActivity(intent);
            }
        });
    }

    private ArrayList<Mascota> obtener5MejoresMascotas(ArrayList<Mascota> mascotas) {
        Collections.sort(mascotas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota mascota1, Mascota mascota2) {
                if(mascota1.getPuntaje() == mascota2.getPuntaje()) return 0;
                else if (mascota1.getPuntaje() > mascota2.getPuntaje()) return -1;
                else return 1;
            }
        });
        return mascotas;
    }


    @Override
    public void obtenerMascotasRecientesUsuario() {

        RestInstagramApiAdapter restInstagramApiAdapter = new RestInstagramApiAdapter();
        Gson gsonMediaRecent = restInstagramApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointApi endPointApi = restInstagramApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        UsuarioBD usuarioBD = new UsuarioBD(this.context);
        ArrayList<Usuario> usuarios = usuarioBD.obtenerTodosUsuarios();

        for (Usuario usuarioActual : usuarios) {

            Call<MediaResponse> mascotaResponseCall = endPointApi.getRecentMediaUser(usuarioActual.getId());
            //controlamos el resultado de la respuesta
            mascotaResponseCall.enqueue(new Callback<MediaResponse>() {
                @Override
                public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
                    MediaResponse contactoResponse = response.body();
                    mascotasRecientesUsuario.addAll(contactoResponse.getMascotas());
                    //esta linea de código deberia ser coordinada, no estar ejecutandose por cada iteración
                    mascotasRecientesUsuario = ordenarPorFechaMedia(mascotasRecientesUsuario);
                    mostrarMascotasRV();
                }

                @Override
                public void onFailure(Call<MediaResponse> call, Throwable t) {
                    Toast.makeText(context, "Problemas en la conexión al servicio intenta de nuevo", Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                    Log.e("FALLO LA CONEXIÓN", t.toString());
                }
            });
        }
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotaFragmentView.inicializarAdaptadorRV(iMascotaFragmentView.crearAdaptador(this.mascotasRecientesUsuario));
        iMascotaFragmentView.genearLinearLayoutVertical();
    }

    private ArrayList<Mascota> ordenarPorFechaMedia(ArrayList<Mascota> mascotas){
        Collections.sort(mascotas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota mascota1, Mascota mascota2) {

                if(Long.valueOf(mascota1.getFecha()) == Long.valueOf(mascota2.getFecha())) return 0;
                else if (Long.valueOf(mascota1.getFecha()) > Long.valueOf(mascota2.getFecha())) return -1;
                else return 1;
            }
        });
        return mascotas;
    }

}
