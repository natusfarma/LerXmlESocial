package br.com.pc.protocolo.classe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo César
 */
public class LerArquivoDeTexto {
    
    private List<String> linhaTexto;

    public LerArquivoDeTexto(java.io.File file, String charsetName) throws FileNotFoundException, IOException {
        inicializar();
        lerArquivo(file, charsetName);
    }
    
    public LerArquivoDeTexto(java.io.File file) throws FileNotFoundException, IOException {
        this(file, Unicode.UTF_8);
    }
    
    private void inicializar(){
        linhaTexto = new ArrayList<>();
    }
    
    private void lerArquivo(java.io.File file, String charsetName) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        try (java.io.BufferedReader ler = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName))) {
            while(ler.ready()){
                getLinhaTexto().add(ler.readLine());
            }
        }
    }

    /**
     * @return the listaSB
     */
    public List<String> getLinhaTexto() {
        return linhaTexto;
    }
    
    
}
