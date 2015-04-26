/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;


/**
 *
 * @author Lorenz
 */
public class PdfGenerator {

    private String bron;
    private String doel;

    public PdfGenerator() {
        reset();
    }

    public PdfGenerator(String bron, String doel) {
        this.bron = bron;
        this.doel = doel;
    }

    public void generatePDF() {

        try {
            String File_To_Convert = bron;
            String url = new File(File_To_Convert).toURI().toURL().toString();
            String HTML_TO_PDF = doel;
            String HTML_STRING = "";

            OutputStream os = new FileOutputStream(HTML_TO_PDF);

            ITextRenderer renderer = new ITextRenderer();
            //renderer.setDocumentFromString( HTML_STRING);  //for well formatted HTML String
            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void reset() {
        bron = "";
        doel = "";
    }
}
