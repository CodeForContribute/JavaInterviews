package DesignPatterns;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Book{
    private final int price;
    private final String bookName;

    public Book(int price, String bookName) {
        this.price = price;
        this.bookName = bookName;
    }
    public int getPrice() {
        return price;
    }

    public String getBookName() {
        return bookName;
    }
}

interface Aggregate<E>{
    Iterator<E> createIterator();
}

class Library<E> implements Aggregate<E>{
    private final List<E>bookList;

    public Library(List<E> bookList) {
        this.bookList = bookList;
    }

    @Override
    public Iterator<E> createIterator() {
        return new BookIterator<E>(bookList);
    }
}

class BookIterator<E> implements Iterator<E>{
    private final List<E>bookList;
    private int index = 0;

    public BookIterator(List<E>bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean hasNext() {
        return index < bookList.size();
    }

    @Override
    public E next() {
        if (this.hasNext()){
            return this.bookList.get(index++);
        }
        return null;
    }
}
public class IteratorDesignPatternDemo {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book(100, "science"),
                new Book(200, "math"),
                new Book(100, "english"),
                new Book(600, "physics"),
                new Book(300, "chemistry"),
                new Book(900, "rocket science")
        );
        Library<Book> library = new Library<>(bookList);
        Iterator<Book> iterator = library.createIterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getBookName());
        }
    }
}
