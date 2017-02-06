package com.axelpantoja.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.axelpantoja.miscontactos.R;
import com.axelpantoja.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Axel on 19/01/2017.
 */

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        /*ArrayList<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.taza_photo, "Alejandro Pantoja", "5571641836", "boyinn2000@yahoo.com.mx", 5));
        contactos.add(new Contacto(R.drawable.android_photo, "Alex Pantoja", "5514412098", 3));
        contactos.add(new Contacto(R.drawable.google_photo, "Axel Pantoja", "5514169502", "axelazoelmasmejor@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.people_photo, "Casa", "26165036", 9));
        contactos.add(new Contacto(R.drawable.coco_photo, "Lola Romo", "5537842901", "lolaloliux@gmail.com", 15)); */

        BaseDatos db = new BaseDatos(context);

        insertarTresContactos(db);

        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Axel Pantoja");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5514169502");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "axelazoelmasmejor@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.google_photo);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Alex Pantoja");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5514412098");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.android_photo);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Lola Romo");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "5537842901");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "lolaloliux@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.coco_photo);

        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto) {
        BaseDatos bd = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);

        bd.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
