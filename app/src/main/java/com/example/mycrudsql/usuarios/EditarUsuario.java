package com.example.mycrudsql.usuarios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mycrudsql.MySingleton;
import com.example.mycrudsql.R;
import com.example.mycrudsql.Setting_VAR;
import com.example.mycrudsql.dto_productos;
import com.example.mycrudsql.dto_usuarios;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class EditarUsuario extends Fragment {

    private static final String TAG = "EditarUsuario";
    private TextInputLayout ti_id, ti_nombre, ti_apellidos, ti_correo, ti_usuario,  ti_clave, ti_tipo, ti_estado, ti_pregunta, ti_respuesta, ti_fecha;
    private EditText et_id, et_nombre, et_apellidos, et_correo, et_usuario, et_clave, et_respuesta, et_fecha;
    public Spinner sp_tipo, sp_estado, sp_pregunta;
    String datoSelect = "";
public Button btndeleteU,btnUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_editar_usuario, container, false);

        ti_id = root.findViewById(R.id.ti_idusuario);
        ti_nombre = root.findViewById(R.id.ti_nombre);
        ti_apellidos = root.findViewById(R.id.ti_apellido);
        ti_correo = root.findViewById(R.id.ti_correo);
        ti_usuario = root.findViewById(R.id.ti_usuario);
        ti_clave = root.findViewById(R.id.ti_clave);
        //ti_tipo = root.findViewById(R.id.sp_tipo);
        //ti_estado = root.findViewById(R.id.sp_estado);
        //ti_pregunta = root.findViewById(R.id.sp_pregunta);
        //ti_respuesta = root.findViewById(R.id.ti_respuesta);
        //ti_fecha = root.findViewById(R.id.ti_fecha);

        et_id = root.findViewById(R.id.et_idusuario);
        et_nombre = root.findViewById(R.id.et_nombre);
        et_apellidos = root.findViewById(R.id.et_apellido);
        et_correo = root.findViewById(R.id.et_correo);
        et_usuario = root.findViewById(R.id.et_usuario);
        et_clave = root.findViewById(R.id.et_clave);
        sp_tipo = root.findViewById(R.id.sp_tipo);
        sp_estado = root.findViewById(R.id.sp_estado);
        sp_pregunta = root.findViewById(R.id.sp_pregunta);
        et_respuesta = root.findViewById(R.id.et_respuesta);
        et_fecha = root.findViewById(R.id.et_fecha);
        btndeleteU = root.findViewById(R.id.btndeleteU);
        btnUpdate= root.findViewById(R.id.btnUpdate);
        //Boton Eliminar
        btndeleteU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_id.getText().toString();

                // Log.i(TAG, "onClick -> id: " + id );

                eliminarUsu(Integer.parseInt(id));
                Navigation.findNavController(view).navigate(R.id.nav_mostrarUsuarios);
            }
        });
        //Boton Editar
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_id.getText().toString();
                String nombre = et_nombre.getText().toString();
                String apellidos = et_apellidos.getText().toString();
                String correo = et_correo.getText().toString();
                String usuario = et_usuario.getText().toString();
                String clave = et_clave.getText().toString();
                String tipo = sp_tipo.getSelectedItem().toString();
                String estado = sp_estado.getSelectedItem().toString();
                String pregunta = sp_pregunta.getSelectedItem().toString();
                String respuesta = et_respuesta.getText().toString();

                String  fecha_registro  = et_fecha.getText().toString();

                editarUsu(id, nombre,  apellidos,  correo,  usuario,  clave,  Integer.parseInt(tipo), Integer.parseInt(estado),  pregunta,  respuesta , fecha_registro);
                Navigation.findNavController(view).navigate(R.id.nav_mostrarUsuarios);
            }
        });


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.pre, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tipo.setAdapter(adapter2);

        sp_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (sp_tipo.getSelectedItemPosition() > 0) {
                    datoSelect = sp_tipo.getSelectedItem().toString();
                } else {
                    datoSelect = "";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(getContext(),
                R.array.pre2, android.R.layout.simple_spinner_item);
        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_estado.setAdapter(adapter21);

        sp_estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (sp_estado.getSelectedItemPosition() > 0) {
                    datoSelect = sp_estado.getSelectedItem().toString();
                } else {
                    datoSelect = "";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(getContext(),
                R.array.preg, android.R.layout.simple_spinner_item);
        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pregunta.setAdapter(adapter22);

        sp_pregunta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (sp_pregunta.getSelectedItemPosition() > 0) {
                    datoSelect = sp_pregunta.getSelectedItem().toString();
                } else {
                    datoSelect = "";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        et_id.setText(getArguments().getString("id"));
        et_nombre.setText(getArguments().getString("nombre"));
        et_apellidos.setText(getArguments().getString("apellidos"));
        et_correo.setText(getArguments().getString("correo"));
        et_usuario.setText(getArguments().getString("usuario"));
        et_clave.setText(getArguments().getString("clave"));


        sp_tipo.setSelection(adapter2.getPosition(getArguments().getString("tipo")));
        sp_estado.setSelection(adapter21.getPosition(getArguments().getString("estado")));
        sp_pregunta.setSelection(adapter22.getPosition(getArguments().getString("pregunta")));
        et_respuesta.setText(getArguments().getString("respuesta"));
        et_fecha.setText(getArguments().getString("fecha_registro"));


        return root;
    }
    private void eliminarUsu(final int id) {
        final StringRequest request = new StringRequest(Request.Method.POST, Setting_VAR.URL_Eliminar_usuario, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject resquestJSON = null;
                Log.i(TAG, "response:" + response);
                try {
                    resquestJSON = new JSONObject(response.toString());
                    String estado = resquestJSON.getString("estado");
                    String mensaje = resquestJSON.getString("mensaje");

                    if (estado.equals("1")) {
                        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
                        Log.i(TAG ,"estado" + estado);
                    } else if (estado.equals("2")) {
                        Toast.makeText(getContext(), "" + mensaje, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getContext(), "No se puede eliminar.\n" + "Intentelo más tarde.", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json; charset=utf-8");
                map.put("Accept", "application/json");
                map.put("id", String.valueOf(id));
                return map;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(request);
    }

    private void editarUsu(final String id, final String nombre, final String apellidos, final String correo, final String usuario, final String clave, final int tipo, final int estado, final String pregunta, final String respuesta ,final String fecha_registro) {
        final StringRequest request = new StringRequest(Request.Method.POST, Setting_VAR.URL_editarUsuarios, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject resquestJSON = null;
                Log.i(TAG, "response:" + response);
                try {
                    resquestJSON = new JSONObject(response.toString());
                    String estado = resquestJSON.getString("estado");
                    String mensaje = resquestJSON.getString("mensaje");

                    if (estado.equals("1")) {
                        Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
                        Log.i(TAG ,"estado" + estado);
                    } else if (estado.equals("2")) {
                        Toast.makeText(getContext(), "" + mensaje, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getContext(), "No se puede guardar.\n" + "Intentelo más tarde.", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                List<dto_usuarios> ListaUsuario;
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json; charset=utf-8");
                map.put("Accept", "application/json");
                map.put("id", String.valueOf(id));
                map.put("nombre", nombre);
                map.put("apellidos", apellidos);
                map.put("correo", correo);
                map.put("usuario", usuario);
                map.put("clave", clave);
                map.put("tipo", String.valueOf(tipo));
                map.put("estado", String.valueOf( estado));
                map.put("pregunta", pregunta);
                map.put("respuesta", respuesta);
                map.put("fecha_registro", fecha_registro);
                return map;
            }
        };
        MySingleton.getInstance(getContext()).addToRequestQueue(request);
    }
}