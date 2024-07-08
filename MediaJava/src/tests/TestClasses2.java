package tests;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;
import ratings.Movie;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

public class TestClasses2 {
    public boolean compareArrayListsIgnoreCase(ArrayList<String> list1, ArrayList<String> list2){
        if (list1.size()!= list2.size()){
            return false;
        }

        for (int i = 0; i < list1.size(); i++){
            String val1 = list1.get(i);
            String val2 = list2.get(i);
            if (val1.compareToIgnoreCase(val2) != 0){
                return false;}
        }


        return true;
    }

    @Test
    public void testSameCase() {
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Chadwick Boseman");
        cast1.add("Zoe Saldana");
        cast1.add("Dave Bautista");
        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Chadwick Boseman");
        cast2.add("Zoe Saldana");
        cast2.add("Dave Bautista");

        Assert.assertTrue(compareArrayListsIgnoreCase(cast1, cast2));
    }

    @Test
    public void testDiffCase() {
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Chadwick Boseman");
        cast1.add("Zoe Saldana");
        cast1.add("Dave Bautista");
        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("chadwick boseman");
        cast2.add("zOE saldana");
        cast2.add("davE bautISTA");

        Assert.assertTrue(compareArrayListsIgnoreCase(cast1, cast2));
    }

    @Test
    public void testDiffOrder() {
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Chadwick Boseman");
        cast1.add("Zoe Saldana");
        cast1.add("Dave Bautista");
        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Dave Bautista");
        cast2.add("Zoe Saldana");
        cast2.add("Chadwick Boseman");


        Assert.assertFalse(compareArrayListsIgnoreCase(cast1, cast2));
    }

    @Test
    public void testDiffSize() {
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Chadwick Boseman");
        cast1.add("Zoe Saldana");

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Chadwick Boseman");
        cast2.add("Zoe Saldana");
        cast2.add("Dave Bautista");

        Assert.assertFalse(compareArrayListsIgnoreCase(cast1, cast2));
    }

    @Test
    public void testEmptyList() {
        ArrayList<String> cast1 = new ArrayList<>();
        ArrayList<String> cast2 = new ArrayList<>();

        Assert.assertTrue(compareArrayListsIgnoreCase(cast1, cast2));
    }

    @Test
    public void testGetCastOrder() {
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Chris Pratt");
        cast1.add("Zoe Saldana");
        cast1.add("Dave Bautista");
        Movie movie1 = new Movie("Guardians of the Galaxy", cast1);

        Assert.assertTrue(compareArrayListsIgnoreCase(cast1, movie1.getCast()));
    }

    @Test
    public void testCastMemberMultiple() {
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Samuel L. Jackson");
        cast1.add("Michael Sheen");
        cast1.add("Carrie-Anne Moss");
        Movie movie1 = new Movie("Unthinkable", cast1);
        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Samuel L. Jackson");
        cast2.add("Michael Sheen");
        cast2.add("Carrie-Anne Moss");

        Assert.assertTrue(compareArrayListsIgnoreCase(cast2, movie1.getCast()));
    }

    @Test
    public void testBayesianAverageNoRatings() {
        Song song1 = new Song("Hello", "Adele", "123");

        Assert.assertEquals(0.0, song1.bayesianAverageRating(0, 3), 0.01);
    }

    @Test
    public void testBayesianAverageRatings() {
        Song song1 = new Song("Hello", "Adele", "123");

        Rating rating1 = new Rating("r1", 4);
        Rating rating2 = new Rating("r1", 5);
        Rating rating3 = new Rating("r1", 3);

        song1.addRating(rating1);
        song1.addRating(rating2);
        song1.addRating(rating3);


        Assert.assertEquals(4.0, song1.bayesianAverageRating(0, 3), 0.01);
    }

    @Test
    public void testBayesianAverageInvalidRatings() {
        Song song1 = new Song("Hello", "Adele", "123");

        Rating rating1 = new Rating("r1", -1);
        Rating rating2 = new Rating("r1", -1);
        Rating rating3 = new Rating("r1", -1);

        song1.addRating(rating1);
        song1.addRating(rating2);
        song1.addRating(rating3);


        Assert.assertEquals(0.0, song1.bayesianAverageRating(0, 3), 0.01);
    }

    @Test
    public void testBayesianAverageEdge() {
        Song song1 = new Song("Hello", "Adele", "123");

        Rating rating1 = new Rating("r1", -1);
        Rating rating2 = new Rating("r1", -1);
        Rating rating3 = new Rating("r1", -1);

        song1.addRating(rating1);
        song1.addRating(rating2);
        song1.addRating(rating3);


        Assert.assertEquals(0.0, song1.bayesianAverageRating(1, -1), 0.01);
    }







}
