package br.com.pc.protocolo.classe;

/**
 *
 * @author Paulo César
 */
public class GerarArquivo {
    
    private java.io.File file;
    
    public GerarArquivo(java.io.File file, String str ,boolean escreve ) throws Exception{
        this(file, str, Unicode.ISO_8859_1, escreve);
    }
    
    public GerarArquivo(java.io.File file, String str, String unicode, boolean escreve) throws Exception{
        this.file = file;
        gerarArquivo(str, unicode,escreve);
    }
    
    
    /*CORRIGIR AO GERAR UM ARQUIVO COM O MESMO NOME ELE ESTÁ CONCATENANDO AS INFORMAÇÕES*/
    private void gerarArquivo(String str, String unicode, boolean escreve) throws Exception{
        /*int opcao = verificarSeArquivoExiste();
        if (javax.swing.JOptionPane.NO_OPTION == opcao || javax.swing.JOptionPane.CLOSED_OPTION == opcao) {
            return;
        }*/
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file,escreve),unicode));
        //java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file,true),"ISO-8859-1"));
        bw.write(str);
        bw.newLine();
        bw.close();
        
    }
    
    private int verificarSeArquivoExiste (){ 
        String mensagem = "O arquivo "+file.getAbsolutePath()+" já existe.\nDeseja subistituir o arquivo?";
        int opcao = -2;
        if (file.exists()) {
            opcao = pergunta(mensagem+"\nArquivo "+file.getName() );
            if (javax.swing.JOptionPane.YES_OPTION == opcao) {
                file.delete();
            } 
        }
        return opcao;
    }
    
    
    private static StringBuilder limitaMensagem(String msg){
        String[] s = msg.split(" ");
        StringBuilder sb = new StringBuilder();
        int espaco = 100; //quantidade de caracter em uma linha na mensagem.
        int tamanho = 0;
        for(String str: s){
            sb.append(str);
            sb.append(" ");
            if (sb.length()-tamanho > espaco) {
                tamanho = sb.length();
                sb.append(System.lineSeparator());
            }
        }
        return sb;
    }
    
    
    public static int pergunta(String msg){
        StringBuilder sb = limitaMensagem(msg);
        return javax.swing.JOptionPane.showConfirmDialog(null, sb.toString(), "", javax.swing.JOptionPane.YES_NO_OPTION);
    }
    
}
