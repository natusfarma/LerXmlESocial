package br.com.pc.layout;

import br.com.pc.protocolo.classe.LerArquivoDeTexto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo César
 */
public class Layout {
    
    private final File file;
    private final LerArquivoDeTexto ler;
    private String linha;
    private int trabalhoI;
    private int trabalhoF;
    private int reciboI;
    private int nrReciboI;
    private int cpfTrabI;
    private int nmTrabI;
    private int matriculaI;
    private final String tagRecibo = "<recibo><nrRecibo>";
    private final String tagTrabalhador = "<trabalhador><cpfTrab>";
    private final String tagTrabalhadorF = "</tpRegTrab>";
    private final String tagNrRecibo = "</nrRecibo>";
    private final String tagCpfTrab = "</cpfTrab>";
    private final String tagNmTrab = "</nmTrab>";
    private final String tagMatricula = "</matricula>";
    

    public Layout(File file) throws Exception {
        this.file = file;
        ler = new LerArquivoDeTexto(file);
        carregar();
    }
    
    private void carregar(){
        for (int i = 0; i < ler.getLinhaTexto().size(); i++) {
            linha = ler.getLinhaTexto().get(i);
            reciboI = linha.indexOf(tagRecibo);
            if (reciboI != -1) {
                linha = linha.substring(reciboI);
            }
        }
    }

    
    private void iniCabecalho(){
        for (int i = 0; i < ler.getLinhaTexto().size(); i++) {
            linha = ler.getLinhaTexto().get(i);
            trabalhoI = linha.indexOf(tagTrabalhador);
            trabalhoF = linha.indexOf(tagTrabalhadorF);
            if (trabalhoI != -1) {
                linha = linha.substring(trabalhoI, trabalhoF);
            }
        }
    }
    
    public String nrRecibo(){
        String tag = tagNrRecibo.replace("/", "");
        nrReciboI = linha.indexOf(tag);
        int nrReciboF = linha.indexOf(tagNrRecibo);
        return linha.substring(nrReciboI+tag.length(), nrReciboF);
    }
    
    public String cpfTrab1(){
        String tag = tagCpfTrab.replace("/", "");
        cpfTrabI = linha.indexOf(tag);
        int cpfTrabF = linha.indexOf(tagCpfTrab);
        return linha.substring(cpfTrabI+tag.length(), cpfTrabF);
    }
    
    public String cpfTrab(){
        String tag = tagCpfTrab.replace("/", "");
        cpfTrabI = linha.indexOf(tag);
        int cpfTrabF = linha.indexOf(tagCpfTrab);
        if (cpfTrabI != -1) {
            return linha.substring(cpfTrabI+tag.length(), cpfTrabF);    
        }
        iniCabecalho();
        cpfTrabI = linha.indexOf(tag);
        cpfTrabF = linha.indexOf(tagCpfTrab);
        return linha.substring(cpfTrabI+tag.length(), cpfTrabF);
    }
    
    public String matricula(){
        String tag = tagMatricula.replace("/", "");
        matriculaI = linha.indexOf(tag);
        int matriculaF = linha.indexOf(tagMatricula);
        return linha.substring(matriculaI+tag.length(), matriculaF);
    }
    
    public String nmTrab(){
        String tag = tagNmTrab.replace("/", "");
        nmTrabI = linha.indexOf(tag);
        int cpfTrabF = linha.indexOf(tagNmTrab);
        return linha.substring(nmTrabI+tag.length(), cpfTrabF);
    }
    
    
    private Resumo visualizacao(){
        Resumo resumo = new Resumo();
        resumo.setNrRecibo(nrRecibo());
        resumo.setCpfTrabalhador(cpfTrab());
        resumo.setNmTrabalhador(nmTrab());
        resumo.setMatricula(matricula());
        return resumo;
    }
    
    public List<Resumo> dadosEmpregado() throws Exception{
        List<Resumo> listaResumo = new ArrayList<>();
        Resumo resumo = visualizacao();
        listaResumo.add(resumo);
        return listaResumo;
    }
    
//    public static void main(String[] args) throws Exception {
//        //File f = new File("E:\\netbeans\\LerXmlEsocial\\xml\\ID1086985430000002018122018043700000.S-2200.xml");
//        //File f = new File("E:\\netbeans\\LerXmlEsocial\\xml\\ID1086985430000002018122018044700019.S-2200.xml");
//        File f = new File("C:\\Users\\Paulo-PC\\Desktop\\xml\\ID1043159720000002021111610310900000.S-2200.xml");
//        
//        
//        Layout layout = new Layout(f);
//        
//        System.out.println(layout.nrRecibo());
//        System.out.println(layout.cpfTrab());
//        System.out.println(layout.nmTrab());
//        System.out.println(layout.matricula());
//        
//        //System.out.println(layout.visualizacao());
//    }
    
}
