package br.com.pc.protocolo.classe;

import br.com.pc.layout.Layout;
import br.com.pc.layout.Resumo;
import java.io.File;
import java.util.List;

/**
 *
 * @author Paulo César
 */
public class Iniciar extends IniciarPai<Resumo>{

    public Iniciar(File[] files, List<Resumo> listaResumo) {
        super(files, listaResumo);
    }
    
    public Iniciar(File file, List<Resumo> listaResumo) {
        super(file, listaResumo);
    }
  
    @Override
    public void principal(File arquivo) throws Exception{
        Layout layout = new Layout(arquivo);
        getListaResumo().addAll(layout.dadosEmpregado());
    }

    
}
