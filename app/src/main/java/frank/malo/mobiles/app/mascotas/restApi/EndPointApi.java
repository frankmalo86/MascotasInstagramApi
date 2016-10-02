package frank.malo.mobiles.app.mascotas.restApi;

import frank.malo.mobiles.app.mascotas.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Frank on 01/10/2016.
 */

public interface EndPointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

}
