import org.com.github.luizanascimentoesilva.models.Calculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void CalculateAddition() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("1");
        equation.add("+");
        equation.add("2");
        assertEquals(3, Calculator.calculateFormula(equation));
    }
    @Test
    public void CalculateSubtraction() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("2");
        equation.add("-");
        equation.add("2");
        assertEquals(0, Calculator.calculateFormula(equation));
    }
    @Test
    public void CalculateDivision() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("4");
        equation.add("/");
        equation.add("2");
        assertEquals(2, Calculator.calculateFormula(equation));
    }

    @Test
    public void CalculateMultiplication() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("2");
        equation.add("*");
        equation.add("2");
        assertEquals(4, Calculator.calculateFormula(equation));
    }

    @Test
    public void CalculateFormula() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("2");
        equation.add("*");
        equation.add("2");
        equation.add("4");
        equation.add("/");
        equation.add("2");
        equation.add("1");
        equation.add("+");
        equation.add("-");

        assertEquals(3, Calculator.calculateFormula(equation));
    }

    @Test
    public void CalculateFormula2() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("8");
        equation.add("*");
        equation.add("4");
        equation.add("8");
        equation.add("*");
        equation.add("3");
        equation.add("1");
        equation.add("+");
        equation.add("-");
        equation.add("3");
        equation.add("+");

        assertEquals(12, Calculator.calculateFormula(equation));
    }

    @Test
    public void CalculateFormula3() {
        ArrayDeque<String> equation = new ArrayDeque<String>();
        equation.add("8");
        equation.add("*");
        equation.add("5");
        equation.add("2");
        equation.add("*");
        equation.add("3");
        equation.add("/");
        equation.add("2");
        equation.add("+");

        assertEquals(8, Calculator.calculateFormula(equation));
    }
}
