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
    private final BookService service;//обьявляем сервис для работы с сущностью BookEntity и создаем конструктор
    private BookController(BookService service){this.service=service;}

    @GetMapping("/all")

    public ResponseEntity<BookListResponse> getAll(){

        return  ResponseEntity.ok(new BookListResponse(true,"Список книг",service.getAll()));}
    @PostMapping("/add") // Добавить книку в баззу
    public ResponseEntity<BaseResponse>registration(@RequestBody BookEntity data){
        try{
            if (data.getId()!=null)
                throw new RuntimeException("изменеиня не внесеныыы");
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"Книга добавлена"));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }

    @PostMapping("/update") // Добавить книку в баззу
    public ResponseEntity<BaseResponse>update(@RequestBody BookEntity data){
        try{
            if (data.getId()==null)
                throw new    RuntimeException("изменеиня не внесены");
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"Книга добавлена"));

        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }

    @DeleteMapping ("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestBody BookEntity data){
        try{
            if (data.getId()==null)
                throw new RuntimeException("Такой книги нет, удаление не возможно ￣へ￣");

            service.delete(data.getId());
            return ResponseEntity.ok(new BaseResponse(true,"Книга удалёна"));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }
}
