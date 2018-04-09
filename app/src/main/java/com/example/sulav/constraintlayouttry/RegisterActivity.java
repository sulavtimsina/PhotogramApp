package com.example.sulav.constraintlayouttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText etFirstName, etLastname, etEmail, etPassword, etRePassword;
    Button btnRegister,  btnLogin ;
    String firstName, lastname, email, password, rePassword;
    TextView tvStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUI();
    }

    private void setupUI() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastname = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        tvStatus = findViewById(R.id.tvStatus);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runRegisterScript();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openLoginActivity();
            }
        });
    }

    private void runRegisterScript(){
        tvStatus.setText("");
        Toast.makeText(this, "Register started", Toast.LENGTH_SHORT).show();
        String url = "http://10.0.2.2/photogram_app/register.php";

        firstName = etFirstName.getText().toString();
        lastname = etLastname.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        rePassword = etRePassword.getText().toString();

        if(! password.equals(rePassword)){
            etPassword.setText("");
            etRePassword.setText("");
            tvStatus.setText("The two Passwords don't match! Enter Again!");
            return;
        }

        runVolleyString(url);
//        runVolleyObject(url);
//        runVolleyArray(url);


    }

    private void runVolleyObject(String url) {
        final RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    tvStatus.setText(response.getString("status") + ": "+response.getString("message"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvStatus.setText("xxx2"+error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("firstname", firstName);
                params.put("lastname", lastname);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        requestQueue.add(jsonRequest);
    }

    private void runVolleyArray(String url) {

        final RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                tvStatus.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvStatus.setText(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("firstname", firstName);
                params.put("lastname", lastname);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        requestQueue.add(jsonRequest);
    }

    private void runVolleyString(String url){
//        String url2 = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
        final RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
//                    JSONObject jheroes = (JSONObject) obj.getJSONArray("heroes").get(0);
                    String t = obj.getString("message");
                    tvStatus.setText(t);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvStatus.setText(error.getMessage());
                requestQueue.stop();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("firstname", firstName);
                params.put("lastname", lastname);
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }
}
