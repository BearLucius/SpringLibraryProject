package com.LibraryProject.libraryProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity // Сущность в таблице
@Data // Данные
@AllArgsConstructor //
@RequiredArgsConstructor
@Table(name = "Books") // Название таблицы

public class BookEntity {
     // Сделать переменную главным ключом (ну или в данном случае сделать id).
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    //^ ^ ^ указывает как будет генерироваться Id, в качестве параметра принимает параметр strategy
    //- который и задает способ генерации через получаемою стратегию


    //AuthorEntity

    // String - приколы
    private String namePublisher;
    private String cityPublisher;

    //BookEntity
    @Id
    // Long - приколы
    private long bookId;
    // String - приколы
    private String tittle;
    private String author;
    private String publishing;
    private String kind;
    // Int приколы
    private int year;

}
