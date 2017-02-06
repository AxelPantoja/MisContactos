package com.axelpantoja.miscontactos.restApi;

/**
 * Created by axelpantoja on 05/02/17.
 */

public final class ConstantesRestApi {

    //Formar la URL base:
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;

    //Access token:
    public static final String ACCESS_TOKEN = "4559161735.5e98204.2324065bee8b40fa9e399e6f6f62f9c1";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    //Keys-rutas:
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";

    //Peticiones:
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN +
            ACCESS_TOKEN; //-> https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS_TOKEN

}
