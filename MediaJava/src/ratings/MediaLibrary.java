package ratings;

import ratings.datastructures.RatableBayesianRatingComparator;

import java.util.ArrayList;

public class MediaLibrary {
    private ArrayList<Ratable> mediaLibrary;

    public MediaLibrary() {
        this.mediaLibrary = new ArrayList<>();
    }

    public void populateLibrary(String songFile, String movieFile, String movieRatingsFile) {
        ArrayList<Song> songs = FileReader.readSongs(songFile);
        mediaLibrary.addAll(songs);
        ArrayList<Movie> movies = FileReader.readMovies(movieFile);
        ArrayList<Movie> moviesRated = FileReader.readMovieRatings(movies, movieRatingsFile);
        mediaLibrary.addAll(moviesRated);
    }

    public ArrayList<Ratable> topKRatables(int k) {
        mediaLibrary.sort(new RatableBayesianRatingComparator());
        if (k > mediaLibrary.size()) {
            return new ArrayList<>(mediaLibrary);
        }
        return new ArrayList<>(mediaLibrary.subList(0, k));
    }
}