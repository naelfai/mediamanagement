package ratings;

public class Rating {
        private String ReviewerID;
        private int Rating;


        public Rating(String ReviewerID, int Rating){
            setReviewerID(ReviewerID);
            setRating(Rating);
        }

        public String getReviewerID(){
            return this.ReviewerID;
        }
        public void setReviewerID(String ReviewerID){


            this.ReviewerID = ReviewerID;
        }
        public int getRating(){
            return Rating;
        }


        public void setRating(int Rating){
            if (Rating >= 1 && Rating <= 5){
                this.Rating = Rating;
            }
            else {
                this.Rating = -1;
            }
        }
    }


