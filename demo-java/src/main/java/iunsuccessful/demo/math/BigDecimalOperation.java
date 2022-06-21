package iunsuccessful.demo.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;

/**
 * 依韵 2022/6/21
 */
public enum BigDecimalOperation {

    PLUS ("+", BigDecimal::add),
    MINUS ("-", BigDecimal::subtract),
    MULTIPLY ("*", BigDecimal::multiply),
    DIVIDE ("/", (v1, v2) -> v1.divide(v2, 2, RoundingMode.HALF_UP)),
    ;

    private final String symbol;

    private final BinaryOperator<BigDecimal> op;

    BigDecimalOperation(String symbol, BinaryOperator<BigDecimal> op) {
        this.symbol = symbol;
        this.op = op;
    }

    public BigDecimal apply(BigDecimal v1, BigDecimal v2) {
        return op.apply(v1, v2);
    }

}
