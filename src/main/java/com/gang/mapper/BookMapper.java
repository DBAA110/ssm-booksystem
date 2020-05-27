package com.gang.mapper;
import com.gang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(int id);

    //统计所有书籍的数量
    int countAllBooks();
    //查找所有书
    List<Books> queryAllBooks(@Param(value = "curPage")int curPage,
                              @Param(value = "pageSize")int pageSize);
    //通过名字查找书籍
    List<Books> queryBooksByName(@Param(value = "bookName")String bookName,
                                 @Param(value = "curPage")int curPage,
                                 @Param(value = "pageSize")int pageSize);
    //统计符合条件的书籍数量
    int countBooksByName(@Param(value = "bookName")String bookName);

}
//package com.gang.mapper;
//import com.gang.pojo.Books;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//public interface BookMapper {
//    //增加一本书
//    int addBook(Books books);
//    //删除一本书
//    int deleteBookById(int id);
//    //更新一本书
//    int updateBook(Books books);
//    //查找一本书
//    Books queryBook(int id);
//    //统计所有书籍的数量
//    int countAllBooks();
//    //查找所有书
//    List<Books> queryAllBooks(@Param(value = "curPage")int curPage,
//                              @Param(value = "pageSize")int pageSize);
//    //通过名字查找书籍
//    List<Books> queryBooksByName(@Param(value = "bookName")String bookName,
//                                 @Param(value = "curPage")int curPage,
//                                 @Param(value = "pageSize")int pageSize);
//    //统计符合条件的书籍数量
//    int countBooksByName(@Param(value = "bookName")String bookName);
//
//    //查找所有书
//    List<Books> queryAllBook();
//}
