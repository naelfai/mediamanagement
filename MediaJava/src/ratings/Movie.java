package ratings;

import java.util.ArrayList;

public class Movie extends Ratable{
    private ArrayList<String> cast;

    public Movie(String title, ArrayList<String> cast){
        this.cast = cast;
        this.setTitle(title);
    }

    public ArrayList<String> getCast(){
        return new ArrayList<>(this.cast);
    }
}
