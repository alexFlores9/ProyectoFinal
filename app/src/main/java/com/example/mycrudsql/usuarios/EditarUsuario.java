package com.example.mycrudsql.usuarios;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mycrudsql.R;
import com.example.mycrudsql.dto_usuarios;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class EditarUsuario extends Fragment {

    private static final String TAG = "EditarUsuario";
    private TextInputLayout ti_id, ti_nombre, ti_apellidos, ti_correo, ti_usuario,  ti_clave, ti_tipo, ti_estado, ti_pregunta, ti_respuesta, ti_fecha;
    private EditText et_id, et_nombre, et_apellidos, et_correo, et_usuario, et_clave, et_respuesta, et_fecha;
    public Spinner sp_tipo, sp_estado, sp_pregunta;
    String datoSelect = "";

    private List<dto_usuarios> Usuario_Lista;

    public static EditarUsuario newInstance(String param1, String param2) {
        EditarUsuario fragment = new EditarUsuario();

        return fragment;
    }

    public EditarUsuario() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

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
        sp_tipo = root.findViewById(R.id.sp_tipo);
        sp_estado = root.findViewById(R.id.sp_estado);
        sp_pregunta = root.findViewById(R.id.sp_pregunta);
        et_respuesta = root.findViewById(R.id.et_respuesta);
        //et_fecha = root.findViewById(R.id.et_fechaU);


    ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(getContext(),
            R.array.pre, android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tipo.setAdapter(adapter0);
        sp_tipo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*if (sp_tipo.getSelectedItemPosition() > 0) {
                    datoSelect = sp_tipo.getSelectedItem().toString();
                } else {
                    datoSelect = "";
                }*/
            }

        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.estadoU, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_estado.setAdapter(adapter);

        sp_estado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.preg, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_pregunta.setAdapter(adapter1);
        sp_pregunta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return root;
    }
}