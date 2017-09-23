public class ReversePolishCalc {

    int stackTop = 0;

    private String[] tokens;

    private String[] stack;

    public double calculate(String input) {

        tokens = input.split(",");

        stack = new String[tokens.length];

        // 3. write the algorithm
        for (int i = 0; i < tokens.length; i++) {
            // calls to push() and pop() and do the math here

//            if (ReversePolishCalc.isANumber(tokens[i])) {
//                push(Double.parseDouble(tokens[i]));
//            } else {
//                double num1 = pop();
//                double num2 = pop();
            switch (tokens[i]) {
                case "+":
                    add();
                    break;
                case "-":
                    subtract();
                    break;
                case "*":
                    multiply();
                    break;
                case "/":
                    divide();
                    break;
                default:
                    push(Double.parseDouble(tokens[i]));
            }
        }
        return pop();
    }

    private void divide() {
        double num1 = pop();
        double num2 = pop();
        push(num2 / num1);
    }

    private void multiply() {
        double num1 = pop();
        double num2 = pop();
        push(num2 * num1);
    }

    private void subtract() {
        double num1 = pop();
        double num2 = pop();
        push(num2 - num1);
    }

    private void add() {
        double num1 = pop();
        double num2 = pop();
        push(num2 + num1);
    }


    public static boolean isANumber(String string) {
        try {
            double inputDouble = Double.parseDouble(string);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void push(String number) {

        stack[stackTop] = number;
        stackTop++;
    }

    private void push(double d) {
        push(d + "");
    }

    private double pop() {

        stackTop--;
        return Double.parseDouble(stack[stackTop]);
    }
}