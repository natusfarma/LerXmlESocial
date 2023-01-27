package br.com.pc.form;

import br.com.pc.layout.Resumo;
import br.com.pc.protocolo.classe.CsvType;
import br.com.pc.protocolo.classe.FiltroCsv;
import br.com.pc.protocolo.classe.FiltroXml;
import br.com.pc.protocolo.classe.GerarArquivo;
import br.com.pc.protocolo.classe.XmlType;
import br.com.pc.protocolo.classe.Iniciar;
import br.com.pc.protocolo.classe.Unicode;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Paulo César
 */
public class Principal extends painelPrincipal{

    private File fileAbrir;
    private File[] fileAbrirMult;
    private File fileSalvar;
    //private JFileChooser fChooser;
    private List<Resumo> listaResumo;
    
    public Principal() {
        inicializar();
    }
    
    private void inicializar(){
        
        listaResumo = new ArrayList<>();
        //fChooser = new JFileChooser();
        texteArea.setLineWrap(true);
        texteArea.setEditable(false);
        tfCaminho.setEditable(false);
        ativar(true);
        
        btCaminho.addActionListener((ActionEvent e) -> {
            if (ckMultiplos.isSelected()) {
                btCaminhoMult();
            }else{
                btCaminho();
            }
        });
        
        btProcessar.addActionListener((ActionEvent e) -> {
            btProcessar();
        });
        
        ckGerarArquivo.addActionListener((ActionEvent e) -> {
            if (ckGerarArquivo.isSelected()) {
                ckGerarArquivo();
            }
        });
    }
    
    private void btCaminho(){
        fileAbrir = abrir(this);
        if (fileAbrir != null) {
            tfCaminho.setText(fileAbrir.getPath());
            desativar(true);
        }else{
            tfCaminho.setText("");
            desativar(false);
        }
    }
    
    private void btCaminhoMult(){
        fileAbrirMult = abrirMult(this);
        if (fileAbrirMult != null) {
            tfCaminho.setText(fileAbrirMult[0].getParent());
            desativar(true);
        }else{
            tfCaminho.setText("");
            desativar(false);
        }
    }
    
    
    
    private void btProcessar(){
        Iniciar iniciar;
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
    
    private void ckGerarArquivo(){
        fileSalvar = salvar(this);
        if (fileSalvar != null) {
            if (!fileSalvar.getName().contains(".")) {
                fileSalvar = new File(fileSalvar.getPath()+".csv");
            }
        }else{
            ckGerarArquivo.setSelected(false);
        }
    }

    
    private java.io.File abrir(java.awt.Component parent){
        JFileChooser fChooser = new JFileChooser();
        fChooser.setFileView(new XmlType());
        fChooser.addChoosableFileFilter(new FiltroXml());
        fChooser.setAcceptAllFileFilterUsed(false);
        java.io.File file = null;
        int returnVal = fChooser.showOpenDialog(parent);
        fChooser.setMultiSelectionEnabled(false);
        fChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            file = fChooser.getSelectedFile();
        } 
        return file;
    }
    
    private java.io.File salvar(java.awt.Component parent){
        JFileChooser fChooser = new JFileChooser();
        fChooser.setFileView(new CsvType());
        fChooser.addChoosableFileFilter(new FiltroCsv());
        fChooser.setAcceptAllFileFilterUsed(false);
        java.io.File file = null;
        int returnVal = fChooser.showSaveDialog(parent);
        fChooser.setMultiSelectionEnabled(false);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            file = fChooser.getSelectedFile();
        }
        
        return file;
    }
    
    public java.io.File[] abrirMult(java.awt.Component parent){
        JFileChooser fChooser = new JFileChooser();
        fChooser.setFileView(new XmlType());
        fChooser.addChoosableFileFilter(new FiltroXml());
        fChooser.setAcceptAllFileFilterUsed(false);
        java.io.File[] file = null;
        fChooser.setMultiSelectionEnabled(true);
        int returnVal = fChooser.showOpenDialog(parent);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            file = fChooser.getSelectedFiles();
        } 
        return file;
    }
    
    private void desativar(boolean ativar){
        btProcessar.setEnabled(ativar);
        ckGerarArquivo.setEnabled(ativar);
    }
    
    private void ativar(boolean ativar){
        desativar(!ativar);
        btCaminho.setEnabled(ativar);
    }
}
