package ratings.datastructures;

import ratings.Song;
import ratings.datastructures.Comparator;

public class SongTitleComparator implements Comparator<Song> {
    @Override
    public boolean compare(Song a, Song b) {
        String songTitle1 = a.getTitle();
        String songTitle2 = b.getTitle();

        return songTitle1.compareToIgnoreCase(songTitle2) <0;
    }
}
