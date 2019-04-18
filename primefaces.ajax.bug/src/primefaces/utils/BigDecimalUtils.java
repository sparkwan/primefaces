package primefaces.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	public static final BigDecimal ZERO = BigDecimal.ZERO;
	public static final BigDecimal ONE_HUNDRED = new BigDecimal("100.0");

	public static BigDecimal multiply(BigDecimal left, BigDecimal right) {
		BigDecimal leftNotNull = left == null ? new BigDecimal(0) : left;
		BigDecimal rightNotNull = right == null ? new BigDecimal(0) : right;
		return leftNotNull.multiply(rightNotNull);
	}

	public static BigDecimal add(BigDecimal left, BigDecimal right) {
		BigDecimal leftNotNull = left == null ? new BigDecimal(0) : left;
		BigDecimal rightNotNull = right == null ? new BigDecimal(0) : right;
		return leftNotNull.add(rightNotNull);
	}

	public static BigDecimal substract(BigDecimal left, BigDecimal right) {
		BigDecimal leftNotNull = left == null ? new BigDecimal(0) : left;
		BigDecimal rightNotNull = right == null ? new BigDecimal(0) : right;
		return leftNotNull.subtract(rightNotNull);
	}

	public static BigDecimal divid(BigDecimal left, BigDecimal right, int scale) {
		BigDecimal leftNotNull = left == null ? new BigDecimal(0) : left;
		BigDecimal rightNotNull = right == null ? new BigDecimal(0) : right;
		return leftNotNull.divide(rightNotNull, scale, BigDecimal.ROUND_HALF_EVEN);
	}

}
