package ratings;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileReader {

    private static ArrayList<String> readFile(String filename) {
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static ArrayList<Song> readSongs(String filename) {
        HashMap<String, Song> songs = new HashMap<>();
        ArrayList<String> lines = readFile(filename);

        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String songID = splits.get(0);
            String artist = splits.get(1);
            String title = splits.get(2);
            String reviewerID = splits.get(3);
            int ratingNum = Integer.parseInt(splits.get(4));

            Rating rating = new Rating(reviewerID, ratingNum);
            if (!songs.containsKey(songID)) {
                Song song = new Song(title, artist, songID);
                song.addRating(rating);
                songs.put(songID, song);
            } else {
                Song existingSong = songs.get(songID);
                existingSong.addRating(rating);
            }
        }

        return new ArrayList<>(songs.values());
    }


    public static ArrayList<Movie> readMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<String> lines = readFile(filename);
        for (String line : lines) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String movieTitle = splits.get(0);

            ArrayList<String> castMembers = new ArrayList<>();
            for (int i = 1; i < splits.size(); i++) {
                castMembers.add(splits.get(i));
            }
            Movie movie = new Movie(movieTitle, castMembers);
            movies.add(movie);
        }
        return movies;
    }

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> movies, String filename) {
        HashMap<String, Movie> movieHashMap = new HashMap<>();
        for (Movie movie : movies){
            movieHashMap.put(movie.getTitle(), movie);}

        ArrayList<String> lines = readFile(filename);
        for (String line : lines){
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
            String title = splits.get(0);
            String reviewerID = splits.get(1);
            int ratingValue = Integer.parseInt(splits.get(2));

            if (movieHashMap.containsKey(title)){
                Movie movie = movieHashMap.get(title);
                Rating rating = new Rating(reviewerID, ratingValue);
                movie.addRating(rating);
            }

        }


        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movieHashMap.values()){
            if (movie.getRatings() != null){
                result.add(movie);}
        }


        return result;
    }
}



