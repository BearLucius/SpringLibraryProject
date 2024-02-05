package com.LibraryProject.libraryProject.controller;

import com.LibraryProject.libraryProject.entity.BookEntity;
import com.LibraryProject.libraryProject.response.BaseResponse;
import com.LibraryProject.libraryProject.response.BookListResponse;
import com.LibraryProject.libraryProject.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service; // Объявляем Service для работы с сущностью BookEntity
                                    // и Создаем конструктор
    private BookController (BookService service) { this.service = service; }
    @GetMapping("/all") // Получение данных о всех книгах
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @PostMapping("/up   date")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"В книгу внесены изменения!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
    @PostMapping("/add") // Добавление Книги в базу данных
    public ResponseEntity<BaseResponse> registration(@RequestBody BookEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"Книгда добавлена!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
}
