// Kamyar Moud - kkm286

public class Converter {

    private String infixExpression;
    private String [] postixExpression = new String [INFIX_LENGTH];
    private static final int INFIX_LENGTH = 2000;

    String[] tokenizedInfix = new String[INFIX_LENGTH];

    int infixElementsLen = 0;
    int postfixElementsLen = 0;

    public Converter(String infix) {

        infixExpression = infix;
        this.tokenize();


    }

    private int getPreference(char c){

        if( c == '^' ) return 3;
        else if( c == '*' || c == '/' ) return 2;
        else if ( c == '+' || c == '-' ) return 1;

        else return -1;
    }


    public String [] toPostFix() {

        ArrayStack<String> operatorStack = new ArrayStack<String>();

        for (int i = 0; i < infixElementsLen; ++i) {

            String token = tokenizedInfix[i];

            if (!(token.equals("*") || token.equals("/") || token.equals("^") ||
                    token.equals("+") || token.equals("-") ||
                    token.equals("(") || token.equals(")"))) {

                postixExpression[postfixElementsLen] = token;
                postfixElementsLen++;

            } else {

                if (token.equals("(")) {

                    operatorStack.push(token);

                } else if (token.equals(")")) {

                    token = operatorStack.pop();

                    while (!token.equals("(")) {
                        postixExpression[postfixElementsLen] = token;
                        postfixElementsLen++;
                        token = operatorStack.pop();

                    }
                } else if (operatorStack.size() == 0) {

                    operatorStack.push(token);

                } else if (operatorStack.size() != 0) {

                    while (getPreference(operatorStack.top().charAt(0)) >= getPreference(token.charAt(0)) ) {

                        postixExpression[postfixElementsLen] = operatorStack.pop();
                        postfixElementsLen++;

                        if( operatorStack.size() == 0 ) {
                            break;
                        }

                    }

                    operatorStack.push(token);

                }


            }

        }

            while ( operatorStack.size() != 0) {

                postixExpression[postfixElementsLen] = operatorStack.pop();
                postfixElementsLen++;

            }


        return postixExpression;

    }


    public void printPostfix(){

        for (int i = 0; i < postfixElementsLen; ++i) {

            System.out.print( postixExpression[ i ] + " ");

        }

        System.out.println();

       return;
    }




    public String[] tokenize() {

        String input = infixExpression;

        String oprand = "";

        for (int i = 0; i < input.length(); ++i) {

            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                oprand = input.charAt(i) + "";
                for (int j = i + 1; j < input.length(); ++j) {
                    if (Character.isDigit(input.charAt(j))) {
                        oprand += input.charAt(j);
                        i = j;
                    } else {
                        break;
                    }
                }
                tokenizedInfix[infixElementsLen] = oprand;

                infixElementsLen++;

            } else if (c == '*' || c == '/' ||
                    c == '+' || c == '^' ||
                    c == '-' || c == '(' || c == ')') {

                tokenizedInfix[infixElementsLen] = c + "";

                infixElementsLen++;
            }
        }
        return tokenizedInfix;
    }

    public int getPostfixElementsLen(){

        return postfixElementsLen;

    }


}