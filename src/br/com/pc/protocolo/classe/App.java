package br.com.pc.protocolo.classe;

import br.com.pc.form.Principal;
import javax.swing.JFrame;

/**
 *
 * @author Paulo César
 */
public class App {
    
    public static void main(String[] args) {
//        java.io.File pdf = new java.io.File("E:\\netbeans\\FolhaPagamento\\1713_FOLHA_DE_PAGAMENTO_03-2022_1649264725231.pdf");
//        java.io.File p = new java.io.File("C:\\Users\\Paulo-PC\\Downloads\\a");


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
        
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                Principal start = new Principal();
                frame.add(start);
                frame.setTitle("Sistema Desenvolvido por Paulo César 12/09/2022 [evtAdmissao] V3.0");
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        
    }
}
