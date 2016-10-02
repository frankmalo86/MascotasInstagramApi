package frank.malo.mobiles.app.mascotas.restApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.restApi.model.MascotaResponse;

/**
 * Created by Frank on 01/10/2016.
 */

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        /*Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray contactoResponseData  = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        contactoResponse.setContactos(deseralizarContactoDeJson(contactoResponseData));
        return contactoResponse;*/
        return null;

    }

    /*public ArrayList<Contacto> deseralizarContactoDeJson(JsonArray contactoResponseData){
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        for (int i = 0; i < contactoResponseData.size(); i++) {
            JsonObject contactoResponseDataObject = contactoResponseData.get(i).getAsJsonObject();
            JsonObject userJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imagesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imagesJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Contacto contactoActual = new Contacto();
            contactoActual.setId(id);
            contactoActual.setNombre_completo(nombreCompleto);
            contactoActual.setUrlFoto(urlFoto);
            contactoActual.setLikes(likes);

            contactos.add(contactoActual);
        }
        return contactos;
    }*/
}
