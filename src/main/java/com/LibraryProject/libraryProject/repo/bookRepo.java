package com.LibraryProject.libraryProject.repo;


import org.springframework.data.repository.CrudRepository;
import com.LibraryProject.libraryProject.entity.BookEntity;
public interface bookRepo extends CrudRepository<BookEntity, Long>{
}
