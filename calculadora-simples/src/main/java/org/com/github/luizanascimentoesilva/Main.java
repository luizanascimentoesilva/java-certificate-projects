package org.com.github.luizanascimentoesilva;

import org.com.github.luizanascimentoesilva.models.Calculator;
import org.com.github.luizanascimentoesilva.models.Formula;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Formula f;

        do {
            String line = scan.nextLine();
            f = new Formula(line);
            int result = Calculator.calculateFormula(f.getEquation());

            if(result != -1){
                logger.info(String.valueOf(result));
            } else{
                logger.info("Não foi possível realizar a operação");
            }
        }while(scan.hasNext());
    }
}