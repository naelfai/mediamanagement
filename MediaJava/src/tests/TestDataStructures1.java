package tests;

import org.junit.Assert;
import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.LinkedListNode;

public class TestDataStructures1 {
    public static boolean compareListsOfRatings(LinkedListNode<Rating> list1, LinkedListNode<Rating> list2) {
        LinkedListNode<Rating> currentLLN1 = list1;
        LinkedListNode<Rating> currentLLN2 = list2;


        while (currentLLN1 != null && currentLLN2 != null) {
            Rating rating1 = currentLLN1.getValue();
            Rating rating2 = currentLLN2.getValue();
            //JUnit asserts to check that my ratings n reviewers r the same
            Assert.assertEquals(rating1.getRating(), rating2.getRating());
            Assert.assertEquals(rating1.getReviewerID(), rating2.getReviewerID());


            currentLLN1 = currentLLN1.getNext();
            currentLLN2 = currentLLN2.getNext();
        }
        //assert that currentLLN1 and 2 equal null and signals end of linked list
        Assert.assertNull(currentLLN1);
        Assert.assertNull(currentLLN2);
        return true;
    }

    // TASK 3 TESTS

    //TEST AVERAGE RATING METHOD
    @Test
    public void testAverageRatingNull() {
        Song song2 = new Song("Blue", "Cat", "321");
        song2.setRatings(null);


        // Test average rating
        Assert.assertEquals(0.0, song2.averageRating(), 0.001);
    }
    @Test
    public void testAverageRatingEdgeCases() {
        Song song1 = new Song("Hello", "Adele", "111");
        song1.addRating(new Rating("ID1", -1));
        song1.addRating(new Rating("ID2", -1));


        Song song2 = new Song("Care", "Sonder", "222");
        song2.addRating(new Rating("ID3", 6));
        song2.addRating(new Rating("ID4", 8));


        Song song3 = new Song("Jennah's Interlude", "Blue Iverson", "333");
        song3.addRating(new Rating("ID5", 0));
        song3.addRating(new Rating("ID6", -10));


        Song song4 = new Song("CARNIVAL", "Kanye West", "444");
        song4.addRating(new Rating("ID7", 2));
        song4.addRating(new Rating("ID8", 3));
        song4.addRating(new Rating("ID9", 4));


        Song song5 = new Song("Good Days", "SZA", "999");




        Assert.assertEquals(0.0, song1.averageRating(), 0.001);
        Assert.assertEquals(0.0, song2.averageRating(), 0.001);
        Assert.assertEquals(0.0, song3.averageRating(), 0.001);
        Assert.assertEquals(3, song4.averageRating(), 0.001);
        Assert.assertEquals(0.0, song5.averageRating(), 0.001);




    }
    @Test
    public void testRemoveRatingByReviewer() {
        Song song1 = new Song("aaah", "artist", "1");
        Reviewer reviewer1 = new Reviewer("r1");

        Rating rating1 = new Rating("r1", 4);
        Rating rating2 = new Rating("r1", 5);
        Rating rating3 = new Rating("r1", 3);

        song1.addRating(rating1);
        song1.addRating(rating2);
        song1.addRating(rating3);
        song1.removeRatingByReviewer(reviewer1);

        LinkedListNode<Rating> r1list = new LinkedListNode<>(rating2, null);
        r1list.setNext(new LinkedListNode<>(rating3, null));

        Assert.assertTrue(compareListsOfRatings(song1.getRatings(), r1list));


    }
    @Test
    public void testRemoveLastRatingByReviewer() {
        Song song2 = new Song("aaah", "raaah", "2");
        Reviewer reviewer2 = new Reviewer("r2");
        Reviewer reviewer3 = new Reviewer("r3");

        Rating rating4 = new Rating("r2", 2);
        Rating rating5 = new Rating("r2", 2);
        Rating rating6 = new Rating("r3", 2);

        song2.addRating(rating4);
        song2.addRating(rating5);
        song2.addRating(rating6);
        song2.removeRatingByReviewer(reviewer3);

        LinkedListNode<Rating> r2list = new LinkedListNode<>(rating4, null);
        r2list.setNext(new LinkedListNode<>(rating5, null));

        Assert.assertTrue(compareListsOfRatings(song2.getRatings(), r2list));

    }


}




