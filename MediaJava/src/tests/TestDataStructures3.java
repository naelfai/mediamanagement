package tests;
import org.junit.Test;
import org.junit.Assert;
import ratings.FileReader;
import ratings.Movie;
import ratings.DegreesOfSeparation;
import java.util.ArrayList;

public class TestDataStructures3 {

    @Test
    public void testNonConnectedCastMembers(){
        ArrayList<Movie> movieArrayList = FileReader.readMovies("data/movielist1.csv");
        DegreesOfSeparation degrees = new DegreesOfSeparation(movieArrayList);
        Assert.assertEquals(-1, degrees.degreesOfSeparation("A","H"));
        Assert.assertEquals(-1, degrees.degreesOfSeparation("A","Z"));
        Assert.assertEquals(0, degrees.degreesOfSeparation("A","A"));

    }

    @Test
    public void testSimplePath(){
        ArrayList<Movie> movieArrayList = FileReader.readMovies("data/movielist2.csv");
        DegreesOfSeparation degrees = new DegreesOfSeparation(movieArrayList);
        Assert.assertEquals(3, degrees.degreesOfSeparation("A","D"));
        Assert.assertEquals(2, degrees.degreesOfSeparation("A","C"));
    }

    @Test
    public void testComplexPath(){
        ArrayList<Movie> movieArrayList = FileReader.readMovies("data/movielist3.csv");
        DegreesOfSeparation degrees = new DegreesOfSeparation(movieArrayList);
        Assert.assertEquals(6, degrees.degreesOfSeparation("A", "K"));
        Assert.assertEquals(3, degrees.degreesOfSeparation("A", "F"));
    }
}
