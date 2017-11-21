package com.matrix.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.matrix.common.MyBatisUtil;
import com.matrix.dao.BookDaoI;
import com.matrix.entity.Book;



public class BookImpl implements BookDaoI{

	public List<Book> getAllBook() {
		//获得会话对象
		 SqlSession session= MyBatisUtil.getSqlSession(true); 
	        try {          
	            BookDaoI bookDao = session.getMapper(BookDaoI.class);
	            return bookDao.getAllBook();
	        } finally {
	            session.close();
	        }

	}

}
