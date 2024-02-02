package com.LibraryProject.libraryProject.service;

import com.LibraryProject.libraryProject.entity.BookEntity;
import com.LibraryProject.libraryProject.repo.bookRepo; //Импорт интерфейса
public class BookService {
    private final bookRepo repo;

    public BookService(bookRepo repo) {
        this.repo = repo;
    }

    public void save(BookEntity book){repo.save(book);} //Сохрание
    public  void delete (Long id) {repo.deleteById(id);} //Удалние по Id
    public Iterable<BookEntity> getAll(){return repo.findAll();} // Получить всё/Найти всё
}

//        По умолчанию CrudRepository реализует методы
//
//        save() - сохранить объект в DB
//        delete() - удалить объект из DB
//        getAll() - получить все объекты из DB
//        updata() - обновить объект в DB
//          НО кто запрещал писать свои?)))