public class ParserHelper {

    public static Stack<String> parse(char[] input) {
        Stack<String> parsed = new ArrayStack<>();

        for (int i = 0; i < input.length; ++i) {
            char c = input[i];
            if (Character.isDigit(c)) {
                String number = input[i] + "";
                for (int j = i + 1; j < input.length; ++j) {
                    if (Character.isDigit(input[j])) {
                        number += input[j];
                        i = j;
                    } else {
                        break;
                    }
                }
                parsed.push(number);
            } else if (c == '*' || c == '/' ||
                    c == '+' || c == '^' ||
                    c == '-' || c == '(' || c == ')') {
                parsed.push(c + "");
            }
        }
        return parsed;
    }
}