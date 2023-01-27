package br.com.pc.protocolo.classe;

/**
 *
 * @author Paulo César
 */
public class FiltroCsv extends javax.swing.filechooser.FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    @Override
    public boolean accept(java.io.File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.csv)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    @Override
    public String getDescription() {
        return "Arquivo Csv (*.csv)";
    }
    
}
