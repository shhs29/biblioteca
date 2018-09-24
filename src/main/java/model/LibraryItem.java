package model;

public interface LibraryItem {
    String getName();

    String toString();

    boolean equals(String string);

    ItemType getType();
}
