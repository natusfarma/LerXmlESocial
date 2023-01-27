package br.com.pc.protocolo.classe;

/**
 *
 * @author Paulo César
 */
public class XmlType extends javax.swing.filechooser.FileView{
    public static final String ext = ".xml";
    
    @Override
    public String getTypeDescription(java.io.File f) {
        String extension = Utils.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(Utils.xml)) {
                type = "xml";
            }
        }
        return type;
    }
}
