package org.com.github.luizanascimentoesilva.models;

import java.util.Deque;
import java.util.regex.Pattern;

public class Calculator {

    private Calculator() {
        throw new IllegalStateException("Utility class");
    }
    static int calculateByOperation(int operator1, int operator2, String operation){

            switch (operation){
                case "+":
                    return addition(operator1, operator2);
                case "-":
                    return subtraction(operator1, operator2);
                case "*":
                    return multiplication(operator1, operator2);
                case "/":
                    return division(operator1, operator2);
                default:
                    return -1;
            }
    }

    public static int calculateFormula(Deque<String> equation){
        int result = 0;
        while(equation.size() > 1){
            String op1 = equation.removeFirst();
            String operator = equation.removeFirst();
            String op2 = equation.removeFirst();

            if(isAOperator(op1)){
                if(equation.isEmpty()){
                    result = calculateByOperation(Integer.parseInt(op2), Integer.parseInt(operator), op1);
                    equation.add(String.valueOf(result));
                } else {
                    String op1Temp = equation.removeLast();
                    String op2Temp = equation.removeLast();
                    equation.add(operator);
                    equation.add(op2);

                    if(Integer.parseInt(op1Temp) > Integer.parseInt(op2Temp)){
                        result = calculateByOperation(Integer.parseInt(op1Temp), Integer.parseInt(op2Temp), op1);
                    } else {
                        result = calculateByOperation(Integer.parseInt(op2Temp), Integer.parseInt(op1Temp), op1);
                    }
                    equation.add(String.valueOf(result));
                }
            } else if(isAOperator(operator) && !isAOperator(op2)){
                result = calculateByOperation(Integer.parseInt(op1), Integer.parseInt(op2), operator);
                equation.add(String.valueOf(result));
            } else {
                if(equation.isEmpty()){
                    result = calculateByOperation(Integer.parseInt(op1), Integer.parseInt(operator), op2);
                    equation.add(String.valueOf(result));
                } else {
                    String op2Temp = equation.removeLast();
                    String op1Temp = equation.removeLast();
                    equation.add(op1);
                    equation.add(operator);

                    if(Integer.parseInt(op1Temp) > Integer.parseInt(op2Temp)){
                        result = calculateByOperation(Integer.parseInt(op1Temp), Integer.parseInt(op2Temp), op2);
                    } else {
                        result = calculateByOperation(Integer.parseInt(op2Temp), Integer.parseInt(op1Temp), op2);
                    }
                    equation.add(String.valueOf(result));
                }
            }
        }
        result = Integer.parseInt(equation.removeFirst());
        return result;
    }


    private static boolean isAOperator(String c){
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return !pattern.matcher(c).matches();
    }

    private static int addition(int operator1, int operator2){
        return operator1 + operator2;
    }

    private static int subtraction(int operator1, int operator2){
        return operator1 - operator2;
    }

    private static int multiplication(int operator1, int operator2){
        return operator1 * operator2;
    }

    private static int division(int operator1, int operator2){
        return operator1 / operator2;
    }
}
