package ratings;

public class Reviewer {
    private String ReviewerID;

    public Reviewer(String ReviewerID){
        this.ReviewerID = ReviewerID;
    }

    public String getReviewerID(){
        return this.ReviewerID;
    }
    public void setReviewerID(String ReviewerID){


        this.ReviewerID = ReviewerID;
    }


    public Rating rateSong(int Rating){
        if (Rating >= 1 && Rating <= 5)
            return new Rating(this.ReviewerID, Rating);
        else {
            return new Rating(this.ReviewerID, -1);
        }
    }
}


