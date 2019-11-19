package model;

public class Movie implements LibraryItem {
    private final String name;
    private final String year;
    private final String director;
    private final int rating;
    private ItemType itemType;


    public Movie(String name, String director, String year, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.itemType = ItemType.MOVIE;
    }

    @Override
    public ItemType getType() {
        return this.itemType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (rating > 0 && rating <= 10) {
            return name + "," + director + "," + year + "," + rating;
        } else {
            return name + "," + director + "," + year + ",Unrated";
        }
    }

    @Override
    public boolean equals(String string) {
        return this.name.toLowerCase().equals(string.toLowerCase());
    }
}
