public class DivideTwoIntegers {
    public static void main(String[] args) {

        // int solution = divide(1, 0);
        int solution;

        solution = divide(1,1);
        assert solution == 1;

        solution = divide(10,3);
        assert solution == 3;
        
        solution = divide(7,-3);

        assert solution == -2;

        solution = divide(5,100);
        assert solution == 0;

        solution = divide(35,8);
        assert solution == 4;

        solution = divide(-2147483648, -1);
        assert solution == 2147483647;

        // this causes an infinite loop
        solution = divide(2147483647, 1);
        assert solution == 2147483647;

    }
    
    public static int divide(int dividend, int divisor){
        if (divisor == 0) {
            throw new IllegalArgumentException("");
        }

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        // ensure that all inputs are positive
        int sign = 1;
        if (dividend < 0) {
            sign = -(sign);
        }

        if (divisor < 0) {
            sign = -(sign);
        }

        int dd = Math.abs(dividend);
        int dr = Math.abs(divisor);

        int quotient = 0;

        while (dd >= dr) {
            int shift = shiftby(dr, dd);

            dd = dd - (dr << shift);

            quotient += 1 << shift;
        }

        return (sign < 0) ? - (quotient) : quotient;
    }

    public static int shiftby(int dr, int dd) {
        int shift = 1;

        while (dr << shift < dd) {
            shift++;
        }
        return shift - 1;
    }
}