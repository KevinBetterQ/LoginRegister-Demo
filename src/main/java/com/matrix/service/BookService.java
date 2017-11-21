package com.matrix.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.matrix.dao.BookDaoI;
import com.matrix.entity.Book;



@Service
public class BookService {
	@Resource
	BookDaoI bookDaoI;
	public List<Book> getAllBook() {
		return bookDaoI.getAllBook();
	}
}
