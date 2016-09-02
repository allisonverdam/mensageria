package com.tcc.mensageria.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.tcc.mensageria.R;
import com.tcc.mensageria.model.Mensagem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by rjr on 25/08/2016.
 */
public class ControleDados extends AsyncTask<Void, Void, ArrayList<Mensagem>> {

    private final String LOG_TAG = ControleDados.class.getSimpleName();
    private ArrayList<Mensagem> listaMensagens;
    private Context context;

    public ControleDados(Context context) {
        this.context = context;
    }

    @Override
    protected ArrayList<Mensagem> doInBackground(Void... params) {
        listaMensagens = ParseJson(getJSON());
        return listaMensagens;
    }

    private String getJSON() {
        HttpURLConnection conexao = null;
        BufferedReader leitor = null;
        String JsonString = null;

        try {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            String URL_BASE = "http://";
            String endereco = sharedPref.getString(context.getString(R.string.pref_endereco_key)
                    , context.getString(R.string.endereco_default));
            URL_BASE += endereco;
            URL url = new URL(URL_BASE);

            conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.connect();


            InputStream inputStream = conexao.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {
                return null;
            }
            leitor = new BufferedReader(new InputStreamReader(inputStream));

            String linha;
            while ((linha = leitor.readLine()) != null) {
                buffer.append(linha + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }

            JsonString = buffer.toString();
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            return null;
        } finally {
            if (conexao != null) {
                conexao.disconnect();
            }
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }
        return JsonString;
    }

    public ArrayList<Mensagem> ParseJson(String JSON) {
        if (JSON == null) {
            return null;
        }

        ArrayList<Mensagem> data = new ArrayList<Mensagem>();

        try {
            JSONArray jsonArray = new JSONArray(JSON);
            for (int i = 0; i < jsonArray.length(); i++) {
                Mensagem mensagem = new Mensagem();
                JSONObject objeto = jsonArray.getJSONObject(i);
                mensagem.setConteudo(objeto.getString("conteudo"));
                mensagem.setTitulo(objeto.getString("titulo"));
                JSONObject remetente = objeto.getJSONObject("remetente");
                mensagem.setRemetente(remetente.getString("contato"));
                data.add(mensagem);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

}

