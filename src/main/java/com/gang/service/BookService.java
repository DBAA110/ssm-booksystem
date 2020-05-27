
package com.gang.service;

import com.gang.dto.PaginationDTO;
import com.gang.pojo.Books;

import java.util.List;

//BookService:底下需要去实现,调用dao层
public interface BookService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查找一本书
    Books queryBookById(int id);
    //查找所有书
    PaginationDTO queryAllBooks(Integer curPage, Integer pageSize);
    //通过名字查找书籍
    PaginationDTO queryBooksByName(String bookName,Integer curPage, Integer pageSize);
    //统计符合条件的书籍数量
    int countBooksByName(String bookName);
    //统计所有书籍的数量
    int countAllBooks();
}


//package com.gang.service;
//
//import com.gang.dto.PaginationDTO;
//import com.gang.pojo.Books;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//
//public interface BookService {
//    //增加一本书
//    int addBook(Books books);
//    //删除一本书
//    int deleteBookById(int id);
//    //更新一本书
//    int updateBook(Books books);
//    //查找一本书
//    Books queryBook(int id);
//    //查找所有书
//    PaginationDTO queryAllBooks(Integer curPage, Integer pageSize);
//    //通过名字查找书籍
//    PaginationDTO queryBooksByName(String bookName,Integer curPage, Integer pageSize);
//    //统计符合条件的书籍数量
//    int countBooksByName(String bookName);
//
//    //查找所有书
//    List<Books> queryAllBook();
//}
