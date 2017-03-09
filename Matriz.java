package manejoDeMatrices;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Matriz {

    //Declaración variables
	int matriz[][];
    JTextField fields[][];
    Scanner entrada = new Scanner(System.in);
    
    //Constructor de Matriz
    public Matriz() {
        int x;
        System.out.print("Ingresa el tamaño de la matriz: ");
        x = entrada.nextInt();
        matriz = new int[x][x];
        fields = new JTextField[x][x];
    }

    //Asignación de valores a la matriz y a los componente visuales 
    public void asignacionDeValores(int[][] m, int x, JPanel contentPane) {
    	contentPane.setSize(x * 25, x * 25);
    	contentPane.setLocation(200 - contentPane.getHeight() / 2, 180 - contentPane.getWidth() / 2);
    	
        for(int i = 0; i < x; i++) {
        	
            for(int j = 0; j < x; j++) {       	
                System.out.println("Ingresa el valor (" + i + ", " + j + "): ");
                matriz[i][j] = entrada.nextInt();
                contentPane.add(new JTextField());
                
            }    
            
        }

    }

    //Impresión de valores de la matriz en consola
    public void imprimirMatriz(int m[][]) {
    	
        for(int i = 0; i < m.length; i++) {
        	
            for(int j = 0; j < m.length; j++) {	
                System.out.print(m[i][j] + " ");
            }
            
            System.out.println();
            
        }
        
    }

    public void imprimirDato() {
        int x = 0, y = 0;
        System.out.println("Ingresa las coordenadas del dato al que desee acceder:");
        x = entrada.nextInt();
        
        if(x >= matriz.length) { 	
        	x = matriz.length - 1;
        	System.out.println("El valor ingresado es mayor al tamaño de la matriz, el valor fue modificado al indice mas alto");    	
        }
        
        y = entrada.nextInt();
        
        if(y >= matriz.length) {
        	y = matriz.length - 1;
        	System.out.println("El valor ingresado es mayor al tamaño de la matriz, el valor fue modificado al indice mas alto");     	
        }
        
        System.out.println("El valor (" + x + ", " + y + ") es: " + matriz[x][y]);

    }
    
    public void guardar() throws IOException {
    	
    	FileWriter salida = null;
    	
    	try {
    		salida = new FileWriter("matriz.txt");
    		
    		for(int i = 0; i < matriz.length; i++) {
    			
    			for(int j = 0; j < matriz.length; j++) {
    				char caracter = String.valueOf(matriz[i][j]).charAt(0);
        			salida.write((int)caracter);
        			salida.write(System.getProperty("line.separator"));
    			}
    			
    		}
    	} finally {
    		salida.close();
    	}
    	 	
    }
    
    public void modificarDato() {
        int x = 0, y = 0, nuevoValor = 0;
        System.out.println("Ingresa las coordenadas del dato que desee modificar:");
        x = entrada.nextInt();
        
        if(x >= matriz.length) { 	
        	x = matriz.length - 1;
        	System.out.println("El valor ingresado es mayor al tamaño de la matriz, el valor fue modificado al indice mas alto");    	
        }
        
        y = entrada.nextInt();
        
        if(y >= matriz.length) {
        	y = matriz.length - 1;
        	System.out.println("El valor ingresado es mayor al tamaño de la matriz, el valor fue modificado al indice mas alto");     	
        }
        
        System.out.println("Ingresa el nuevo valor: ");
        nuevoValor = entrada.nextInt();
        matriz[x][y] = nuevoValor;
        System.out.println("El valor (" + x + ", " + y + ") ha sido modificado con éxito");

    }
    
    public void modificarMatriz(int x, JPanel contentPane) {
    	int contador = 0;
    	contentPane.setSize(x * 25, x * 25);
    	contentPane.setLocation(200 - contentPane.getHeight() / 2, 180 - contentPane.getWidth() / 2);
    	
        for(int i = 0; i < x; i++) {
        	
            for(int j = 0; j < x; j++) {       	
                fields[i][j] = (JTextField)contentPane.getComponent(contador++);
                fields[i][j].setSize(20, 20);
                fields[i][j].setLocation(5 + 25 * j, 5 + 25 * i);
                fields[i][j].setBorder(null);
                fields[i][j].setEditable(false);
                fields[i][j].setText(String.valueOf(matriz[i][j]));
            }    
            
        }

    }

}


