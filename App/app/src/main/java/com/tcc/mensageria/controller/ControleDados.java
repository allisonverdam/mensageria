package com.tcc.mensageria.controller;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rjr on 25/08/2016.
 */
public class ControleDados extends AsyncTask<Void, Void, String> {

    private final String LOG_TAG = ControleDados.class.getSimpleName();

    @Override
    protected String doInBackground(Void... params) {

        HttpURLConnection conexao = null;
        BufferedReader leitor = null;

        String JsonString = null;

        try {
            String URL_BASE = "http://189.71.16.96:8080/cliente";

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
}
