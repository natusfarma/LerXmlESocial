package br.com.pc.protocolo.classe;

/**
 *
 * @author Paulo César
 */
public class CsvType extends javax.swing.filechooser.FileView{
    public static final String ext = ".csv";
    
    @Override
    public String getTypeDescription(java.io.File f) {
        String extension = Utils.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(Utils.csv)) {
                type = "csv";
            }
        }
        return type;
    }
}
