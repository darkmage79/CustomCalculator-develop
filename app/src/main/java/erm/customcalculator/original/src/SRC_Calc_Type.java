package erm.customcalculator.original.src;

import java.math.BigInteger;

/**
 * Created by Logan on 1/31/2016.
 */
public class SRC_Calc_Type {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static Double CI(Double PH, Double CV, Double N) { //First X in Confidence interval


        Double answer1 = CV;
        Double answer2 = (PH * (1 - PH)) / N;
        Double answer3 = answer1 * Math.sqrt(answer2);
        Double answer4 = PH + answer3;
        System.out.printf("Confidence Interval 1: %s \n", answer4);
        //Result
        return answer4;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Double CII(Double PH, Double CV, Double N) { //Second X in Confidence interval

        Double answer1 = CV;
        Double answer2 = (PH * (1 - PH)) / N;
        Double answer3 = answer1 * Math.sqrt(answer2);
        Double answer4 = PH - answer3;
        System.out.printf("Confidence Interval 2: %s \n", answer4);
        return answer4;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *     nCr
     */

    public static BigInteger BigCombination(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N - k))
                    .divide(BigInteger.valueOf(k + 1));
        }
        return ret;
    }

    /**
     * nPr
     * @param n
     * @param k
     * @return
     */
    public static BigInteger BigPermutation(int n, int k) {
        BigInteger result = new BigInteger("1");
        int i;
        for (i = n - k + 1; i <= n; i++) {
            result = result.multiply(new BigInteger(Integer.toString(i)));
        }
        return result;
    }

    public static Double Combination(Double n, Double r) {
        Double factn = SRC_Calc_Type.factorial(n);
        Double factr = SRC_Calc_Type.factorial(r);
        Double c = SRC_Calc_Type.factorial(n - r);
        Double answer = factn / (factr * c);
        if (n > r) {
            System.out.printf("(%s :C: %s) == %s\n", n, r, answer);
        }
        if (n < r) {
            System.out.println("n must be larger than r\n");
        }
        return answer;

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static BigInteger BigFactorial(int n) {
        return BigPermutation(n, n);
    }

    public static Double factorial(Double n) {
        Double fact = 1.0; // this  will be the result
        for (Double i = 1.0; i <= n; i++) {
            fact *= i;
        }
        return fact;
    } //Factorial method

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}