package br.com.pc.protocolo.classe;

/**
 *
 * @author Paulo César
 */
public class Utils {
    
    public final static String xml = "xml";
    public final static String csv = "csv";
    
    public static String getExtension(java.io.File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
