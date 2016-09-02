package com.tcc.mensageria.model;

/**
 * Created by rjr on 25/08/2016.
 */
public class Mensagem {
    private int foto;
    private String remetente;
    private String conteudo;
    private String titulo;
    private boolean favorito = false;

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String mensagem) {
        this.conteudo = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

