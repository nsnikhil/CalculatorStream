import java.util.Arrays;
import java.util.function.BinaryOperator;

final class CalculatorStream implements Comparable<CalculatorStream> {

    private final Integer number;

    public CalculatorStream(final Integer number) {
        this.number = number;
    }

    public CalculatorStream add(final Integer... integers) {
        return operation(Math::addExact, integers);
    }

    public CalculatorStream subtract(final Integer... integers) {
        return operation(Math::subtractExact, integers);
    }

    public CalculatorStream multiply(final Integer... integers) {
        return operation(Math::multiplyExact, integers);
    }

    public CalculatorStream divide(final Integer... integers) {
        return operation(Math::floorDiv, integers);
    }

    public CalculatorStream peek() {
        System.out.println(this.number);
        return this;
    }

    public Integer getResult() {
        return this.number;
    }

    private CalculatorStream operation(final BinaryOperator<Integer> binaryOperator, final Integer... integers) {
        return new CalculatorStream(Arrays.stream(integers).reduce(number, binaryOperator));
    }

    @Override
    public int compareTo(CalculatorStream calculatorStream) {
        return Integer.compare(number, calculatorStream.number);
    }

}
