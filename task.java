import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class task{
    public static void main(String[] args) throws IOException{
        Stack<String> pilha = new Stack<>();
            // Creates a FileInputStream
        FileInputStream file = new FileInputStream("/home/gme/Task1Comp/Calc1.stk");

        // Creates a BufferedInputStream
        BufferedInputStream input = new BufferedInputStream(file);

        BufferedReader r = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        String i = r.readLine();
        while (i != null) {
            if (i.matches("\\/|\\+|\\-|\\*")){
                Double val1 = Double.parseDouble(pilha.pop());
                Double val2 = Double.parseDouble(pilha.pop());

                System.out.println("Operação a ser realizado " + val2 + i + val1);
                if (i.equals("+")){
                    pilha.push(Double.toString(val2 + val1));
                }
                else if (i.equals("-")){
                    pilha.push(Double.toString(val2 - val1));
                }
                else if (i.equals("*")){
                    pilha.push(Double.toString(val2 * val1));
                }
                else if (i.equals("/")){
                    if (val1 != 0){
                        pilha.push(Double.toString(val2 / val1));
                    }
                    else{
                        throw new ArithmeticException("Divisão por 0 não possível");
                    }
                }
            }
            else{
                pilha.push(i);
            }
            i = r.readLine();
        }
        r.close();
        System.out.println("Valor calculado final: " + pilha.pop());
    }
}