package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {
    public static double average(ArrayList<Double> numbers) {
        double sum = 0.0;
        if (numbers.isEmpty()) {
            return 0.0;
        }
        for (int x = 0; x < numbers.size(); x++) {
            sum += numbers.get(x);
        }

        double avg = sum / numbers.size();
        return avg;
    }

    public static int sumOfDigits(int x) {
        int sum = 0;

        int input = Math.abs(x);
        while (input > 0) {
            sum += input % 10;
            input /= 10;
        }

        return sum;
    }




    public static String bestKey(HashMap<String, Integer> dict) {
        String biggerKey = null;
        int maxval = Integer.MIN_VALUE;

        if (dict.isEmpty()) {
            return "";
        }

        for (String keyVal : dict.keySet()) {
            int currentVal = dict.get(keyVal);

            if (currentVal > maxval) {
                maxval = currentVal;
                biggerKey = keyVal;

            }
        }
        return biggerKey;
    }

}












