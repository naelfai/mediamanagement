package tests;

import ratings.MediaLibrary;
import ratings.Ratable;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class TestClasses3 {
    public boolean compareRatableArrayLists(ArrayList<Ratable> list1, ArrayList<Ratable> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            Ratable object1 = list1.get(i);
            Ratable object2 = list2.get(i);
            if (!object1.getTitle().equals(object2.getTitle())) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testTop3Ratables() {
        MediaLibrary mediaLibrary = new MediaLibrary();
        mediaLibrary.populateLibrary("data/songlist2.csv", "data/m1.csv", "data/ratings.csv");
        ArrayList<Ratable> top3Ratables = mediaLibrary.topKRatables(3);
        Assert.assertEquals(3, top3Ratables.size());
        Assert.assertEquals("Nightcore", top3Ratables.get(0).getTitle());
        Assert.assertEquals("Hello", top3Ratables.get(1).getTitle());
        Assert.assertEquals("Movie1", top3Ratables.get(2).getTitle());
    }

}




