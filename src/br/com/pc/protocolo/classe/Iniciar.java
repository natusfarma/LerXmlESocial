package br.com.pc.protocolo.classe;

import br.com.pc.layout.Layout;
import br.com.pc.layout.Resumo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo César
 */
public class Iniciar {
    
    private File file;
    private File[] files = null;
    private final List<String> erro;
    private final List<Resumo> listaResumo;
    private File copia;

    public Iniciar(File file, List<Resumo> listaResumo) {
        this.file = file;
        this.listaResumo = listaResumo;
        erro = new ArrayList<>();
        inicializar();
    }
    
    public Iniciar(File[] files, List<Resumo> listaResumo) {
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
    
    
    private void principal(File arquivo) throws Exception{
        Layout layout = new Layout(arquivo);
        listaResumo.addAll(layout.dadosEmpregado());
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
    public List<Resumo> getListaResumo() {
        return listaResumo;
    }
    
}
