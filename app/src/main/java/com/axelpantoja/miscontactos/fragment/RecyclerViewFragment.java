package com.axelpantoja.miscontactos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.axelpantoja.miscontactos.R;
import com.axelpantoja.miscontactos.adapter.ContactoAdaptador;
import com.axelpantoja.miscontactos.pojo.Contacto;
import com.axelpantoja.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.axelpantoja.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    /*
    public void iniciarDatos() {
        contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.taza_photo, "Alejandro Pantoja", "5571641836", "boyinn2000@yahoo.com.mx", likes));
        contactos.add(new Contacto(R.drawable.android_photo, "Alex Pantoja", "5514412098"));
        contactos.add(new Contacto(R.drawable.google_photo, "Axel Pantoja", "5514169502", "axelazoelmasmejor@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.people_photo, "Casa", "26165036"));
        contactos.add(new Contacto(R.drawable.coco_photo, "Lola Romo", "5537842901", "lolaloliux@gmail.com", likes));
    }*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        listaContactos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
