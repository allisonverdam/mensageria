package com.tcc.mensageria.model;

import com.tcc.mensageria.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjr on 25/08/2016.
 */
public class DadosInventados {
    private static final String[] mensagens = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus cursus non diam " +
                    "ac aliquet. Donec pharetra, diam id rhoncus dictum, nunc odio ultrices augue, " +
                    "eu rutrum ante neque ut nisl. Sed ac nisl erat. Curabitur posuere turpis odio," +
                    " sit amet fermentum ante dignissim ut." + " Vivamus in mi maximus velit euismod" +
                    " pharetra eu id metus. Integer",
            "Nullam quis porta augue. Nam aliquam justo quam, in vehicula nunc convallis vel." +
                    " Ut sagittis luctus risus, sit amet tincidunt elit dignissim quis. Phasellus" +
                    " varius vestibulum libero, sit amet convallis diam iaculis in. Ut feugiat ",
            "tincidunt dictum. Vestibulum elit magna, laoreet sit amet blandit eu, porttitor" +
                    " in augue. Etiam cursus felis quam, sit amet cursus tortor tempor aliquam." +
                    " Curabitur fringilla pretium facilisis. Aliquam erat volutpat. Integer sed" +
                    " tortor nec erat consectetur suscipit vitae eget dui. Donec vitae ex turpis." +
                    " Praesent id tempor tortor. Proin ac venenatis lorem. ",
            "Donec faucibus sollicitudin enim, eget luctus massa. Etiam convallis purus a libero " +
                    "facilisis maximus. Pellentesque blandit finibus ullamcorper. Morbi iaculis " +
                    "libero dolor, at sollicitudin mauris commodo vel. Proin ex lacus, consequat" ,
            " id risus vitae, pretium fringilla quam. Praesent faucibus augue nec orci " +
                    "laoreet, non blandit ex vestibulum. Praesent porta sapien sed euismod pretium." +
                    " Sed efficitur egestas justo vitae sodales. ",
            "ula congue, sit amet laoreet ligula pellentesque. Donec tempus mauris lectus, ac " +
                    "dignissim erat venenatis sed. Nulla euismod augue ac neque pulvinar semper." +
                    " Cras eget nunc turpis. Duis commodo est bibendum urna fermentum, ac ornare " +
                    "neque elementum. Aenean ultrices, nunc id consequat congue, ligula ante cursus" +
                    " enim, eg"
    };
    private static final String[] remetente = {"Bruce",
            "Marcos",
            "José Augusto",
            "Maria da Silva",
            "Leandro",
            "Alex Azevedo",
            "Jim"

    };
    private static final int foto = R.drawable.ic_tonality_black_24dp;

    public static List<ItemDaLista> getMensagens() {
        List<ItemDaLista> data = new ArrayList<>();

        for (int x = 0; x < 4; x++) {
            for (int i = 0; i < mensagens.length; i++) {
                ItemDaLista item = new ItemDaLista();
                item.setMensagem(mensagens[i]);
                item.setRemetente(remetente[i]);
                data.add(item);
            }
        }
        return data;
    }
}