package com.matrix.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matrix.entity.Book;
import com.matrix.service.BookService;




@Controller

public class BookController {

    @Resource
    BookService bookService;

    @RequestMapping("/book")
    public String getAllBook(Model model) {
        List<Book> books = bookService.getAllBook();
        for (Book book : books) {
            System.out.println(book.getBookName());
        }
        
        model.addAttribute("books", books);
        return "Book/index";
    }
    
    @RequestMapping("/test")
    public String test(ModelMap model) {
    	model.addAttribute("info", "#login");
        model.addAttribute("uname", "登录");
		return "register";
	}
   
}