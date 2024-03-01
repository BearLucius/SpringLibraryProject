package com.LibraryProject.libraryProject.response;

import com.LibraryProject.libraryProject.entity.BookEntity;
import lombok.Data;

@Data
public class BookListResponse extends BaseResponse{

    public BookListResponse(boolean success, String message, Iterable<BookEntity> data) {
        super(success, message);
        this.data = data;
    }

    private Iterable<BookEntity>data;
}
