package com.tcc.mensageria.controller;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.tcc.mensageria.model.Mensagem;
import com.tcc.mensageria.view.MensagensFragment;

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


public class MensageriaService extends IntentService {

    private final String TAG = MensageriaService.class.getSimpleName();
    public static final String ENDERECO_EXTRA = "ende";

    public MensageriaService() {
        super("Mensageria");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        HttpURLConnection conexao = null;
        BufferedReader leitor = null;
        String JsonString = null;

        try {
            String URL_BASE = "http://";
            String endereco = intent.getStringExtra(ENDERECO_EXTRA);
            URL_BASE += endereco;
            URL url = new URL(URL_BASE);

            conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.connect();


            InputStream inputStream = conexao.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {
                return;
            }
            leitor = new BufferedReader(new InputStreamReader(inputStream));

            String linha;
            while ((linha = leitor.readLine()) != null) {
                buffer.append(linha + "\n");
            }

            if (buffer.length() == 0) {
                return;
            }

            JsonString = buffer.toString();
            MensagensFragment.listaMensagens = ParseJson(JsonString);
        } catch (IOException e) {
            Log.e(TAG, "Error ", e);
        } finally {
            if (conexao != null) {
                conexao.disconnect();
            }
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (final IOException e) {
                    Log.e(TAG, "Error closing stream", e);
                }
            }
        }
    }

    public ArrayList<Mensagem> ParseJson(String JSON) {
        if (JSON == null) {
            return null;
        }

        ArrayList<Mensagem> data = new ArrayList<>();

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

    public static class AlarmReceiver extends BroadcastReceiver {
        private final String TAG = AlarmReceiver.class.getSimpleName();
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent sendIntent = new Intent(context, MensageriaService.class);
            sendIntent.putExtra(MensageriaService.ENDERECO_EXTRA, intent.getStringExtra(MensageriaService.ENDERECO_EXTRA));
            context.startService(sendIntent);
            Log.d(TAG, "onReceive: ");
        }
    }
}

