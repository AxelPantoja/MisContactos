package com.axelpantoja.miscontactos.fragment;

import com.axelpantoja.miscontactos.adapter.ContactoAdaptador;
import com.axelpantoja.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by Axel on 19/01/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
