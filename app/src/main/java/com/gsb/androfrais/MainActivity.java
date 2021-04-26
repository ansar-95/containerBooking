package com.gsb.androfrais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gsb.androfrais.classesMetier.NukeSSLCerts;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        new NukeSSLCerts().nuke();
    }

    public void authentification(View aView) {

        final Button buttonLogin =
                (Button)findViewById(R.id.buttonIdentification);
        final EditText editTextLogin =
                (EditText) findViewById(R.id.editTextIdentifiant);
        final EditText editTextPassword = 	(EditText)findViewById(R.id.editTextMotDePasse);


        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        final String login = editTextLogin.getText().toString();
        final String password = editTextPassword.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://217.167.171.231/ws-zstockage/public/index.php/api/login";
        StringRequest sr = new StringRequest( //début de l’initialisation
                Request.Method.POST,
                url,

                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        JSONObject connected = null;
                        try {
                            connected = new JSONObject(response);
                            boolean state = connected.getBoolean("connected");
                            if (state) {
                              Intent myIntent = new Intent(MainActivity.this, HomeActivty.class);
                              startActivity(myIntent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            String err = e.getMessage();
                            Log.e("MainActivity", "JsonException" + err);
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err = error.getMessage();
                        Log.e("MainActivity", err);
                    }
                })

                {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("login", login);
                        params.put("password", password);
                        return params;
                    }
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Content-Type", "application/x-www-form-urlencoded");
                        return params;
                    }
                };//fin de l’initialisation

                queue.add(sr);



    }



}
