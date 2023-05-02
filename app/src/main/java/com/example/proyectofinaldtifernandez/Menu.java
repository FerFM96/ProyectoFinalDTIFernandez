package com.example.proyectofinaldtifernandez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    public Button btnCRUD;
    public Button btnPrecios;
    public ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//inicia metodo onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //integra xml-java
        ivLogo = findViewById(R.id.imageView2);
        btnCRUD = findViewById(R.id.btnCRUD);
        btnPrecios = findViewById(R.id.btnPrecios);
        ivLogo.setImageResource(R.drawable.logoprop);

        btnPrecios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //accion o intento. proceso para abrir la nueva ventana
                Intent abrirVentana1 = new Intent(view.getContext(), Lista.class);
                startActivityForResult(abrirVentana1, 0);

            }
        });

        btnCRUD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //accion o intento. proceso para abrir la nueva ventana
                Intent abrirVentana2 = new Intent(view.getContext(), CRUD.class);
                startActivityForResult(abrirVentana2, 0);

            }
        });
    }
}
