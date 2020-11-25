package com.example.mycrudsql.usuarios;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mycrudsql.Adapter;
import com.example.mycrudsql.Adapter2;
import com.example.mycrudsql.R;
import com.example.mycrudsql.Setting_VAR;
import com.example.mycrudsql.dto_usuarios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MostrarUsuarios extends Fragment {
    private RecyclerView listaUsu;
    dto_usuarios adaptador2;
    List<dto_usuarios> Usuario_Lista;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_mostrar_usuarios, container, false);
        listaUsu = root.findViewById(R.id.listaUsu);
        listaUsu.setHasFixedSize(true);
        listaUsu.setLayoutManager(new LinearLayoutManager(this.getContext()));

        Usuario_Lista = new ArrayList<>();

        loadusuarios();
        return root;
    }

    private void loadusuarios(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Setting_VAR.URL_consultaAllUsuarios, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject usuarios = array.getJSONObject(i);
                        Usuario_Lista.add(new dto_usuarios(
                                usuarios.getInt("id"),
                                usuarios.getString("nombre"),
                                usuarios.getString("apellidos"),
                                usuarios.getString("correo"),
                                usuarios.getString("usuario"),
                                usuarios.getString("clave"),
                                usuarios.getInt("tipo"),
                                usuarios.getInt("estado"),
                                usuarios.getString("pregunta"),
                                usuarios.getString("respuesta"),
                                usuarios.getString("fecha_registro")
                        ));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Adapter2 adapter2 = new Adapter2(getContext(), Usuario_Lista);
                listaUsu.setAdapter(adapter2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}