package ru.skillbox;

public class Book {

    private final String name;
    private final String author;
    private final int numberOfPages;
    private final int ISBN;

    public Book(String name, String author, int numberOfPages, int ISBN) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getISBN() {
        return ISBN;
    }
}
