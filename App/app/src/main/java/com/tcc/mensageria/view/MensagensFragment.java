package com.tcc.mensageria.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tcc.mensageria.R;
import com.tcc.mensageria.controller.ListaAdapter;
import com.tcc.mensageria.model.DadosInventados;
import com.tcc.mensageria.model.ItemDaLista;

import java.util.ArrayList;

/**
 * Created by rjr on 27/08/2016.
 */
public class MensagensFragment extends Fragment implements ListaAdapter.ItemClickCallback {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_MENSAGEM = "EXTRA_MENSAGEM";
    private static final String EXTRA_REMETENTE = "EXTRA_REMETENTE";

    protected RecyclerView recyclerView;
    protected ListaAdapter adapter;
    protected ArrayList dados;
    protected RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        dados = (ArrayList) DadosInventados.getMensagens();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
//        if (id == R.id.action_refresh) {
//        new ControleDados().execute();
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mensagens, container, false);
        //new ControleDados().execute();


        recyclerView = (RecyclerView) rootView.findViewById(R.id.lista_mensagens);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new ListaAdapter(DadosInventados.getMensagens());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

        return rootView;
    }

    @Override
    public void onItemClick(int p) {
        ItemDaLista item = (ItemDaLista) dados.get(p);

        Intent i = new Intent(getActivity(), DetalhesMensagemActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_MENSAGEM, item.getMensagem());
        extras.putString(EXTRA_REMETENTE, item.getRemetente());
        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {
        ItemDaLista item = (ItemDaLista) dados.get(p);
        //update our data
        if (item.isFavorito()) {
            item.setFavorito(false);
        } else {
            item.setFavorito(true);
        }
        //pass new data to adapter and update
        adapter.setListaMensagens(dados);
        adapter.notifyDataSetChanged();

    }
}
