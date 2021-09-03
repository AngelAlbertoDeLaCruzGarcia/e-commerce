package com.example.loguear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {
    private Button btnacceder;
    private EditText edtUsuario,edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=(EditText)findViewById(R.id.edtUsuario);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnacceder=(Button)findViewById(R.id.btnacceder);
    }
    public void ver(View view){
        verificausuario("http://alberto.practicaweb3c.com/login.php");
    }
    public void verificausuario(String URL)
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
                        Intent vistap=new Intent(getApplicationContext(),productos.class);
                        vistap.putExtra("nombre",nom);

                        startActivity(vistap);
                    }catch(Exception e)
                    {
                        Toast.makeText(MainActivity.this, "No se pudieron obtener los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Usuario y passw incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Revisa la conexion a wifi o datos", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("usuario",edtUsuario.getText().toString());
                parametros.put("password",edtPassword.getText().toString());

                return parametros;
            }
        };
        RequestQueue respues= Volley.newRequestQueue(this);
        respues.add(respuesta);
    }
    public void agregar(View view){
        Intent vistan=new Intent(MainActivity.this,Registro.class);
        startActivity(vistan);
    }


}
