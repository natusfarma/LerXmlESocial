package br.com.pc.layout;

import br.com.pc.protocolo.classe.LerArquivoDeTexto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo César
 */
public class LayoutEvAltContratual {
    
    private final File file;
    private final LerArquivoDeTexto ler;
    private String linha; 
    
    private final String tagInicio = "</evtAltContratual>";
    private final String tagCpfTrabalhador = "</cpfTrab>" ;
    private final String tagDataAlterecao = "</dtAlteracao>";
    private final String tagDescricaoAlteracao = "</dscAlt>";
    private final String tagValorSalario = "</vrSalFx>";
    

    public LayoutEvAltContratual(File file) throws Exception {
        this.file = file;
        ler = new LerArquivoDeTexto(file);
        carregar();
    }
    
    private void carregar(){
        for (int i = 0; i < ler.getLinhaTexto().size(); i++) {
            linha = ler.getLinhaTexto().get(i);
            int reciboI = linha.indexOf(tagInicio.replace("/", "").replace(">", ""));
            if (reciboI != -1) {
                linha = linha.substring(reciboI, linha.indexOf(tagInicio));
                //System.out.println(linha);
            }
        }
    }
    
    public String cpfTrabalhador(){
        String tag = tagCpfTrabalhador.replace("/", "");
        int ini = linha.indexOf(tag);
        int fim = linha.indexOf(tagCpfTrabalhador);
        return linha.substring(ini+tag.length(),fim);
    }
    
    public String dataAlterecao(){
        String tag = tagDataAlterecao.replace("/", "");
        int ini = linha.indexOf(tag);
        int fim = linha.indexOf(tagDataAlterecao);
        return linha.substring(ini+tag.length(),fim);
    }
    
    public String descricaoAlteracao(){
        String tag = tagDescricaoAlteracao.replace("/", "");
        int ini = linha.indexOf(tag);
        int fim = linha.indexOf(tagDescricaoAlteracao);
        return linha.substring(ini+tag.length(),fim);
    }
    public String valorSalario(){
        String tag = tagValorSalario.replace("/", "");
        int ini = linha.indexOf(tag);
        int fim = linha.indexOf(tagValorSalario);
        return linha.substring(ini+tag.length(),fim);
    }
    
    
    private ResumoContratual visualizacao(){
        ResumoContratual resumoContratual = new ResumoContratual();
        resumoContratual.setCpfTrabalhador(cpfTrabalhador());
        resumoContratual.setDataAlterecao(dataAlterecao());
        resumoContratual.setDescricaoAlteracao(descricaoAlteracao());
        resumoContratual.setValorSalario(valorSalario());
        return resumoContratual;
    }
    
    public List<ResumoContratual> dadosEmpregado() throws Exception{
        List<ResumoContratual> listaResumoContratual = new ArrayList<>();
        ResumoContratual resumoContratual = visualizacao();
        listaResumoContratual.add(resumoContratual);
        return listaResumoContratual;
    }
    
//    public static void main(String[] args) throws Exception {
//        //File f = new File("E:\\netbeans\\LerXmlEsocial\\xml\\ID1086985430000002018122018043700000.S-2200.xml");
//        //File f = new File("E:\\netbeans\\LerXmlEsocial\\xml\\ID1086985430000002018122018044700019.S-2200.xml");
//        File f = new File("C:\\Users\\Paulo-PC\\Downloads\\ID1086985430000002023010217052513134.S-2206.xml");
//        
//        
//        LayoutEvAltContratual layout = new LayoutEvAltContratual(f);
//        
//        System.out.println(layout.cpfTrabalhador());
//        System.out.println(layout.dataAlterecao());
//        System.out.println(layout.descricaoAlteracao());
//        System.out.println(layout.valorSalario());
//        
//        for (ResumoContratual arg : layout.dadosEmpregado()) {
//            System.out.println("\t"+arg);
//        }
//        
//        //System.out.println(layout.visualizacao());
//    }
    
    
}
