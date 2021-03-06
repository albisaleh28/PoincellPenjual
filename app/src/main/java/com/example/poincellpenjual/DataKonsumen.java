package com.example.poincellpenjual;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.poincellpenjual.adapter.KonsumenListAdapter;
import com.example.poincellpenjual.models.Konsumen;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataKonsumen extends AppCompatActivity {


    private RecyclerView rvKonsumen;
    private final ArrayList<Konsumen> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_konsumen);

        rvKonsumen = findViewById(R.id.rv_konsumen);
        rvKonsumen.setHasFixedSize(true);

        getDataKonsumen();

    }

    public void getDataKonsumen() {
        String URL_GET_DATA = "http://192.168.1.8/poincell/penjual/getDataKonsumen.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("RESPONSE ", response);
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i =0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);
                                Konsumen k = new Konsumen();
                                k.setId(obj.getString("id_konsumen"));
                                k.setNama_konsumen(obj.getString("nama_konsumen"));
                                k.setNo_telepon_konsumen(obj.getString("no_telepon_konsumen"));
                                k.setAlamat_konsumen(obj.getString("alamat_konsumen"));
                                k.setEmail_konsumen(obj.getString("nama_konsumen"));
                                k.setPoin_konsumen(obj.getString("poin_konsumen"));

                                list.add(k);
                            }
                            showRecyclerList();
                        } catch (Exception e) {
                            Log.e("ERROR", e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("KONTOL ERROR", error.getMessage());
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

    private void showRecyclerList(){
        Log.e("INI Test", String.valueOf(list.size()));
        rvKonsumen.setLayoutManager(new LinearLayoutManager(this));
        KonsumenListAdapter listHeroAdapter = new KonsumenListAdapter(list);
        rvKonsumen.setAdapter(listHeroAdapter);
    }
}