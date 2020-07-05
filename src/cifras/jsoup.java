/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifras;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Andre
 */
public class jsoup {

    public ArrayList conectar(String artist) throws IOException {

        String artista = artist.replace(" ", "-");
        /**
         * @Função Conecta com o cifra clube e retorna a parte final dos links das cifras
         */
        
        Document doc = Jsoup.connect("https://www.cifraclub.com.br/" + artista + "/").get();
        Elements pagina = doc.getElementsByClass("list-links art_musics all listSongArtist").select("li");
        ArrayList a = new ArrayList();
        pagina.forEach((e) -> {
            a.add(e.select("a").get(0).attr("href"));
        });

        return a;

    }

}
