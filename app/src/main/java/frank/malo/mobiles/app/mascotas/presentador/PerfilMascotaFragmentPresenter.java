package frank.malo.mobiles.app.mascotas.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.fragments.views.IPerfilMascotaFragmentView;
import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.pojo.Perfil;
import frank.malo.mobiles.app.mascotas.restApi.EndPointApi;
import frank.malo.mobiles.app.mascotas.restApi.adapter.RestInstagramApiAdapter;
import frank.malo.mobiles.app.mascotas.restApi.model.MediaResponse;
import frank.malo.mobiles.app.mascotas.restApi.model.PerfilResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Frank on 02/10/2016.
 */

public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter {

    private final IPerfilMascotaFragmentView iPerfilMascotaFragmentView;
    private final Context context;
    private Perfil perfil;

    public PerfilMascotaFragmentPresenter(IPerfilMascotaFragmentView iPerfilMascotaFragmentView, Context context) {
        this.iPerfilMascotaFragmentView = iPerfilMascotaFragmentView;
        this.context = context;
        obtenerInformacionUsuario();
    }


    @Override
    public void obtenerInformacionUsuario() {

        SharedPreferences miPreferenciaCompartida = context.getSharedPreferences("usuario", Context.MODE_PRIVATE);
        final String userId = miPreferenciaCompartida.getString("id",  "");

        if (!userId.equals("")){
            final RestInstagramApiAdapter restInstagramApiAdapter = new RestInstagramApiAdapter();

            final Gson gsonPerfil = restInstagramApiAdapter.construyeGsonDeserializadorPerfil();
            EndPointApi endPointApi = restInstagramApiAdapter.establecerConexionRestApiInstagram(gsonPerfil);

            Call<PerfilResponse> perfilResponseCall = endPointApi.getUserInformation(userId);
            perfilResponseCall.enqueue(new Callback<PerfilResponse>() {

                @Override
                public void onResponse(Call<PerfilResponse> call, Response<PerfilResponse> response) {
                    PerfilResponse perfilResponse = response.body();
                    perfil = perfilResponse.getPerfil();
                    iPerfilMascotaFragmentView.mostrarPerfil(perfil);
                }

                @Override
                public void onFailure(Call<PerfilResponse> call, Throwable t) {
                    Toast.makeText(context, "Problemas en la conexión al servicio intenta de nuevo", Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                    Log.e("FALLO LA CONEXIÓN", t.toString());
                }
            });


            Gson gsonImagenesPerfil = restInstagramApiAdapter.construyeGsonDeserializadorMediaRecent();
            EndPointApi endPointApiPerfil = restInstagramApiAdapter.establecerConexionRestApiInstagram(gsonImagenesPerfil);
            Call<MediaResponse> mediaResponseCall = endPointApiPerfil.getRecentMediaUser(userId);
            mediaResponseCall.enqueue(new Callback<MediaResponse>() {
                @Override
                public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
                    MediaResponse mediaResponse = response.body();
                    perfil.setMascotas(mediaResponse.getMascotas());
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
        iPerfilMascotaFragmentView.inicializarAdaptadorRV(iPerfilMascotaFragmentView.crearAdaptador(this.perfil));
        iPerfilMascotaFragmentView.generarGridLayout();
    }


}
