package com.axelpantoja.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleContacto extends AppCompatActivity {

    /*private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;*/

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        /*Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        //Agarra datos enviados con el intent
        Bundle datos = getIntent().getExtras();

        String url = datos.getString("url");
        int likes = datos.getInt("likes");

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));
        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.coco_photo)
                .into(imgFotoDetalle);

        /*String nombre = datos.getString(getResources().getString(R.string.pnombre));
        String telefono = datos.getString(getResources().getString(R.string.ptelefono));
        String email = datos.getString(getResources().getString(R.string.pemail));

        getSupportActionBar().setTitle(nombre);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);

        if (email == null) {
            ImageView imgvMail = (ImageView) findViewById(R.id.imgvMail);
            tvEmail.setText(null);
            imgvMail.setVisibility(View.INVISIBLE);
        } else {
            tvEmail.setText(email);
        }*/
    }

    /*public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void enviarMail(View v) {
        String[] email = {tvEmail.getText().toString()};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.setData(Uri.parse("mailto"));
        emailIntent.setType("message/rfc8222");

        startActivity(Intent.createChooser(emailIntent, "Enviar email: "));
    }*/

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
