import org.com.github.luizanascimentoesilva.models.Calculator;
import org.com.github.luizanascimentoesilva.models.Formula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormulaTest {
    @Test
    public void CalculateAddition() {
        Formula f = new Formula("2*2-4/2+1");

        assertEquals("2", f.getEquation().getFirst());
        assertEquals("-", f.getEquation().getLast());

    }

    @Test
    public void CalculateAddition2() {
        Formula f = new Formula("8*5/2+2*3");

        assertEquals("8", f.getEquation().getFirst());
        assertEquals("+", f.getEquation().getLast());

    }
}
