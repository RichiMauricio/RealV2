//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.mauricio.real.actividadDeUsuarios.amigos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mauricio.real.R;
import com.example.mauricio.real.actividadDeUsuarios.amigos.AmigosAtributos;
import com.example.mauricio.real.mensajes.MensajeriaReal;
import java.util.List;

public class AmigosAdapter extends Adapter<AmigosAdapter.HolderAmigos> {
    private List<AmigosAtributos> atributosList;
    private Context context;

    public AmigosAdapter(List<AmigosAtributos> atributosList, Context context) {
        this.atributosList = atributosList;
        this.context = context;
    }

    @Override
    public AmigosAdapter.HolderAmigos onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_amigos, parent, false);
        return new AmigosAdapter.HolderAmigos(v);
    }

    @Override
    public void onBindViewHolder(HolderAmigos holder, final int position) {
        holder.imageViewUser.setImageResource(atributosList.get(position).getFotoPerfil());
        holder.imageViewDominio.setImageResource(atributosList.get(position).getFotoDominio());
        holder.tvNombre.setText((atributosList.get(position)).getNombre());
        holder.tvMensaje.setText((atributosList.get(position)).getMensaje());
        holder.tvHora.setText((atributosList.get(position)).getHora());
        holder.cardview.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(AmigosAdapter.this.context, MensajeriaReal.class);
                i.putExtra("key_receptor", (atributosList.get(position)).getId());
                AmigosAdapter.this.context.startActivity(i);
            }
        });
    }

    public int getItemCount() {
        return this.atributosList.size();
    }

    static class HolderAmigos extends ViewHolder {
        CardView cardview;
        ImageView imageViewUser;
        ImageView imageViewDominio;
        TextView tvNombre;
        TextView tvMensaje;
        TextView tvHora;

        public HolderAmigos(View itemView) {
            super(itemView);
            this.cardview = (CardView)itemView.findViewById(R.id.cvAmigos);
            this.imageViewUser = (ImageView)itemView.findViewById(R.id.imgUserPerfil);
            this.imageViewDominio = (ImageView)itemView.findViewById(R.id.imgDominio);
            this.tvNombre = (TextView)itemView.findViewById(R.id.tvNombreAmigo);
            this.tvMensaje = (TextView)itemView.findViewById(R.id.tvMensajeAmigo);
            this.tvHora = (TextView)itemView.findViewById(R.id.tvHoraAmigo);
        }
    }
}
