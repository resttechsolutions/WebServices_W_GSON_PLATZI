/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resttechsoutions.gatosapp.services;

import com.google.gson.Gson;
import com.resttechsoutions.gatosapp.beans.Gatos;
import com.resttechsoutions.gatosapp.beans.GatosFav;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Estrella
 */
public class GatosService {

    public static void verGatos() throws IOException {
        OkHttpClient client = new OkHttpClient();
//                .newBuilder()
//                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        String elJSON = response.body().string();

//        Eliminar corchetes
        elJSON = elJSON.substring(1, elJSON.length());
        elJSON = elJSON.substring(0, elJSON.length() - 1);

        Gson gson = new Gson();

        Gatos gatos = gson.fromJson(elJSON, Gatos.class);

        //REDIMENCIONAR LA IMAGEN
        Image img = null;

        try {
            URL url = new URL(gatos.getUrl());

            img = ImageIO.read(url);

            ImageIcon bgGato = new ImageIcon(img);

            if (bgGato.getIconWidth() > 800) {
                Image bg = bgGato.getImage();
                Image modificada = bg.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                bgGato = new ImageIcon(modificada);
            }

            String menu = "Opciones: \n"
                    + "1. Ver otra imagen\n"
                    + "2. Favorito\n"
                    + "3. Volver al menu\n";

            String[] botones = {"ver otra imagen", "favoritos", "voler"};
            String idGato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null,
                    menu,
                    idGato,
                    JOptionPane.INFORMATION_MESSAGE,
                    bgGato,
                    botones,
                    botones[0]);

            int seleccion = -1;

            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    seleccion = i;
                }
            }

            switch (seleccion) {
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void favoritoGato(Gatos gato) {
        try {

            OkHttpClient client = new OkHttpClient();
//                    .newBuilder()
//                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\"" + gato.getId() + "\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getAPIKEY())
                    .build();
            Response response = client.newCall(request).execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verFavoritos(String apikey) throws IOException {
        OkHttpClient client = new OkHttpClient();
//                .newBuilder()
//                .build();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/favourites")
                .method("GET", null)
                .addHeader("x-api-key", apikey)
                .build();
        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        Gson gson = new Gson();

        GatosFav[] gatosArray = gson.fromJson(elJson, GatosFav[].class);

        if (gatosArray.length > 0) {
            int aleatorio = (int) Math.random() * ((gatosArray.length - 1) + 1) + 1;

            int indice = aleatorio - 1;

            GatosFav gf = gatosArray[indice];

            //REDIMENCIONAR LA IMAGEN
            Image img = null;

            try {
                URL url = new URL(gf.getImage().getUrl());

                img = ImageIO.read(url);

                ImageIcon bgGato = new ImageIcon(img);

                if (bgGato.getIconWidth() > 800) {
                    Image bg = bgGato.getImage();
                    Image modificada = bg.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                    bgGato = new ImageIcon(modificada);
                }

                String menu = "Opciones: \n"
                        + "1. Ver otra imagen\n"
                        + "2. Eliminar favorito\n"
                        + "3. Volver al menu\n";

                String[] botones = {"ver otra imagen", "eliminar favorito", "voler"};
                String idGato = gf.getId();
                String opcion = (String) JOptionPane.showInputDialog(null,
                        menu,
                        idGato,
                        JOptionPane.INFORMATION_MESSAGE,
                        bgGato,
                        botones,
                        botones[0]);

                int seleccion = -1;

                for (int i = 0; i < botones.length; i++) {
                    if (opcion.equals(botones[i])) {
                        seleccion = i;
                    }
                }

                switch (seleccion) {
                    case 0:
                        verFavoritos(apikey);
                        break;
                    case 1:
                        borrarFavorito(gf);
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void borrarFavorito(GatosFav gf) {
        try {
            OkHttpClient client = new OkHttpClient();
//                    .newBuilder()
//                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites/" + gf.getId() + "")
                    .method("DELETE", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gf.getAPIKEY())
                    .build();
            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
