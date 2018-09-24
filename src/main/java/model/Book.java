package model;

//represents a book
public class Book implements LibraryItem{
    private final String title;
    private final String author;
    private final String yearOfPublishing;
    private final ItemType itemType;

    public Book(String title, String author, String yearOfPublishing) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.itemType = ItemType.BOOK;
    }

    @Override
    public ItemType getType(){
        return this.itemType;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + yearOfPublishing;
    }

    @Override
    public boolean equals(String string) {
        return this.title.equals(string);
    }
}
