package manejoDeMatrices;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManejoDeMatrices {

    public static void main(String[] args) throws IOException {

        //Creacion de la ventana principal y sus componentes
    	JFrame window = new JFrame("Manejo de matrices");
        JPanel contentPane = new JPanel();
        window.setSize(400, 400);
        window.setResizable(false);
        window.setContentPane(contentPane);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        //Declaracion de variable Matriz y llamada a sus metodos
    	Matriz m = new Matriz();
        m.asignacionDeValores(m.matriz, m.matriz.length, contentPane);
        m.modificarMatriz(m.matriz.length, contentPane);
        m.imprimirMatriz(m.matriz);
        m.guardar();
        m.imprimirDato();
        m.modificarDato();
        m.modificarMatriz(m.matriz.length, contentPane);

    }

}
