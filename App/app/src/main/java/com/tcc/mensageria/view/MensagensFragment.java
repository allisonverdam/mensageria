package com.tcc.mensageria.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tcc.mensageria.R;
import com.tcc.mensageria.controller.ListaAdapter;
import com.tcc.mensageria.controller.MensageriaService;
import com.tcc.mensageria.model.Mensagem;

import java.util.ArrayList;

public class MensagensFragment extends Fragment implements ListaAdapter.ItemClickCallback {
    private final String LOG_TAG = MensageriaService.class.getSimpleName();
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_MENSAGEM = "EXTRA_MENSAGEM";
    private static final String EXTRA_REMETENTE = "EXTRA_REMETENTE";

    private RecyclerView recyclerView;
    private ListaAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView viewVazia;
    private Context context;

    //static enquanto nao tem banco de dados
    public static ArrayList listaMensagens;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            popularLista();
            if (!listaVazia()) {
                adapter.setListaMensagens(listaMensagens);
                adapter.notifyDataSetChanged();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mensagens, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.lista_mensagens);
        viewVazia = (TextView) rootView.findViewById(R.id.view_vazia);

        popularLista();
        listaVazia();

        mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ListaAdapter(listaMensagens);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);

        return rootView;
    }

    @Override
    public void onItemClick(int p) {
        Mensagem item = (Mensagem) listaMensagens.get(p);

        Intent i = new Intent(context, DetalhesMensagemActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_MENSAGEM, item.getConteudo());
        extras.putString(EXTRA_REMETENTE, item.getRemetente());
        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }

    @Override
    public void onSecondaryIconClick(int p) {
        Mensagem item = (Mensagem) listaMensagens.get(p);
        //update our data
        if (item.isFavorito()) {
            item.setFavorito(false);
        } else {
            item.setFavorito(true);
        }
        //pass new data to adapter and update
        adapter.setListaMensagens(listaMensagens);
        adapter.notifyDataSetChanged();

    }

    private void popularLista() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String endereco = sharedPref.getString(getString(R.string.pref_endereco_key)
                , getString(R.string.endereco_default));

        Intent intent = new Intent(context, MensageriaService.class);
        intent.putExtra(MensageriaService.ENDERECO_EXTRA, endereco);

        context.startService(intent);
    }

    private boolean listaVazia() {
        if (listaMensagens == null) {
            recyclerView.setVisibility(View.GONE);
            viewVazia.setVisibility(View.VISIBLE);
            return true;
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            viewVazia.setVisibility(View.GONE);
            return false;
        }
    }
}
