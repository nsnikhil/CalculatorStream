import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorStreamTest {

    private CalculatorStream calculatorStreamInitialZero, calculatorStreamInitialOne;

    @BeforeEach
    void setUp() {
        calculatorStreamInitialZero = new CalculatorStream(0);
        calculatorStreamInitialOne = new CalculatorStream(1);
    }

    @Test
    void shouldReturnInitialValue() {
        assertEquals(new Integer(0), calculatorStreamInitialZero.getResult());
    }

    @Test
    void shouldAddFiveToZero() {
        assertEquals(new Integer(5), calculatorStreamInitialZero.add(5).getResult());
    }

    @Test
    void shouldAddFiftyThenSubtractTwentyToZero() {
        assertEquals(new Integer(30), calculatorStreamInitialZero.add(50).subtract(20).getResult());
    }

    @Test
    void shouldMultiplyByTwentyToOne() {
        assertEquals(new Integer(20), calculatorStreamInitialOne.multiply(20).getResult());
    }

    @Test
    void shouldAddFiftyThenDivideByTenToZero() {
        assertEquals(new Integer(5), calculatorStreamInitialZero.add(50).divide(10).getResult());
    }

    @Test
    void shouldAddTwentyThenSubtractTenThenMultiplyByFourThenDivideEightToZero(){
        assertEquals(new Integer(5), calculatorStreamInitialZero.add(20).subtract(10).multiply(4).divide(8).getResult());
    }

}
