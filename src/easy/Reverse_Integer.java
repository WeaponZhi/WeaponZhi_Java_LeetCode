package easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class Reverse_Integer {
    public int reverse(int x) {
        int resultInt = 0;
        int remainderInt = 0;
        int count = String.valueOf(Math.abs(x)).length() - 1;
        boolean isFirstZero = true;
        while (x != 0) {
            remainderInt = x % 10;
            x /= 10;
            if (isFirstZero) {
                if (remainderInt == 0) {
                    count--;
                    continue;
                } else {
                    isFirstZero = false;
                }
            }
            if (resultInt + remainderInt * Math.pow(10, count) > Integer.MAX_VALUE ||
                    resultInt + remainderInt * Math.pow(10, count) < Integer.MIN_VALUE) {
                return 0;
            }
            resultInt += remainderInt * Math.pow(10, count);
            count--;
        }
        System.out.println(resultInt);
        return resultInt;
    }

    public int well_solution(int x) {
        int output = 0;
        while (true) {
            if (x == 0) {
                return x;
            }

            output = output * 10 + x % 10;

            if ((x/=10)==0){
                return output;
            }

            if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE){
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Reverse_Integer test = new Reverse_Integer();
        test.reverse(123);
        test.reverse(-123);
        test.reverse(120);
        test.reverse(1534236469);
        test.reverse(24077);
        test.reverse(-2147483412);


        System.out.println(test.well_solution(123));
        System.out.println(test.well_solution(-123));
        System.out.println(test.well_solution(120));
        System.out.println(test.well_solution(1534236469));
        System.out.println(test.well_solution(24077));
        System.out.println(test.well_solution(-2147483412));

    }
}
