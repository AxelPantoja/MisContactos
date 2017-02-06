package com.axelpantoja.miscontactos.restApi.adapter;

import com.axelpantoja.miscontactos.restApi.ConstantesRestApi;
import com.axelpantoja.miscontactos.restApi.EndpointsApi;
import com.axelpantoja.miscontactos.restApi.deserializador.ContactoDeserializador;
import com.axelpantoja.miscontactos.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by axelpantoja on 05/02/17.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());

        return gsonBuilder.create();
    }

}
