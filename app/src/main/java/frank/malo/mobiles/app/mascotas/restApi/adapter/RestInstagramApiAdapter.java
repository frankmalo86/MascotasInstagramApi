package frank.malo.mobiles.app.mascotas.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import frank.malo.mobiles.app.mascotas.restApi.ConstantesRestApi;
import frank.malo.mobiles.app.mascotas.restApi.EndPointApi;
import frank.malo.mobiles.app.mascotas.restApi.Deserializadores.MediaDeserializador;
import frank.malo.mobiles.app.mascotas.restApi.Deserializadores.PerfilDeserializador;
import frank.malo.mobiles.app.mascotas.restApi.model.MediaResponse;
import frank.malo.mobiles.app.mascotas.restApi.model.PerfilResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Frank on 01/10/2016.
 */

public class RestInstagramApiAdapter {

    public EndPointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndPointApi.class);
    }

    //asocia el adaptador con la clase de respuesta
    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MediaResponse.class, new MediaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorPerfil(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilDeserializador());
        return gsonBuilder.create();
    }
}
