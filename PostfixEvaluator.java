import java.io.*;
import java.util.*;

public class PostfixEvaluator {
    public static void main(String[] args) {
        try {
            File file = new File("datos.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String expresion = scanner.nextLine();
                int resultado = evaluarPostfix(expresion);
                System.out.println("Resultado: " + resultado);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
    }

    public static int evaluarPostfix(String expresion) {
        Stack<Integer> pila = new Stack<>();
        String[] elementos = expresion.split(" ");
        for (String elemento : elementos) {
            if (Character.isDigit(elemento.charAt(0))) {
                pila.push(Integer.parseInt(elemento));
            } else {
                int operandoB = pila.pop();
                int operandoA = pila.pop();
                switch (elemento) {
                    case "+":
                        pila.push(operandoA + operandoB);
                        break;
                    case "-":
                        pila.push(operandoA - operandoB);
                        break;
                    case "*":
                        pila.push(operandoA * operandoB);
                        break;
                    case "/":
                        pila.push(operandoA / operandoB);
                        break;
                }
            }
        }
        return pila.pop();
    }
}
