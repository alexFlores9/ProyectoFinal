package com.example.mycrudsql;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.UsuViewHolder> {
    private static final String TAG = "Adapter";
    private Context mCtx;
    private List<dto_usuarios> usuList;

    public Adapter2 (Context mCtx, List<dto_usuarios> usuList){
        this.mCtx = mCtx;
        this.usuList = usuList;
    }

    private TextView getTextView(View v, int id_u){
        return v.findViewById(id_u);
    }

    @Override
    public UsuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout2, viewGroup, false);
        UsuViewHolder viewHolder = new UsuViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuViewHolder holder, int position) {
        holder.textViewId.setText(String.valueOf(usuList.get(position).getId()));
        holder.textViewNombreUsu.setText(usuList.get(position).getNombre());
        holder.textViewApellidoUsu.setText(usuList.get(position).getApellidos());
        holder.textViewCorreo.setText(usuList.get(position).getCorreo());
        holder.textViewUsuario.setText(usuList.get(position).getUsuario());
        holder.textViewClave.setText(usuList.get(position).getClave());
        holder.textViewTipo.setText(String.valueOf(usuList.get(position).getTipo()));
        holder.textViewEstado.setText(String.valueOf(usuList.get(position).getEstado()));
        holder.textViewPregunta.setText(usuList.get(position).getPregunta());
        holder.textViewRespuesta.setText(usuList.get(position).getRespuesta());
        holder.textViewFecha_Registro.setText(usuList.get(position).getFecha_registro());

    }

    @Override
    public int getItemCount() {
        return  usuList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class UsuViewHolder extends RecyclerView.ViewHolder{
        TextView textViewId, textViewNombreUsu, textViewApellidoUsu,textViewCorreo, textViewUsuario,
                textViewClave, textViewTipo, textViewEstado, textViewPregunta,
                textViewRespuesta, textViewFecha_Registro;

        public UsuViewHolder(View itemView) {
            super(itemView);

            textViewId = itemView.findViewById(R.id.textViewIdUsua);
            textViewNombreUsu = itemView.findViewById(R.id.textViewNombreUsu);
            textViewApellidoUsu = itemView.findViewById(R.id.textViewApellidos);
            textViewCorreo = itemView.findViewById(R.id.textViewCorreo);
            textViewUsuario = itemView.findViewById(R.id.textViewUsuario);
            textViewClave = itemView.findViewById(R.id.textViewClave);
            textViewTipo = itemView.findViewById(R.id.textViewTipoUsu);
            textViewEstado = itemView.findViewById(R.id.textViewEstadoUsu);
            textViewPregunta = itemView.findViewById(R.id.textViewPregunta);
            textViewRespuesta = itemView.findViewById(R.id.textViewRespuesta);
            textViewFecha_Registro = itemView.findViewById(R.id.textViewFechaUsu);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View vvv) {

                    String id = getTextView(vvv, R.id.textViewIdUsua).getText().toString();
                    String nombre = getTextView(vvv, R.id.textViewNombreUsu).getText().toString();
                    String apellidos = getTextView(vvv, R.id.textViewApellidos).getText().toString();
                    String correo = getTextView(vvv, R.id.textViewCorreo).getText().toString();
                    String usuario = getTextView(vvv, R.id.textViewUsuario).getText().toString();
                    String clave = getTextView(vvv, R.id.textViewClave).getText().toString();
                    String tipo = getTextView(vvv, R.id.textViewTipoUsu).getText().toString();
                    String estado = getTextView(vvv, R.id.textViewEstadoUsu).getText().toString();
                    String pregunta = getTextView(vvv, R.id.textViewPregunta).getText().toString();
                    String respuesta = getTextView(vvv, R.id.textViewRespuesta).getText().toString();
                    String fecha_registro = getTextView(vvv, R.id.textViewFechaUsu).getText().toString();

                    Bundle aa = new Bundle();

                    aa.putString("id", id);
                    aa.putString("nombre", nombre);
                    aa.putString("apellidos", apellidos);
                    aa.putString("correo", correo);
                    aa.putString("usuario", usuario);
                    aa.putString("clave", clave);
                    aa.putString("tipo", tipo);
                    aa.putString("estado", estado);
                    aa.putString("pregunta", pregunta);
                    aa.putString("respuesta", respuesta);
                    aa.putString("fecha_registro", fecha_registro);

                   Navigation.findNavController(vvv).navigate(R.id.nav_editarUsuario, aa);
                }
            });
        }
    }
}
