/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class pdf {
    
    public void gerar(String musi,String pasta){
        
        String musica = musi.replace(" ", "-");
        
        funcoes f = new funcoes();
        Document doc = new Document();
        String[] nomeMusica = musica.split("/");
        try {
            try {
                File file = new File(pasta+"\\"+nomeMusica[1]);
                file.mkdir();
                PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()+"\\"+nomeMusica[2]+".pdf"));
                doc.open();
                doc.add(new Paragraph(f.obterMusica(musica)));
            } catch (DocumentException ex) {
                Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
            doc.close();
        
        
        
        
    }
    
}
