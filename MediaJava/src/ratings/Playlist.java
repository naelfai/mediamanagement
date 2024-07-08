package ratings;
import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongTitleComparator;


public class Playlist {
    private BinaryTreeNode<Song> songRoot;
    private Comparator<Song> songComparator;

    public Playlist(Comparator<Song> comparator) {
        this.songComparator = comparator;
        this.songRoot = null;
    }

    //addSong, and insertHelper to help insert songs into tree

    public void addSong(Song song){
        if (songRoot == null){
            songRoot = new BinaryTreeNode<>(song, null, null);}
        else{
            insertHelper(songRoot, song);}
    }
    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (songComparator.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }

    public BinaryTreeNode<Song> getSongTree(){
        return songRoot;
    }

    public LinkedListNode<Song> getSongList(){
        return getSongList(this.songRoot);
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> songBinaryTreeNode){
        LinkedListNode<Song> dummyHead = new LinkedListNode<>(null, null);
        LinkedListNode<Song> currentNode = dummyHead;
        currentNode = inOrderTraversal(songBinaryTreeNode, currentNode);


        return dummyHead.getNext();
    }

    private LinkedListNode<Song> inOrderTraversal(BinaryTreeNode<Song> node, LinkedListNode<Song> currentNode){
        if (node != null){
            currentNode = inOrderTraversal(node.getLeft(), currentNode);
            LinkedListNode<Song> newNode = new LinkedListNode<>(node.getValue(), null);
            currentNode.setNext(newNode);
            currentNode = newNode;
            currentNode = inOrderTraversal(node.getRight(), currentNode);
        }

        return currentNode;
    }


    }





