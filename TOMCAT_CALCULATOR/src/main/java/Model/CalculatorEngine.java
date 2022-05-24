package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalculatorEngine {
    private enum Actions { PLUS, MINUS};
    private final static Map<String, Actions> commands = Map.of("+", Actions.PLUS, "-", Actions.MINUS);
    private static Stack<String> numberStack = new Stack<>();
    private static Stack<Actions> commandStack = new Stack<>();

    public static String calculate(String input) {
        /*
        String number = "";
        for (char let : input.toCharArray()) {
            if (Character.isDigit(let)) number += let;
            else if(commands.containsKey(String.valueOf(let))) {
                if (!number.equals("")) {
                    numberStack.push(number);
                    number = "";
                }
                commandStack.push(commands.get(String.valueOf(let)));
            }
        }

        double result = 0;
        while(!commandStack.isEmpty()) {
            switch (commandStack.pop()) {
                case PLUS -> {
                    result += Double.parseDouble(numberStack.pop()) + Double.parseDouble(numberStack.pop());
                }
                case MINUS -> {
                    result += Double.parseDouble(numberStack.pop()) - Double.parseDouble(numberStack.pop());
                }
            }
        }*/
        //return Double.toString(result);
        return input;
    }

    public static void main(String[] args) {
        System.out.println(calculate("5657+343434"));
    }
}
