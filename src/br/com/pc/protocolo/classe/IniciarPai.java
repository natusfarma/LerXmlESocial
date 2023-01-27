package br.com.pc.protocolo.classe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo César
 * @param <T>
 */
public abstract class IniciarPai<T> {
    
    private File file;
    private File[] files = null;
    private final List<String> erro;
    private final List<T> listaResumo;
    private File copia;

    public IniciarPai(File file, List<T> listaResumo) {
        this.file = file;
        this.listaResumo = listaResumo;
        erro = new ArrayList<>();
        inicializar();
    }
    
    public IniciarPai(File[] files, List<T> listaResumo) {
        this.files = files;
        this.listaResumo = listaResumo;
        erro = new ArrayList<>();
        diretorios();
    }
    
    private void inicializar() {
        if (file.isDirectory()) {
            diretorio();
        }else{
            try {
                principal(file);
            } catch (Exception ex) {
                erro.add("O arquivo "+file.getPath()+" não é válido." );
            }
        }
    }
    
    private void diretorio(){
        for (File f : file.listFiles()) {
            try {
                if (f.isFile()) {
                    copia = f;
                    principal(f);
                }
            } catch (Exception e) {
                erro.add("O arquivo "+copia.getPath()+" não é válido." );
            }
        }                
    }
    
    
    private void diretorios(){
        for (File f : files) {
            try {
                if (f.isFile()) {
                    copia = f;
                    principal(f);
                }
            } catch (Exception e) {
                erro.add("O arquivo "+copia.getPath()+" não é válido." );
            }
        }                
    }
    
    
    public void principal(File arquivo) throws Exception{
       
    }

    /**
     * @return the erro
     */
    public List<String> getErro() {
        return erro;
    }

    /**
     * @return the listaResumo
     */
    public List<T> getListaResumo() {
        return listaResumo;
    }
    
}
