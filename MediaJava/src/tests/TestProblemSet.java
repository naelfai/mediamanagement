package tests;

import org.junit.Test;
import ratings.ProblemSet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestProblemSet {
    @Test
    public void testAverage(){

        ArrayList<Double> list1 = new ArrayList<Double>();
        list1.add(1.0);
        list1.add(2.0);
        list1.add(3.0);
        assertEquals(2.0, ProblemSet.average(list1), 0.001);

        ArrayList<Double> list2 = new ArrayList<Double>();
        list2.add(-30.0);
        list2.add(30.0);
        assertEquals(0.0, ProblemSet.average(list2), 0.001);

        ArrayList<Double> list3 = new ArrayList<Double>();
        list3.add(3.4);
        list3.add(3.6);
        assertEquals(3.5, ProblemSet.average(list3), 0.001);

        ArrayList<Double> list4 = new ArrayList<Double>();
        assertEquals(0.0, ProblemSet.average(list4), 0.001);

        ArrayList<Double> list5 = new ArrayList<>();
        list5.add(100.0);
        assertEquals(100.0, ProblemSet.average(list5), 0.001);

        ArrayList<Double> list6 = new ArrayList<Double>();
        list6.add(1.0);
        list6.add(1.0);
        list6.add(1.0);
        list6.add(1.0);
        list6.add(1.0);
        list6.add(1.0);

        assertEquals(1, ProblemSet.average(list6), 0.001);


    }
    @Test
    public void testSumOfDigit(){
        assertEquals(12, ProblemSet.sumOfDigits(66));
        assertEquals(24, ProblemSet.sumOfDigits(888));
        assertEquals(5, ProblemSet.sumOfDigits(-32));
        assertEquals(8, ProblemSet.sumOfDigits(8));
        assertEquals(0, ProblemSet.sumOfDigits(0));
        assertEquals(9, ProblemSet.sumOfDigits(-9));
        assertEquals(7, ProblemSet.sumOfDigits(-7));
        assertEquals(15, ProblemSet.sumOfDigits(-555));


    }

    @Test
    public void testBestKey(){
        HashMap<String, Integer> hash1 = new HashMap<>();
        hash1.put("A", 100);
        hash1.put("B", 10);
        hash1.put("C", 10);
        String result1 = ProblemSet.bestKey(hash1);
        assertEquals("A", result1);

        HashMap<String,Integer> hash2 = new HashMap<>();
        hash2.put("Bob", 10);
        hash2.put("Rob", 10);
        hash2.put("Mob", 5);
        String result2 = ProblemSet.bestKey(hash2);

        ArrayList<String> listOfAnswers = new ArrayList<String>();
        listOfAnswers.add("Bob");
        listOfAnswers.add("Rob");
        assertTrue(listOfAnswers.contains(result2));

        HashMap<String,Integer> hash3 = new HashMap<>();
        String result3 = ProblemSet.bestKey(hash3);
        assertEquals("", result3);

        HashMap<String,Integer> hash4 = new HashMap<>();
        hash4.put("apple", -10);
        hash4.put("orange", -1);
        hash4.put("banana", -2);
        String result4 = ProblemSet.bestKey(hash4);
        assertEquals("orange", result4);

        HashMap<String,Integer> hash5 = new HashMap<>();
        hash5.put("X", 100000);
        hash5.put("Y", -100000);
        hash5.put("Z", 0);
        String result5 = ProblemSet.bestKey(hash5);
        assertEquals("X", result5);
    }


}





