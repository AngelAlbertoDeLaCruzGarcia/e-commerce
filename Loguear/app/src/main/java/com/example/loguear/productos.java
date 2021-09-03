package com.example.loguear;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import org.json.JSONArray;

import android.os.Bundle;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import android.view.View;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class productos extends AppCompatActivity {
    String nom="";
    String exist;
    String precio;

    RequestQueue respues;
    EditText edtNombre,edtPrecio,edtExistencia;
    TextView txtId;
    Button btnGuardar,btnEditar,btnEliminar;
    private ImageView img;
    private Bitmap loadedImage;
    URL nueva=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        edtNombre=(EditText)findViewById(R.id.edtNombre);
        edtPrecio=(EditText)findViewById(R.id.edtPrecio);
        edtExistencia=(EditText)findViewById(R.id.edtExistencia);
        btnGuardar=(Button) findViewById(R.id.btnGuardar);
        btnEditar=(Button) findViewById(R.id.btnEditar);
        btnEliminar=(Button) findViewById(R.id.btnEliminar);


    }
    public void guardarprod(View view){
        verificaguardarp("http://alberto.practicaweb3c.com/guardarprod.php");
    }
    public void verificaguardarp(String URL)
    {
        StringRequest respuesta =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if(!response.equals("null"))
                {

                    try {
                        JSONArray datos = new JSONArray(response);
                        for (int indice = 0; indice < datos.length(); indice++) {

                            JSONObject valores = datos.getJSONObject(indice);

                            nom = valores.getString("vchnombre");
                            precio =valores.getString("fltprecio");
                            exist =valores.getString("intexistencia");

                        }
                    }catch(Exception e)
                    {
                        Toast.makeText(productos.this, "No se guardaron los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(productos.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(productos.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombre",edtNombre.getText().toString());
                parametros.put("precio",edtPrecio.getText().toString());
                parametros.put("existencia",edtExistencia.getText().toString());

                return parametros;
            }
        };
        respues= Volley.newRequestQueue(this);
        respues.add(respuesta);

    }
    public void editar(View view){
        verificaedita("http://alberto.practicaweb3c.com/editar.php");
    }
    public void verificaedita(String URL)
    {
        StringRequest respuesta =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if(!response.equals("null"))
                {

                    try {
                        JSONArray datos = new JSONArray(response);
                        for (int indice = 0; indice < datos.length(); indice++) {

                            JSONObject valores = datos.getJSONObject(indice);

                            nom = valores.getString("vchnombre");
                            precio =valores.getString("fltprecio");
                            exist =valores.getString("intexistencia");

                        }
                    }catch(Exception e)
                    {
                        Toast.makeText(productos.this, "No se guardaron los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(productos.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(productos.this, "Se modifico correctamente", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombre",edtNombre.getText().toString());
                parametros.put("precio",edtPrecio.getText().toString());
                parametros.put("existencia",edtExistencia.getText().toString());

                return parametros;
            }
        };
        respues= Volley.newRequestQueue(this);
        respues.add(respuesta);

    }


    public void eliminar(View view){
        verificaeliminar("http://alberto.practicaweb3c.com/eliminar.php");
    }
    public void verificaeliminar(String URL)
    {
        StringRequest respuesta =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if(!response.equals("null"))
                {
                    String id;
                    try {
                        JSONArray datos = new JSONArray(response);
                        for (int indice = 0; indice < datos.length(); indice++) {

                            JSONObject valores = datos.getJSONObject(indice);

                            id=valores.getString("intidprod");

                        }
                    }catch(Exception e)
                    {
                        Toast.makeText(productos.this, "No se guardaron los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(productos.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(productos.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombre",edtNombre.getText().toString());
                parametros.put("precio",edtPrecio.getText().toString());
                parametros.put("existencia",edtExistencia.getText().toString());

                return parametros;
            }
        };
        respues= Volley.newRequestQueue(this);
        respues.add(respuesta);

    }


    public void buscar(View view){
        verificabuscar("http://alberto.practicaweb3c.com/bucarprod.php");
    }
    public void verificabuscar(String URL)
    {
        StringRequest respuesta =new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.equals("null"))
                {
                    String urla="";
                    try {
                        JSONArray datos = new JSONArray(response);
                        for (int indice = 0; indice < datos.length(); indice++) {

                            JSONObject valores = datos.getJSONObject(indice);

                            txtId.setText(valores.getString("intidprod"));
                            edtNombre.setText(valores.getString("vchnombre"));
                            edtPrecio.setText(valores.getString("fltprecio"));
                            edtExistencia.setText(valores.getString("intexistencia"));
                            urla="alberto.practicaweb3c.com/img/"+valores.getString("vchimg");
                            Toast.makeText(productos.this,urla, Toast.LENGTH_SHORT).show();
                        }
                        verimagen(urla);
                    }catch(Exception e)
                    {
                        Toast.makeText(productos.this, "No se guardaron los datos", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(productos.this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(productos.this, "Guardado", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombre",edtNombre.getText().toString());
                parametros.put("precio",edtPrecio.getText().toString());
                parametros.put("existencia",edtExistencia.getText().toString());

                return parametros;
            }
        };
        respues= Volley.newRequestQueue(this);
        respues.add(respuesta);

    }
    public void verimagen(String url ){
        ImageRequest respuestaimagen=new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                img.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(productos.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        respues.add(respuestaimagen);
    }
    public void regresar(View view){
        Intent vistar= new Intent(productos.this,MainActivity.class);
        startActivity(vistar);
    }

}
