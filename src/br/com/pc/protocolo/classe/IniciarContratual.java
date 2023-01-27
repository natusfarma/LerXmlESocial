package br.com.pc.protocolo.classe;

import br.com.pc.layout.Layout;
import br.com.pc.layout.LayoutEvAltContratual;
import br.com.pc.layout.Resumo;
import br.com.pc.layout.ResumoContratual;
import java.io.File;
import java.util.List;

/**
 *
 * @author Paulo César
 */
public class IniciarContratual extends IniciarPai<ResumoContratual>{
    
    public IniciarContratual(File[] files, List<ResumoContratual> listaResumo) {
        super(files, listaResumo);
    }
    
    public IniciarContratual(File file, List<ResumoContratual> listaResumo) {
        super(file, listaResumo);
    }
  
    @Override
    public void principal(File arquivo) throws Exception{
        LayoutEvAltContratual layout = new LayoutEvAltContratual(arquivo);
        getListaResumo().addAll(layout.dadosEmpregado());
    }
}
