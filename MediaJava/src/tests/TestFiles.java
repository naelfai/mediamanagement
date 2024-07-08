package tests;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;
import ratings.datastructures.*;
import ratings.Song;


public class TestFiles {


    public boolean compareMovieArrayLists(ArrayList<Movie> actual, ArrayList<Movie> expected) {
        Assert.assertEquals(actual.size(), expected.size());

        for (Movie movie1 : actual) {
            boolean match = false;
            for (Movie movie2 : expected) {
                if (compareMovies(movie1, movie2)) {
                    match = true;
                    break;
                }
            }

            if (!match) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareSongArrayLists(ArrayList<Song> actual, ArrayList<Song> expected) {
        Assert.assertEquals(actual.size(), expected.size());

        for (Song song1 : actual) {
            boolean match = false;

            for (Song song2 : expected) {
                if (TestClasses1.compareSongs(song1, song2) && TestDataStructures1.compareListsOfRatings(song1.getRatings(), song2.getRatings())) {
                    match = true;
                    break;
                }
            }

            if (!match) {
                return false;
            }
        }
        return true;
    }


    private boolean compareMovies(Movie movie1, Movie movie2) {
        if (!movie1.getTitle().equals(movie2.getTitle())) {
            return false;
        }
        if (!movie1.getCast().equals(movie2.getCast())) {
            return false;
        }
        if (!TestDataStructures1.compareListsOfRatings(movie1.getRatings(), movie2.getRatings())) {
            return false;
        }
        return true;
    }


    //TESTS

    @Test
    public void testReadSong() {
        String filename = "data/songlist1.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        ArrayList<Song> expected = new ArrayList<>();
        Song singleSong = new Song("Nightcore", "Ken Carson", "6p1j9OP2IBdzR5tgtyJk10");
        Rating nightcoreRating = new Rating("221", 5);
        singleSong.addRating(nightcoreRating);
        expected.add(singleSong);
        Assert.assertTrue(compareSongArrayLists(actual, expected));
    }

    @Test
    public void testReadSongs() {
        String filename = "data/songlist2.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);

        ArrayList<Song> expected = new ArrayList<>();
        Song nightcore = new Song("Nightcore", "Ken Carson", "1");
        nightcore.addRating(new Rating("221", 5));
        expected.add(nightcore);

        Song hello = new Song("Hello", "Adele", "2");
        hello.addRating(new Rating("222", 5));
        expected.add(hello);

        Song flashingLights = new Song("Flashing Lights", "Kanye West", "3");
        flashingLights.addRating(new Rating("40", 5));
        flashingLights.addRating(new Rating("41", 3));

        expected.add(flashingLights);

        Assert.assertEquals(expected.size(), actual.size());
        for (Song expectedSong : expected){

            boolean found = false;
            for (Song actualSong : actual){
                if (expectedSong.getSongID().equals(actualSong.getSongID())){
                    TestClasses1.compareSongs(expectedSong, actualSong);
                    TestDataStructures1.compareListsOfRatings(expectedSong.getRatings(), actualSong.getRatings());

                    found = true;
                    break;
                }
            }

            Assert.assertEquals(true, found);
        }
    }

    @Test
    public void testSongInvalidName(){
        String filename = "invalidName.csv";
        ArrayList<Song> actual = FileReader.readSongs(filename);
        ArrayList<Song> expected = new ArrayList<>();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testTitleAndCast() {
        String filename = "data/m1.csv";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        ArrayList<Movie> expected = new ArrayList<>();

        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Cast 1");
        cast1.add("Cast 2");
        Movie movie1 = new Movie("Movie1", cast1);

        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Cast 3");
        cast2.add("Cast 4");
        Movie movie2 = new Movie("Movie2", cast2);

        ArrayList<String> cast3 = new ArrayList<>();
        cast3.add("Cast 5");
        cast3.add("Cast 6");
        Movie movie3 = new Movie("Movie3", cast3);

        expected.add(movie1);
        expected.add(movie2);
        expected.add(movie3);

        Assert.assertTrue(compareMovieArrayLists(actual, expected));
    }

    @Test
    public void testInvalidMovieName(){
        String filename = "invalidName";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        ArrayList<Movie> expected = new ArrayList<>();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void testInvalidFileName(){
        String filename = "invalidname";
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Movie> actual = FileReader.readMovieRatings(movies, filename);
        ArrayList<Movie> expected = new ArrayList<>();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testMovieRatings(){
        String movieFile = "data/m1.csv";
        ArrayList<Movie> listOfMovies = FileReader.readMovies(movieFile);
        String movieRatingsFile = "data/ratings.csv";
        ArrayList<Movie> actualMovieRatings = FileReader.readMovieRatings(listOfMovies, movieRatingsFile);

        ArrayList<Movie> expectedMovieRatings = new ArrayList<>();
        ArrayList<String> cast1 = new ArrayList<>();
        cast1.add("Cast 1");
        cast1.add("Cast 2");
        Movie movie1 = new Movie("Movie1", cast1);
        ArrayList<String> cast2 = new ArrayList<>();
        cast2.add("Cast 3");
        cast2.add("Cast 4");
        Movie movie2 = new Movie("Movie2", cast2);
        ArrayList<String> cast3 = new ArrayList<>();
        cast3.add("Cast 5");
        cast3.add("Cast 6");
        Movie movie3 = new Movie("Movie3", cast3);

        movie1.addRating(new Rating("100", 2));
        movie2.addRating(new Rating("101", 4));
        movie3.addRating(new Rating("102", 2));
        expectedMovieRatings.add(movie1);
        expectedMovieRatings.add(movie2);
        expectedMovieRatings.add(movie3);

        Assert.assertTrue(compareMovieArrayLists(actualMovieRatings,expectedMovieRatings));








    }

}
