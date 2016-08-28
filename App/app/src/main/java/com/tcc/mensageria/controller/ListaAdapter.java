package com.tcc.mensageria.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tcc.mensageria.R;
import com.tcc.mensageria.model.ItemDaLista;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjr on 25/08/2016.
 */
public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {

    private List<ItemDaLista> listaMensagens;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback {
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public ListaAdapter(List<ItemDaLista> listaMensagens) {
        this.listaMensagens = listaMensagens;
    }

    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_mensagens, parent, false);
        return new ListaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, int posicao) {
        ItemDaLista item = listaMensagens.get(posicao);
        holder.conteudo.setText(item.getMensagem());
        holder.remetente.setText(item.getRemetente());
        if (item.isFavorito()) {
            holder.favorito.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            holder.favorito.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return listaMensagens.size();
    }

    class ListaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView foto;
        ImageView favorito;
        TextView conteudo;
        TextView remetente;
        View container;

        public ListaViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            favorito = (ImageView) itemView.findViewById(R.id.favorito);
            favorito.setOnClickListener(this);
            remetente = (TextView) itemView.findViewById(R.id.remetente);
            conteudo = (TextView) itemView.findViewById(R.id.conteudo);
            container = (View) itemView.findViewById(R.id.container_mensagem);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.container_mensagem) {
                itemClickCallback.onItemClick(getAdapterPosition());
            } else {
                itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }
        }
    }

    public void setListaMensagens(ArrayList<ItemDaLista> listaMensagens) {
        this.listaMensagens.clear();
        this.listaMensagens.addAll(listaMensagens);
    }
}