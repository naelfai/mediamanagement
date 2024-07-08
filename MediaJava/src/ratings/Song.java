package ratings;

public class Song extends Ratable {
    private String artist;
    private String songID;


    public Song(String title, String artist, String songID) {
        this.setTitle(title);
        this.artist = artist;
        this.songID = songID;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return this.songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }
}










