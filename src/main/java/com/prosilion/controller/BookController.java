package com.prosilion.controller;

import com.prosilion.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
  private final BookRepository bookRepository;

  @Autowired
  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @GetMapping("/books")
  public String books(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "jsp/books";
  }
}