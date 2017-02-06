package com.axelpantoja.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.axelpantoja.miscontactos.db.ConstructorContactos;
import com.axelpantoja.miscontactos.pojo.Contacto;
import com.axelpantoja.miscontactos.DetalleContacto;
import com.axelpantoja.miscontactos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Axel on 30/12/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    private ArrayList<Contacto> contactos;
    private Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    @Override //Infla el layout y lo pasa al viewHolder para obtener los views.
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);

        return new ContactoViewHolder(v);
    }

    @Override //Asocia cada elemento de la lista con cada view.
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);

        //holder.imgFoto.setImageResource(contacto.getFoto());
        Picasso.with(activity)
                .load(contacto.getUrlFoto())
                .placeholder(R.drawable.coco_photo)
                .into(holder.imgFoto);

        //holder.tvNombreCV.setText(contacto.getNombre());
        //holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvLikes.setText(String.valueOf(contacto.getLikes()));

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent detalles = new Intent(activity, DetalleContacto.class);

                /*detalles.putExtra("nombre", contacto.getNombre());
                detalles.putExtra("telefono", contacto.getTelefono());
                detalles.putExtra("email", contacto.getEmail());*/

                detalles.putExtra("url", contacto.getUrlFoto());
                detalles.putExtra("likes", contacto.getLikes());

                activity.startActivity(detalles);
            }
        });

        /*holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundResource(R.drawable.ic_like_on);

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);

                holder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikesContacto(contacto)) + " Likes");
            }
        });*/
    }

    @Override //Tamaño de lista.
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        //private TextView tvNombreCV;
        //private TextView tvTelefonoCV;
        //private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            /*tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);*/
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }

}
