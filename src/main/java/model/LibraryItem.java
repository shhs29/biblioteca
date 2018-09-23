package model;

public interface LibraryItem {
    String getName();

    String toString();

    boolean equals(Object o);

    ItemType getType();
}
