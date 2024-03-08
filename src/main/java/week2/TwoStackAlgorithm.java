package week2;

import jdk.dynalink.Operation;

import java.math.BigDecimal;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {
        String[] exp = expression.split(" ");

        QueueBasedStack s1 = new QueueBasedStack<>();
        QueueBasedStack s2 = new QueueBasedStack<>();

        String operators = "+-*/%^√";

        for (String element : exp) {
            if (element.equals(")")) {
                Double n2 = (Double) s1.pop();
                String operator = (String) s2.pop();
                if (operator.equals("√")) {
                    s1.push(Math.sqrt(n2));
                } else {
                    Double n1 = (Double) s1.pop();
                    s1.push(Operation(n1, n2, operator));
                }
            } else if (element.equals("(")) {
                continue;
            } else {
                if (operators.contains(element)) {
                    s2.push(element);
                } else {
                    s1.push(Double.parseDouble(element));
                }
            }
        }

        return (Double) s1.pop();
    }

    private static Double Operation(Double n1, Double n2, String operator){
        double ans = 0;
        if(operator.equals("+")){
            ans =  n1 + n2;
        } else if (operator.equals("-")){
            ans =   n1 - n2;
        } else if (operator.equals("*")) {
            ans =  n1 * n2;
        } else if (operator.equals("/")) {
            ans =  n1 / n2;
        } else if (operator.equals("%")) {
            ans =  n1 % n2;
        } else if (operator.equals("^")) {
            ans =  Math.pow(n1, n2);
        }
        return ans;
    }
}
