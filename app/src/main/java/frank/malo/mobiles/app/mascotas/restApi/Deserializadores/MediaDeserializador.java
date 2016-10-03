package frank.malo.mobiles.app.mascotas.restApi.Deserializadores;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import frank.malo.mobiles.app.mascotas.pojo.Mascota;
import frank.malo.mobiles.app.mascotas.restApi.JsonKeys;
import frank.malo.mobiles.app.mascotas.restApi.model.MediaResponse;

/**
 * Created by Frank on 01/10/2016.
 */

public class MediaDeserializador implements JsonDeserializer<MediaResponse> {

    @Override
    public MediaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MediaResponse mediaResponse = gson.fromJson(json, MediaResponse.class);
        JsonArray mascotaResponseData  = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        mediaResponse.setMascotas(deseralizarMascotaDeJson(mascotaResponseData));
        return mediaResponse;
    }

    public ArrayList<Mascota> deseralizarMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject contactoResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            JsonObject userJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombre = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imagesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imagesJson.getAsJsonObject(JsonKeys.MEDIA_LOW_RESOLUTION);
            String urlFoto = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int puntaje = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(id);
            mascotaActual.setNombre(nombre);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setPuntaje(puntaje);

            mascotas.add(mascotaActual);
        }
        return mascotas;
    }
}
