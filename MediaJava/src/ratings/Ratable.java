package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;

    private LinkedListNode<Rating> ratingLinkedList;


    //G&S Methods
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addRating(Rating rating) {
        if (ratingLinkedList == null) {
            ratingLinkedList = new LinkedListNode<>(rating, null);
        } else {
            LinkedListNode<Rating> currentNode = ratingLinkedList;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new LinkedListNode<>(rating, null));
        }
    }

    public LinkedListNode<Rating> getRatings() {
        return ratingLinkedList;
    }

    public void setRatings(LinkedListNode<Rating> ratingLinkedList) {
        this.ratingLinkedList = ratingLinkedList;
    }

    public double averageRating(){
        double ratingSum = 0.0;
        int ratingCount = 0;

        if (ratingLinkedList == null){
            return 0.0;}

        LinkedListNode<Rating> currentLLN = ratingLinkedList;
        while (currentLLN != null){
            Rating rating = currentLLN.getValue();

            if (rating.getRating() != -1) {
                ratingSum += rating.getRating();
                ratingCount++;}
            currentLLN = currentLLN.getNext();
        }
        if (ratingCount == 0) {
            return 0.0;}
        else {
            return ratingSum / ratingCount;
        }
    }


    public void removeRatingByReviewer(Reviewer reviewer){
        if (ratingLinkedList == null){
            return;
        }

        LinkedListNode<Rating> previousLLN = null;
        LinkedListNode<Rating> currentLLN = ratingLinkedList;
        while (currentLLN != null){
            Rating currentRating = currentLLN.getValue();

            if (currentRating.getReviewerID().equals(reviewer.getReviewerID())) {
                if (previousLLN == null) {
                    ratingLinkedList = currentLLN.getNext(); }
                else {
                    previousLLN.setNext(currentLLN.getNext());
                }
                return;}


            previousLLN = currentLLN;
            currentLLN = currentLLN.getNext(); }
    }

    public double bayesianAverageRating(int extraRatingsNum, int extraRatingsVal) {
      // make sure that it isn't invalid
        if (extraRatingsNum < 0) {
            return 0.0;}
        if (extraRatingsVal < 1 || extraRatingsVal > 5) {
            return 0.0; }

// calculate the # of ratings
        double averageRating = averageRating();
        int ratingCount = 0;
        LinkedListNode<Rating> currentLLN = ratingLinkedList;
        while (currentLLN != null) {
            currentLLN = currentLLN.getNext();
            ratingCount++;
        }

        int ratingNum = ratingCount + extraRatingsNum;
        double ratingSum = ratingCount * averageRating;
        double extraRatingSum = (extraRatingsVal * extraRatingsNum) + ratingSum;

        if (ratingNum == 0){
            return 0.0;
        } else {
            return extraRatingSum / ratingNum;
        }
    }
}

