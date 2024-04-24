package org.example.SpringHomework7.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

//класс книга - модель
@Data
@AllArgsConstructor
public class Book {
    private String name;
    private String author;
    private double price;
    private int shelfNumber;
}
