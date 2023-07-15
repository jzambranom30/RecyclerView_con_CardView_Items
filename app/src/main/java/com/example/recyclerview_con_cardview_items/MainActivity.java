package com.example.recyclerview_con_cardview_items;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerview_con_cardview_items.Adaptadores.AdaptadorUser;
import com.example.recyclerview_con_cardview_items.Modelos.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView LstOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LstOp = (ListView) findViewById(R.id.ListUsers);
        LstOp.setOnItemClickListener(this);

        String url = "https://dummyjson.com/users";

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonOb = null;
                try {
                    jsonOb = new JSONObject(response);
                    JSONArray jsonArray = jsonOb.getJSONArray("users");
                    ArrayList<User> arrayList = User.JsonObjectsBuild(jsonArray);
                    AdaptadorUser adaptadorUser = new AdaptadorUser(MainActivity.this, arrayList);
                    LstOp.setAdapter(adaptadorUser);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Error: " +
                        error.networkResponse.statusCode, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(req);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        User user = (User) parent.getItemAtPosition(position);
        Intent intent = new Intent(MainActivity.this, UserDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ein", user.getEin());
        bundle.putString("email", user.getEmail());
        bundle.putString("maiden", user.getMaidenName());
        bundle.putString("domain", user.getDomain());
        bundle.putString("username", user.getUsername());
        bundle.putString("phone", user.getPhone());
        bundle.putString("name", user.getName());
        bundle.putString("image", user.getImage());
        intent.putExtras(bundle);
        startActivity(intent);

        Toast.makeText(MainActivity.this, "Ha seleccionado a: "
                +user.getName(),Toast.LENGTH_SHORT).show();
    }
}