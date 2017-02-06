package com.axelpantoja.miscontactos.restApi.model;

import com.axelpantoja.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by axelpantoja on 05/02/17.
 */

public class ContactoResponse {

    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
