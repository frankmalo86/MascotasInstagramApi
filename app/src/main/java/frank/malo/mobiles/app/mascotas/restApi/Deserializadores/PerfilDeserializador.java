package frank.malo.mobiles.app.mascotas.restApi.Deserializadores;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import frank.malo.mobiles.app.mascotas.pojo.Perfil;
import frank.malo.mobiles.app.mascotas.restApi.JsonKeys;
import frank.malo.mobiles.app.mascotas.restApi.model.PerfilResponse;

/**
 * Created by Frank on 02/10/2016.
 */

public class PerfilDeserializador implements JsonDeserializer<PerfilResponse> {


    @Override
    public PerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PerfilResponse perfilResponse = gson.fromJson(json, PerfilResponse.class);
        JsonObject userData  = json.getAsJsonObject().getAsJsonObject(JsonKeys.USER_DATA);
        String nombre = userData.get(JsonKeys.USER_FULLNAME).getAsString();
        String id = userData.get(JsonKeys.USER_ID).getAsString();
        String urlFoto = userData.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();

        Perfil perfil = new Perfil();
        perfil.setNombre(nombre);
        perfil.setUrlFoto(urlFoto);
        perfil.setId(id);

        perfilResponse.setPerfil(perfil);

        return perfilResponse;
    }
}
