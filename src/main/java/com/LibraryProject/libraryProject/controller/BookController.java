package com.LibraryProject.libraryProject.controller;

import com.LibraryProject.libraryProject.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service; // Объявляем Service для работы с сущностью BookEntity
                                    // и Создаем конструктор
    private BookController (BookService service) {this.service = service};
}
