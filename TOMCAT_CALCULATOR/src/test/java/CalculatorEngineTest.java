import Model.CalculatorEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorEngineTest {

    @Test
    public void testArithmetic() {
        Assertions.assertEquals(
                CalculatorEngine.calculate("7+7-4"), "10.0");
    }

}
