package ratings.datastructures;

import ratings.Ratable;
import java.util.Comparator;

public class RatableBayesianRatingComparator implements Comparator<Ratable> {
    @Override
    public int compare(Ratable a, Ratable b) {
        double bayesianA = a.bayesianAverageRating(2, 3);
        double bayesianB = b.bayesianAverageRating(2, 3);
        return Double.compare(bayesianB, bayesianA);
    }
}
