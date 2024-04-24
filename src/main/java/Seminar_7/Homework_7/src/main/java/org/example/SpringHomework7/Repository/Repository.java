package org.example.SpringHomework7.Repository;

import lombok.Getter;
import org.example.SpringHomework7.Model.Book;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
@Getter
public class Repository {
    //базу данных храним просто в списке в оперативной памяти
    List<Book> promoBooks = List.of(new Book("Макбет", "Уильям Шекспир", 45.2, 1),
            new Book("Белый Клык", "Джек Лондон", 60.3, 2),
            new Book("Джейн Эйр", "Шарлотта Бронте", 75.4, 3),
            new Book("Война и мир", "Лев Толстой", 80.1, 4));
    List<Book> books = new ArrayList<>(promoBooks);

    //метод добавления новой книги в магазин
    public void addBook(Book book) {
        books.add(book);
    }

    //метод получения книги по названию
    public Book getBook(String name) {
        return books.stream().filter(it -> it.getName().equals(name)).toList().getFirst();
    }

    //метод продажи книги
    public void sellBook(String name) {
        books.removeIf(it -> it.getName().equals(name));
    }
}
