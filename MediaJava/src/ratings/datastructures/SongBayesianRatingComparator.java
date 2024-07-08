package ratings.datastructures;

import ratings.Song;
import ratings.datastructures.Comparator;

public class SongBayesianRatingComparator implements Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b) {
        double bayesianA = a.bayesianAverageRating(2,3);
        double bayesianB = b.bayesianAverageRating(2,3);

        return bayesianA>bayesianB;
    }
}
