package com.example.loguear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    EditText edtUser,edtPass;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        edtPass=(EditText)findViewById(R.id.edtPass);
        edtUser=(EditText)findViewById(R.id.edtUser);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);
    }
    public void guardar(View view){
        verificaguardar("http://alberto.practicaweb3c.com/guardar.php");
    }
    public void verificaguardar(String URL)
    {
        StringRequest respuesta =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if(!response.equals("null"))
                {
                    String nom="";
                    String pass="";
                    try {
                        JSONArray datos = new JSONArray(response);
                        for (int indice = 0; indice < datos.length(); indice++) {

                            JSONObject valores = datos.getJSONObject(indice);

                            nom = valores.getString("vchuser");
                            pass = valores.getString("vchpassword");

                        }
                        Intent vistap=new Intent(getApplicationContext(),Principal.class);
                        vistap.putExtra("nombre",nom);
                        vistap.putExtra("passwd",pass);
                        startActivity(vistap);
                    }catch(Exception e)
                    {
                        Toast.makeText(Registro.this, "No se guardaron los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Registro.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Registro.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("usuario",edtUser.getText().toString());
                parametros.put("password",edtPass.getText().toString());

                return parametros;
            }
        };
        RequestQueue respues= Volley.newRequestQueue(this);
        respues.add(respuesta);
    }

}
