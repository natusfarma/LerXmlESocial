package br.com.pc.form;

import br.com.pc.layout.Resumo;
import br.com.pc.protocolo.classe.GerarArquivo;
import br.com.pc.protocolo.classe.Iniciar;
import br.com.pc.protocolo.classe.IniciarPai;
import br.com.pc.protocolo.classe.Unicode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo César
 */
public class Principal extends PrincipalPai{

    private List<Resumo> listaResumo;
    public static final String TITULO = "evtAdmissao";

    public Principal() {
        inicializar();
    }
    
    private void inicializar(){
        listaResumo = new ArrayList<>();
    }
    
    
    @Override
    public void btProcessar(){
        IniciarPai<Resumo> iniciar;
        if (ckMultiplos.isSelected()) {
            iniciar = new Iniciar(fileAbrirMult,listaResumo);
        }else{
            iniciar = new Iniciar(fileAbrir,listaResumo);
        }
        texteArea.setText("");
        for (Resumo resumo : iniciar.getListaResumo()) {
            texteArea.append(resumo.toString());
            texteArea.append(System.lineSeparator());
            if (fileSalvar != null) {
                try {
                    new GerarArquivo(fileSalvar, resumo.toString(),Unicode.ISO_8859_1 , true);
                } catch (Exception ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Não foi possível gerar o arquivo."+ex.getMessage());
                }
            }
        }
        if (iniciar.getErro().isEmpty()) return;
        texteArea.append("-----------------------ERRO--------------------------");
        texteArea.append(System.lineSeparator());
        iniciar.getErro().stream().forEach((arg) -> {
            texteArea.append(arg);
            texteArea.append(System.lineSeparator());
        });
        if (fileSalvar != null) {
            if (fileSalvar.isFile()) {
                javax.swing.JOptionPane.showMessageDialog(null, "O arquivo "+fileSalvar.getPath()+" gerado com sucesso");
            }
        }
        
    }
    
    
}
