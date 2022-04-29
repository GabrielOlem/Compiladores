import java.io.File;
import java.util.*;

public class task{
    public static void main(String[] args) throws Exception{
        List<Token> pilha = new ArrayList<Token>();
        File file = new File("/home/gme/Task1Comp/Calc1.stk");

        Scanner r = new Scanner(file);
        while (r.hasNextLine()) {
            String i = r.nextLine();
            if (i.matches("\\/|\\+|\\-|\\*")){
                if (i.equals("+")){
                    Token res = new Token(TokenType.PLUS, i);
                    pilha.add(res);
                }
                else if (i.equals("-")){
                    Token res = new Token(TokenType.MINUS, i);
                    pilha.add(res);
                }
                else if (i.equals("*")){
                    Token res = new Token(TokenType.STAR, i);
                    pilha.add(res);
                }
                else if (i.equals("/")){
                    Token res = new Token(TokenType.SLASH, i);
                    pilha.add(res);
                }
            }
            else if(i.matches("\\d+")){
                Token num = new Token(TokenType.NUM, i);
                System.out.println(num);
                pilha.add(num);
            }
            else{
                throw new Exception("Error: Unexpected character:" + i);
            }
        }
        while(pilha.size() != 1){
            Token top = pilha.remove(0);
            if(top.type == TokenType.NUM){
                Token top2 = pilha.remove(0);
                Token op = pilha.remove(0);
                Double n1 = Double.parseDouble(top2.lexeme);
                Double n2 = Double.parseDouble(top.lexeme);
                System.out.println("Operação a ser realizada " + top.lexeme + op.lexeme + top2.lexeme);
                if (op.lexeme.equals("+")){
                    pilha.add(0, new Token(TokenType.NUM, Double.toString(n2 + n1)));
                }
                else if (op.lexeme.equals("-")){
                    pilha.add(0, new Token(TokenType.NUM, Double.toString(n2 - n1)));
                }
                else if (op.lexeme.equals("*")){
                    pilha.add(0, new Token(TokenType.NUM, Double.toString(n2 * n1)));
                }
                else if (op.lexeme.equals("/")){
                    if (n1 != 0){
                        pilha.add(0, new Token(TokenType.NUM, Double.toString(n2 / n1)));
                    }
                    else{
                        throw new ArithmeticException("Divisão por 0 não possível");
                    }
                }
            }
        }
        r.close();
        System.out.println("Valor calculado final: " + pilha.remove(0).lexeme);
    }
}