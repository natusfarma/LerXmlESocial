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
public abstract class PrincipalPai extends PainelPrincipal{

    protected File fileAbrir;
    protected File[] fileAbrirMult;
    protected File fileSalvar;
    //private JFileChooser fChooser;
    //protected List<Resumo> listaResumo;
    
    public PrincipalPai() {
        inicializar();
    }
    
    private void inicializar(){
        
        //listaResumo = new ArrayList<>();
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
    
    
    
    public void btProcessar(){}
 
 
    
    public void ckGerarArquivo(){
        fileSalvar = salvar(this);
        if (fileSalvar != null) {
            if (!fileSalvar.getName().contains(".")) {
                fileSalvar = new File(fileSalvar.getPath()+".csv");
            }
        }else{
            ckGerarArquivo.setSelected(false);
        }
    }

    
    public java.io.File abrir(java.awt.Component parent){
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
    
    public java.io.File salvar(java.awt.Component parent){
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
