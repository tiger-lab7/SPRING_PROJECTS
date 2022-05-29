package Model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;

public class CalculatorEngine {
    private enum Actions {PLUS, MINUS}

    private final static Map<String, Actions> commands
            = Map.of("+", Actions.PLUS, "-", Actions.MINUS);
    private static final Deque<Double> numberDeque = new ArrayDeque<>();
    private static final Deque<Actions> commandDeque = new ArrayDeque<>();

    public static String calculate(String input) {

        String number = "";
        for (char let : input.toCharArray()) {
            if (Character.isDigit(let)) number += let;
            else if(commands.containsKey(String.valueOf(let))) {
                if (!number.equals("")) {
                    numberDeque.addLast(Double.valueOf(number));
                    number = "";
                }
                commandDeque.addLast(commands.get(String.valueOf(let)));
            }
        }

        if (!number.equals(""))
            numberDeque.push(Double.valueOf(number));

        while(!commandDeque.isEmpty() && numberDeque.size() >= 2) {
            switch (commandDeque.poll()) {
                case PLUS -> {
                    numberDeque.addFirst(numberDeque.poll() + numberDeque.poll());
                }
                case MINUS -> {
                    numberDeque.addFirst(numberDeque.poll() - numberDeque.poll());
                }
            }
        }
        if (!numberDeque.isEmpty())
            return Double.toString(numberDeque.pop());

        return "";
        //return input;
    }
}
