package com.example.proyectofinaldtifernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btnLogin;
    public EditText etNombre;
    public EditText etContra;
    public ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo = findViewById(R.id.ivLogo);

        etNombre=findViewById(R.id.etNombre);
        etContra=findViewById(R.id.etContra);
        btnLogin=findViewById(R.id.btnLogin);

        ivLogo.setImageResource(R.drawable.logoprop);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNombre.getText().toString().equals("Afti") && etContra.getText().toString().equals("pro123")){//condicion si se cumple es decir es verdadera
                    Intent intent10 = new Intent(MainActivity.this, Menu.class);
                    startActivityForResult(intent10,0);
                }else{//condicion falsa
                    Toast.makeText(MainActivity.this,"Usuario y/o Contraseña incorrectos\nVerifica!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}