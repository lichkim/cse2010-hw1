package cse2010.hw1;

public class Utils {

    /**
     * Find an index of an element matching `target`.
     * @param xs int array
     * @param target element to be found
     * @return index of a matching element, -1 otherwise
     */
    public static int findIndex(int[] xs, int target) {

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] == target) {return i;}
        }

        //여기 까지 return되지 않았으면 array 안에 없는 것이다. 그러므로 -1 반환.
        return -1;
    }

    /**
     * Calculate the sum of an array.
     * @param xs double array
     * @return sum of an array
     */
    public static double sum(double[] xs) {
        double answer = 0.0;
        
        for (double ele : xs){
            answer += ele;
        }

        return answer;
    }

    /**
     * Reverse the elements of a String array. For example, ["A", "BB", "C"] => ["C", "BB", "A"]
     * @param xs String array
     * @return a newly created array containing elements of xs in reversed order
     */
    public static String[] reverse(String[] xs) {
        String[] reversedArray = new String[xs.length];

        for (int i = 0; i < xs.length; i++) {
            reversedArray[i] = xs[xs.length - 1 - i];
        }

        return reversedArray;
    }

    /**
     * Reverse the elements of a String array in place without creating a new array.
     * Input array xs itself must be transformed to an array containing elements
     * in reversed order.
     * For example, ["A", "BB", "C"] => ["C", "BB", "A"].
     * @param xs String array
     */
    public static void reverse_in_place(String[] xs) {
        for (int i = 0; i < (int)(xs.length / 2); i++) {
            swap(xs, i, xs.length - 1 - i);
        }
    }

    //reverse_in_place 함수에 사용될 swap 함수
    private static void swap(String[] xs, int idx1, int idx2) {
        String temp = xs[idx1];
        xs[idx1] = xs[idx2];
        xs[idx2] = temp;
    }

    /**
     * Returns an array containing running averages of an array.
     * @param xs int array
     * @return an array containing running average
     *
     * Given an input xs = [1, 2, 3, 4], `average()` returns a new array
     * containing running averages [1.0, 1.5, 2.0, 2.5].
     * Here,
     *      1.0 = 1 / 1
     *      1.5 = (1 + 2) / 2
     *      2.0 = (1 + 2 + 3) / 3
     *      2.5 = (1 + 2 + 3 + 4) / 4
     */
    public static double[] average(int[] xs) {
        double[] stochasticAverageArr = new double[xs.length];

        stochasticAverageArr[0] = (double)xs[0];
        for (int i = 1; i < xs.length; i++) {
            //매번 처음부터 끝까지 더하지 말고 기존에 구한 평균 값을 활용하면 더 적은 시간 복잡도를 가진다
            //다만 이러려면 나눗셈 한 것을 다시 곱하는 과정에서 숫자 손실이 발생할 수 있음
            //ex: 1/3 = 0.333... 이지만 0.333...*3 == 1 임을 컴퓨터는 모를 수 있음. 컴퓨터가 숫자를 저장하는 방식이 인간이 숫자를 다루는 방식과 다르기 때문에
            stochasticAverageArr[i] = ((stochasticAverageArr[i - 1] * i) + xs[i]) / (i + 1);
        }

        return stochasticAverageArr;
    }

}
