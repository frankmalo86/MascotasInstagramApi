package frank.malo.mobiles.app.mascotas.restApi;

/**
 * Created by Frank on 01/10/2016.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/users/self/?access_token=ACCESS-TOKEN

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "204246429.14b2c16.816c425cda4148e48d41bee19b869c89"; //frank_malo
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;



}
