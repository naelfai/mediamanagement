package ratings.datastructures;

public class IntDecreasing implements Comparator<Integer>{

    @Override
    public boolean compare(Integer a, Integer b){
        return a>b;
    }
}
