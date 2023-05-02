package com.example.proyectofinaldtifernandez;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Lista extends AppCompatActivity {//Inicia clase

    public TextView tvSalidaPrecio;
    public ListView lvProductos;
    public ImageView ivLogoL;

    private String[] productos = {"Sudaderas","Playeras","Gorras","Shorts","Olimpicas","Oversized"};
    private String[] precios = {"$300","$200","$250","$170","$230","$240"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {//Inicia metodo onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        //Integracion de xml con java
        tvSalidaPrecio = findViewById(R.id.tvSalidaP);
        lvProductos =(ListView) findViewById(R.id.lvProductos);
        ivLogoL = findViewById(R.id.ivLogoL);

        //adaptacion de arreglos de precios y arreglo de productos mediante un adapter
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,productos);
        lvProductos.setAdapter(adapter);//integra los datos de  producto en la lista
        //Programacion del evento click se determina el precio de un producto
        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int imagenId = obtenerImagenId(position);
                ivLogoL.setImageResource(imagenId);

                tvSalidaPrecio.setText("Precio venta: "+ precios[position]);


            }
        });



    }//Termina metodo onCreate
    private int obtenerImagenId(int position) {
        switch (position) {
            case 0:
                return R.drawable.sudadera;
            case 1:
                return R.drawable.playera;
            case 2:
                return R.drawable.gorras;
            case 3:
                return R.drawable.conjunto;
            case 4:
                return R.drawable.olimpica;
            case 5:
                return R.drawable.over;
            default:
                return R.drawable.logoprop;
        }
    }
}//Termina clase