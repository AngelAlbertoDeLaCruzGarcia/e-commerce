package com.example.loguear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;


public class Principal extends AppCompatActivity {
    private TextView txtU,txtP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        datos();
    }
    public void datos()
    {
        txtU=(TextView)findViewById(R.id.txtUser);
        txtP=(TextView)findViewById(R.id.txtPass);
        Bundle parametros= getIntent().getExtras();
        String d1=parametros.getString("nombre");
        String d2=parametros.getString("passwd");
        txtU.setText(d1);
        txtP.setText(d2);
    }
    public void cerrar(View view){
        Intent vistar= new Intent(Principal.this,MainActivity.class);
        startActivity(vistar);
    }
}