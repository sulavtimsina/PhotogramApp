package com.example.sulav.constraintlayouttry;

import android.os.AsyncTask;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnRegister;
    TextView tvStatus;

    private static final  String DB_URL = "jdbc:mysql://localhost:3306/photogram_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.tvEmail);
        etPassword = findViewById(R.id.tvPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvStatus = findViewById(R.id.tvStatus);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new Send().execute("");
                runPhp2();
            }
        });
    }
//    private void runPhp(){
//
//        String url = "http://192.168.0.102/test.php";
//        final RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                tvStatus.setText(response);
//                requestQueue.stop();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                tvStatus.setText(error.getMessage());
//                requestQueue.stop();
//            }
//        });
//        requestQueue.add(stringRequest);
//    }

    private void runPhp2(){

                String url = "http://192.168.0.102/test.php";
        final RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvStatus.setText(response);
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
                params.put("email", etEmail.getText().toString());
                params.put("password", etPassword.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    private class Send extends AsyncTask<String, String, String>{

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String msg = "";

        @Override
        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Toast.makeText(RegisterActivity.this, "hello here", Toast.LENGTH_SHORT).show();
                if(connection == null){
                    msg = "connection is not working";
                } else{
                    String query = "INSERT INTO users(email, password) values('"+email+"','"+password+"')";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    msg = "registration successful";
                }
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return msg;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            tvStatus.setText(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }
}
