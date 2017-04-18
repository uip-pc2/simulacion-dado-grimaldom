package dado;
/**
 @author Grimaldo Castro Moreno
 @version 17-4-17 1.1
 * */
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.*;
/** Inicio de Clase dados*/
public class Dados {
    //boton
    @FXML
    public Button bt_verlanza;

    //declarar variables
    public String numero1;
    public String numero2;

    /**Inicio de metodo Lanzar*/

    public void lanzar(ActionEvent actionEvent) {

        /**Crea el archivo */

        File archivo = new File("archivo.txt");

        /**Random de Dado 1*/
        int num1 = (int) (Math.random() * 6 + 1);


        switch (num1) {
            case 1:
                this.numero1 = "Uno";
                break;
            case 2:
                this.numero1 = "Dos";
                break;
            case 3:
                this.numero1 = "Tres";
                break;
            case 4:
                this.numero1 = "Cuatro";
                break;
            case 5:
                this.numero1 = "Cinco";
                break;
            case 6:
                this.numero1 = "Seis";
                break;
        } /**terminacion de random1*/

        /**Random de Dado 2*/
        int num2 = (int) (Math.random() * 6 + 1);

        switch (num2) {
            case 1:
                this.numero2 = "Uno";
                break;
            case 2:
                this.numero2 = "Dos";
                break;
            case 3:
                this.numero2 = "Tres";
                break;
            case 4:
                this.numero2 = "Cuatro";
                break;
            case 5:
                this.numero2 = "Cinco";
                break;
            case 6:
                this.numero2 = "Seis";
                break;

        }/**terminacion de random1*/
        /**Muestra lanzamientos individuales en mensajes de dialogo*/
        JOptionPane.showMessageDialog(null, "Dado numero 1: " + numero1 + "\n" + "Dado numero 2: " + numero2, "LANZAMIENTO", JOptionPane.WARNING_MESSAGE);

        /** Crear el archivo */
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                /** Error al crear el archivo */
            } catch (IOException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Problema creando archivo...");
                alerta.setHeaderText("Mira, hubo un error...");
                alerta.setContentText("Error de Aplicacion");
                alerta.showAndWait();
                Platform.exit();
            }/** fin de catch*/
        } /**Fin de If*/
        /**guarda las lineas por lanzamiento en el archivo*/
        try {
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Dado numero 1: " + numero1 + " , " + "Dado numero 2: " + numero2);
            bw.write("\n");
            bw.close();

        /**error al escribir*/
        } catch (IOException e) {
            System.out.println("Problema con el escritor...");
        }

    }


    public String getNumero1() {
        return numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }

    /**verlanza es la accion de boton bt_verlanza Busca el archivo y lo imprime*/
    public void verlanza(ActionEvent actionEvent) throws IOException {
        /**URL del archivo*/
        muestraContenido("C:/Users/Grimaldo/PC2/Dadosend/archivo.txt");

        try {
            /** mensaje de alerta por error*/
    } catch (Exception e) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de Aplicacion");
        alerta.setHeaderText("Mira, hubo un error...");
        alerta.setContentText("Lo siento. Llama al administrador.");
        alerta.showAndWait();
        Platform.exit();
    }

    }/** fin de verlanza */

    /**Lee el archivo por linea e imprime en consola todos los lanzamientos hechos*/
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            /**Imprime en consola*/
            System.out.println(cadena);

        }
        b.close();

    }/** fin de muetracontenido*/


} /**fin de dados*/
