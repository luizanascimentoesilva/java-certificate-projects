package org.com.github.luizanascimentoesilva.models;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO: lidar com números contendo mais de um algarismo
public class Formula {
    private ArrayDeque<String> equation = new ArrayDeque<>();
    public Formula(String line){
        StringBuilder buildLine = new StringBuilder(line);
        operationResolutionOrder(buildLine);

        for (int i = (buildLine.length() - 1); i >= 0 ; i--) {
                if(buildLine.charAt(i) != '#') equation.add(String.valueOf(buildLine.charAt(i)));
        }
    }

    private void operationResolutionOrder(StringBuilder line){
        while(line.indexOf("*") > -1 || line.indexOf("/") > -1){
            if(line.toString().indexOf('*') > -1){
                addFormulaPart(line.indexOf("*"), line);
            } else {
                addFormulaPart(line.indexOf("/"), line);
            }
        }
    }

    private void addFormulaPart(int index, StringBuilder line){
        if(line.charAt(index - 1) != '#'){
            equation.add(String.valueOf(line.charAt(index - 1)));
        }

        if(line.charAt(index) != '#'){
            equation.add(String.valueOf(line.charAt(index)));
        }

        if(line.charAt(index + 1) != '#'){
            equation.add(String.valueOf(line.charAt(index + 1)));
        }

        line.setCharAt(index - 1, '#');
        line.setCharAt(index, '#');
        line.setCharAt(index + 1, '#');
    }


    public Deque<String> getEquation() {
        return equation;
    }

}
