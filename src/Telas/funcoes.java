/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Andre
 */
public class funcoes {

    public String obterMusica(String musi) {

        String musica = musi.replace(" ", "-");
        
        try {
            Document doc = Jsoup.connect("https://www.cifraclub.com.br" + musica).get();
            Elements el = doc.getElementsByClass("cifra_cnt g-fix cifra-mono");
            String titulo = doc.getElementsByClass("g-side-ad").select("h1").text();
            String cantor = doc.getElementsByClass("g-side-ad").select("h2").text();

            return titulo + "\n" + cantor + "\n\n" + el.text();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "https://www.cifraclub.com.br" + musica + "\nnao encontrado");
        }
            return null;
    }
    
}
