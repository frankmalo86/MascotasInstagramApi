package frank.malo.mobiles.app.mascotas.restApi;

/**
 * Created by Frank on 01/10/2016.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/users/self/?access_token=ACCESS-TOKEN

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3992079915.57d3b68.bb2c8c65f40c4320be6e0c52c7d99268"; //mascotafm
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    public static final String KEY_GET_RECENT_MEDIA_SELF = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_SELF = KEY_GET_RECENT_MEDIA_SELF + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_GET_RECENT_MEDIA_USER = "users/{user-id}/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String KEY_GET_INFORMATION_USER = "users/{user-id}/";
    public static final String URL_GET_INFORMATION_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}
