// Kamyar Moud - kkm286
//

public class PostfixCalculator {

    private double answer=0;
    private String [] postixExpression = new String [POSTFIX_LENGTH];
    private static final int POSTFIX_LENGTH = 2000;
    private Converter infix;


    public PostfixCalculator(String infixExpression){

        infix = new Converter(infixExpression);

    }


    public double evaluateExp() {

        postixExpression = infix.toPostFix();

        System.out.println("Converted to postfix :");

        infix.printPostfix();

        ArrayStack<Double> evalStack = new ArrayStack<Double>();


        for (int i = 0; i < infix.getPostfixElementsLen() ; i++) {


            switch (postixExpression[i]) {

                case "+" : {

                    double a = evalStack.pop();
                    double b = evalStack.pop();
                    double c = b + a;

                    evalStack.push(c);
                    break;
                }

                case "-" : {

                    double a = evalStack.pop();
                    double b = evalStack.pop();
                    double c = b - a;

                    evalStack.push(c);
                    break;
                }

                case "*" : {

                    double a = evalStack.pop();
                    double b = evalStack.pop();
                    double c = b * a;

                    evalStack.push(c);
                    break;
                }

                case "/": {

                    double a = evalStack.pop();
                    double b = evalStack.pop();
                    double c = b / a;

                    evalStack.push(c);
                    break;
                }

                case "^": {

                    double a = evalStack.pop();
                    double b = evalStack.pop();
                    double c = (int) Math.pow(b, a);

                    evalStack.push(c);
                    break;
                }

                default: {

                    evalStack.push(Double.valueOf(postixExpression[i]));
                    break;

                }


            }

        }

        answer = evalStack.pop();

        return answer;

    }



}
