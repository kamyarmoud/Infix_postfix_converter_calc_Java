// Kamyar Moud - kkm286


import java.util.Scanner;
import java.io.*;


public class Main {


    public static void main(String[] args) {




        //Scanner userinput = new Scanner(System.in);
        System.out.println ("Type your infix string to be evaluated: ");
        //String infixExpression = userinput.next();


        //Test cases

        //String infixExpression = "(12 + 1 ) ^ 16 / 5 ";
        //String infixExpression = "(12 + 1 ) / 16 ^ 5 ";
        //String infixExpression = "(12 + 1 ) / (16 ^ 5) ";
        //String infixExpression = "(12 + 1 ) ^ (16 / 5) ";

        //String infixExpression = " 3+4*5/6";
        //String infixExpression = "(300+23)*(43-21)/(84+7)";
        String infixExpression = " (4+8)*(6-5)/((3-2)*(2+2))";



        System.out.println(infixExpression);

        PostfixCalculator postfix = new PostfixCalculator(infixExpression);

        System.out.println("Answer is : " + postfix.evaluateExp() );


    }




}
