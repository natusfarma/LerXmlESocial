package br.com.pc.protocolo.classe;

import br.com.pc.form.Principal;
import br.com.pc.form.PrincipalContratual;
import br.com.pc.form.PrincipalPai;
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
                String VERSAO = "V3.0";
                System.out.println("Parâmetro do Sistema");
                System.out.println("Caso não digitar nada o padrão é [*]");
                System.out.println("\t[admissao]");
                System.out.println("\t[contratual]*");
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                PrincipalPai start = null;
                if (args.length == 0 || args[0].equals("contratual")) {
                    start = new PrincipalContratual();
                    frame.setTitle("Sistema Desenvolvido por Paulo César 27/01/2023 " +VERSAO+" ["+PrincipalContratual.TITULO+"]");
                }else{
                    start = new Principal();
                    frame.setTitle("Sistema Desenvolvido por Paulo César 12/09/2022 " +VERSAO+" ["+Principal.TITULO+"]");
                }
//                start = new PrincipalContratual();
//                frame.setTitle("Sistema Desenvolvido por Paulo César 27/01/2023 V3.0 ["+PrincipalContratual.TITULO+"]");
                frame.add(start);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        
    }
}
