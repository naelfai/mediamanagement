package ratings.datastructures;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort<T> {
    private Comparator<T> comparator;

    public InsertionSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public ArrayList<T> sort(ArrayList<T> input){
        ArrayList<T> output = new ArrayList<>();
        for (T valueToInsert : input){
            int location = 0;
            for (T valueToCompare : output){
                if (comparator.compare(valueToCompare,valueToInsert)){
                    location++;
                }
            }
            output.add(location,valueToInsert);
        }

        return output;
    }

    public static void main(String[] args) {
        InsertionSort<Integer> sort = new InsertionSort<>(new IntDecreasing());
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,6,5));
        ArrayList<Integer> output = sort.sort(list);
        System.out.println(output);
    }
}
