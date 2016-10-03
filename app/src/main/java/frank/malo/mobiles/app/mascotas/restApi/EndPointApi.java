package frank.malo.mobiles.app.mascotas.restApi;

import frank.malo.mobiles.app.mascotas.restApi.model.MediaResponse;
import frank.malo.mobiles.app.mascotas.restApi.model.PerfilResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Frank on 01/10/2016.
 */

public interface EndPointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MediaResponse> getRecentMediaUser(@Path("user-id") String userId);

    //@GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_SELF)
    //Call<MediaResponse> getRecentMediaSelf();

    @GET(ConstantesRestApi.URL_GET_INFORMATION_USER)
    Call<PerfilResponse> getUserInformation(@Path("user-id") String userId);

}
