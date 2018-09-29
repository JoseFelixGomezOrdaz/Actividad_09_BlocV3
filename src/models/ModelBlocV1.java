package models;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import views.ViewBlocV1;
/**
 *
 * @author Jose Felix
 */
public class ModelBlocV1 {
    ViewBlocV1 viewBlocV1;
    private String path="";
    private String message="";
    private String row="";
    private String  texto="";
    private String cifrar = "";
    private String decifrar = "";
    
    
    
    /**
     * permite leer archivos
     * @param path almacena la ubicacion de los archivos
     */
    public void readFile (String path) {
        try {
            try (FileReader archivo = new FileReader(path)) {
                BufferedReader bufferedreader = new BufferedReader(archivo);
                while ((row = bufferedreader.readLine()) != null ) {
                    message = message + row;
                }
                
                }
                    
               
            }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
        
    };
    
    /**
     * permite elegir el archivo 
     */
    public void abrirArchivo(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.showOpenDialog(viewBlocV1);
        File archivo = fileChooser.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(" "))){
            JOptionPane.showMessageDialog(viewBlocV1, "Archivo inválido");
        }
        else
            path = archivo.getAbsolutePath();
    }
    
    

    
    /**
     * permite escribir y guardar el archivo en el archivo
     * @param path almacena la ubicacion del archivo
     * @param message almacena lo que se va a guardar en el archivo
     */
    public void writeFile (String path, String message) {
        try {
            File archivo = new File(path); 
            FileWriter filewriter = new FileWriter(archivo, false); 
            
            try (PrintWriter printwriter = new PrintWriter(filewriter) ) { 
                printwriter.println(message);
                printwriter.close();
            }
        }
        catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
        }
        catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }
    /**
     * permte cifrar el texto de el archivo
     */
    public void jm_cifrar_action_performed() {
        for (int i = 0; i < texto.length(); i++) { 
            char caracter = texto.charAt(i);
            int ascii = (int) caracter;
            ascii = ascii + 8; 
            caracter = (char) ascii;
            cifrar += caracter; 
        }
    }
    /**
     * permite decifrar el texto del archivo
     */
    public void jm_decifrar_action_performed() {
        for (int i = 0; i < texto.length(); i++) { 
            char caracter = texto.charAt(i);
            int ascii = (int) caracter;
            ascii = ascii - 8; 
            caracter = (char) ascii;
            decifrar += caracter; 
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCifrar() {
        return cifrar;
    }

    public void setCifrar(String cifrar) {
        this.cifrar = cifrar;
    }

    public String getDecifrar() {
        return decifrar;
    }

    public void setDecifrar(String decifrar) {
        this.decifrar = decifrar;
    }
    
}
