package moblima;

import java.util.Comparator;

public class SortbyScore implements Comparator<Movie>{
	public int compare(Movie a, Movie b) 
    { 
		if (a.getScore() < b.getScore()) return -1;
        if (a.getScore() > b.getScore()) return 1;
        return 0;
    } 
}
