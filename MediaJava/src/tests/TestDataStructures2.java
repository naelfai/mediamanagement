package tests;
import ratings.Playlist;
import ratings.Rating;
import ratings.datastructures.*;
import ratings.Song;
import org.junit.Test;
import org.junit.Assert;


public class TestDataStructures2 {
    public boolean compareSongTrees(BinaryTreeNode<Song> songTree1, BinaryTreeNode<Song> songTree2) {
        TestClasses1 testClasses1 = new TestClasses1();
        TestDataStructures1 testDataStructures1 = new TestDataStructures1();

        if (songTree1 == null && songTree2 == null) {
            return true;
        } else if (songTree1 == null || songTree2 == null) {
            return false;
        }
        if (!testClasses1.compareSongs(songTree1.getValue(), songTree2.getValue())) {
            return false;
        }
        if (!testDataStructures1.compareListsOfRatings(songTree1.getValue().getRatings(), songTree2.getValue().getRatings())) {
            return false;
        }

        boolean left = compareSongTrees(songTree1.getLeft(), songTree2.getLeft());
        boolean right = compareSongTrees(songTree1.getRight(), songTree2.getRight());
        return left && right;
    }


    @Test
    public void testGetSongTree1() {
        Comparator<Song> comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        Song song1 = new Song("1", "1", "1");
        playlist.addSong(song1);
        BinaryTreeNode<Song> songTree = playlist.getSongTree();
        Assert.assertNotNull(songTree);
        BinaryTreeNode<Song> expectedTree = new BinaryTreeNode<>(song1, null, null);
        Assert.assertTrue(compareSongTrees(songTree, expectedTree));
    }

    @Test
    public void testGetSongTree2() {
        Comparator<Song> comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);

        Song song1 = new Song("a", "1", "1");
        Song song2 = new Song("b", "2", "2");
        Song song3 = new Song("c    ", "3", "3");
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        BinaryTreeNode<Song> actualTree = playlist.getSongTree();
        Assert.assertNotNull(actualTree);
        BinaryTreeNode<Song> expectedTree = new BinaryTreeNode<>(song1, null, null);
        expectedTree.setRight(new BinaryTreeNode<>(song2, null, null));
        expectedTree.getRight().setRight(new BinaryTreeNode<>(song3, null, null));

        Assert.assertTrue(compareSongTrees(actualTree, expectedTree));
    }

    @Test
    public void testEmptyPlaylist() {
        Comparator<Song> comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);

        LinkedListNode<Song> songList = playlist.getSongList();
        Assert.assertNull(songList);
    }
    @Test
    public void testGetSongList(){
        Comparator<Song> comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        Song song1 = new Song("Jiffy", "Baby Smoove", "1");
        Song song2 = new Song("Godspeed", "Frank Ocean", "2");
        Song song3 = new Song("Unbothered", "Omar Apollo", "3");
        Song song4 = new Song("Altitude", "Montell Fish", "4");
        Song song5 = new Song("Polynesian", "Smino", "5");
        playlist.addSong(song4);
        playlist.addSong(song2);
        playlist.addSong(song1);
        playlist.addSong(song5);
        playlist.addSong(song3);

        LinkedListNode<Song> songList = playlist.getSongList();
        LinkedListNode<Song> expectedSongList = new LinkedListNode<>(song4, null);
        LinkedListNode<Song> node2 = new LinkedListNode<>(song2, null);
        LinkedListNode<Song> node3 = new LinkedListNode<>(song1, null);
        LinkedListNode<Song> node4 = new LinkedListNode<>(song5, null);
        LinkedListNode<Song> node5 = new LinkedListNode<>(song3, null);

        expectedSongList.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        LinkedListNode<Song> actualSong = songList;
        LinkedListNode<Song> expectedSong = expectedSongList;
        while (actualSong != null & expectedSong != null){
            Assert.assertEquals(actualSong.getValue().getTitle(),expectedSong.getValue().getTitle());
            actualSong = actualSong.getNext();
            expectedSong = expectedSong.getNext();
        }

        Assert.assertNull(actualSong);
        Assert.assertNull(expectedSong);
    }


}


