//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.mauricio.real.actividadDeUsuarios.amigos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mauricio.real.R;
import com.example.mauricio.real.actividadDeUsuarios.amigos.AmigosAdapter;
import com.example.mauricio.real.actividadDeUsuarios.amigos.AmigosAtributos;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Fragment_ListaAmigos extends Fragment {
    private List<AmigosAtributos> atributosList;
    private AmigosAdapter adapter;
    private RecyclerView rv;
    private EventBus bus;

    public Fragment_ListaAmigos() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_amigos, container, false);
        bus = EventBus.getDefault();
        atributosList = new ArrayList();
        rv = (RecyclerView)v.findViewById(R.id.rvAmigos);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        adapter = new AmigosAdapter(atributosList,getContext());
        rv.setAdapter(adapter);
        return v;
    }

    public void agregarAmigo(int fotoPerfil, String id, String nombre, String mensaje, String hora, int fotoDominio) {
        AmigosAtributos amigosAtributos = new AmigosAtributos();
        amigosAtributos.setFotoPerfil(fotoPerfil);
        amigosAtributos.setId(id);
        amigosAtributos.setMensaje(mensaje);
        amigosAtributos.setNombre(nombre);
        amigosAtributos.setHora(hora);
        amigosAtributos.setFotoDominio(fotoDominio);
        atributosList.add(amigosAtributos);
        adapter.notifyDataSetChanged();
    }

    public void agregarAmigo(AmigosAtributos amigosAtributos) {
        this.atributosList.add(amigosAtributos);
        this.adapter.notifyDataSetChanged();
    }

    public void solicitudJSON() {
    }

    @Subscribe
    public void ejecutarLlamada(AmigosAtributos amigosAtributos) {
        agregarAmigo(amigosAtributos);
    }

    public void onPause() {
        super.onPause();
        bus.unregister(this);
    }

    public void onResume() {
        super.onResume();
        bus.register(this);
    }
}
