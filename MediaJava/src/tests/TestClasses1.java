package tests;
import org.junit.Test;
import ratings.Song;
import ratings.Rating;
import ratings.Reviewer;
import org.junit.Assert;
import ratings.datastructures.LinkedListNode;

public class TestClasses1 {

    //TEST METHODS
    public static boolean compareSongs(Song song1, Song song2){
        Assert.assertEquals(song1.getSongID(), song2.getSongID());
        Assert.assertEquals(song1.getArtist(), song2.getArtist());
        Assert.assertEquals(song1.getTitle(), song2.getTitle());
        return true;
    }
    public boolean compareRatings(Rating rating1, Rating rating2){
        Assert.assertEquals(rating1.getRating(), rating2.getRating());
        Assert.assertEquals(rating1.getReviewerID(), rating2.getReviewerID());
        return true;
    }
    public boolean compareReviewers(Reviewer reviewer1, Reviewer reviewer2){
        Assert.assertEquals(reviewer1.getReviewerID(), reviewer2.getReviewerID());
        return true;
    }



    // EVERYTHING BELOW THIS IS TASK 1 & 2
    //TEST SONG
    @Test
    public void testCompareSongs(){
        Song song1 = new Song("Title1", "Artist1", "songID1");
        Song song2 = new Song("Title1", "Artist1", "songID1");
        Assert.assertTrue(compareSongs(song1, song2));
    }
    @Test
    public void testSongSet() {
        Song song = new Song("Hello", "Adele", "ID1");

        // Test setters
        song.setTitle("Bye");
        song.setArtist("Not Adele");
        song.setSongID("ID2");
        Assert.assertEquals("Bye", song.getTitle());
        Assert.assertEquals("Not Adele", song.getArtist());
        Assert.assertEquals("ID2", song.getSongID());
    }



    // COMPARE RATINGS
    @Test
    public void testCompareRatings(){
        Rating rating1 = new Rating("ReviewerID1", 1);
        Rating rating2 = new Rating("ReviewerID1", 1);
        Assert.assertTrue(compareRatings(rating1, rating2));

    }
    @Test
    public void testRatingSet() {
        Rating rating0 = new Rating("ID2005", 5);
        Rating rating1 = new Rating("ID1", 6);
        Rating rating2 = new Rating("ID3", 0);
        Rating rating3 = new Rating("ID4", 10);

        Rating invalidrating = new Rating("ID5", 0);
        Assert.assertEquals(-1, invalidrating.getRating());


        rating0.setReviewerID("ID5002");
        rating1.setRating(7);
        rating2.setRating(5);

        Assert.assertEquals("ID5002", rating0.getReviewerID());
        Assert.assertEquals(5, rating0.getRating());
        Assert.assertEquals(-1, rating1.getRating());
        Assert.assertEquals(5, rating2.getRating());
    }




    //COMPARE REVIEWERS
    @Test
    public void testCompareReviewers() {
        Reviewer reviewer1 = new Reviewer("Apples");
        Reviewer reviewer2 = new Reviewer("Apples");

        Assert.assertTrue(compareReviewers(reviewer1, reviewer2));
    }

    @Test
    public void testReviewerSet() {
        Reviewer reviewer0 = new Reviewer("ID999");


        Reviewer reviewer1 = new Reviewer("ID001");
        Song song1 = new Song("Blah Blah", "Nael", "ID888");


        reviewer0.setReviewerID("0");


        Song song2 = new Song("A", "B", "0");
        Reviewer reviewer2 = new Reviewer("ID100");


        Rating rating = reviewer1.rateSong(3);
        Rating rating2 = reviewer2.rateSong(10);


        Assert.assertEquals("0", reviewer0.getReviewerID());
        Assert.assertEquals("ID001", rating.getReviewerID());
        Assert.assertEquals(3, rating.getRating());
        Assert.assertEquals(-1, rating2.getRating());
        Assert.assertEquals("ID100", reviewer2.getReviewerID());
    }
}
