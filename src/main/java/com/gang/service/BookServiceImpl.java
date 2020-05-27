package com.gang.service;

import com.gang.dto.PaginationDTO;
import com.gang.mapper.BookMapper;
import com.gang.pojo.Books;
import java.util.List;

public class BookServiceImpl implements BookService {

    //1.首先要去创建对应的mapper层的BookMapper
    private BookMapper bookMapper;
    //一定要记得写set方法，不然Spring IOC容器无法管理
    public void setBookMapper(BookMapper bookMapper) {

        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books books) {

        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {

        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }


    @Override
    public PaginationDTO queryAllBooks(Integer curPage, Integer pageSize) {
        PaginationDTO<Object> paginationDTO = new PaginationDTO<>();
        Integer totalPage;
        Integer totalCount = bookMapper.countAllBooks(); //得到书籍总数
        if(totalCount % pageSize == 0){
            totalPage = totalCount / pageSize;
        }else {
            totalPage = totalCount / pageSize + 1;
        }
        if (curPage < 1){
            curPage = 1;
        }
        if (curPage > totalPage){
            curPage = totalPage;
        }

        paginationDTO.setPagination(totalPage,curPage);
        Integer offset = pageSize * (curPage - 1);

        List<Books> books = bookMapper.queryAllBooks(offset, pageSize);
        paginationDTO.setData(books);

        return paginationDTO;
    }

    @Override
    public PaginationDTO queryBooksByName(String bookName, Integer curPage, Integer pageSize) {
        PaginationDTO<Object> paginationDTO = new PaginationDTO<>();
        Integer totalPage;
        Integer totalCount = bookMapper.countBooksByName(bookName);
        if (totalCount.equals(0)) {
            return paginationDTO;
        }
        if(totalCount % pageSize == 0){
            totalPage = totalCount / pageSize;
        }else {
            totalPage = totalCount / pageSize + 1;
        }
        if (curPage < 1){
            curPage = 1;
        }
        if (curPage > totalPage){
            curPage = totalPage;
        }

        paginationDTO.setPagination(totalPage,curPage);
        Integer offset = pageSize * (curPage - 1);

        List<Books> books = bookMapper.queryBooksByName(bookName,offset,pageSize);
        paginationDTO.setData(books);

        return paginationDTO;

    }

    @Override
    public int countBooksByName(String bookName) {
        return bookMapper.countBooksByName(bookName);
    }

    @Override
    public int countAllBooks() {
        return bookMapper.countAllBooks();
    }
}


//package com.gang.service;
//
//import com.gang.dto.PaginationDTO;
//import com.gang.mapper.BookMapper;
//import com.gang.pojo.Books;
//
//import java.util.List;
//
//public class BookServiceImpl implements BookService {
//    //1.首先要去创建对应的mapper层的BookMapper
//    private BookMapper bookMapper;
//    //一定要记得写set方法，不然Spring IOC容器无法管理
//    public void setBookMapper(BookMapper bookMapper) {
//
//        this.bookMapper = bookMapper;
//    }
//
//    @Override
//    public int addBook(Books books) {
//
//        return bookMapper.addBook(books);
//    }
//
//    @Override
//    public int deleteBookById(int id) {
//
//        return bookMapper.deleteBookById(id);
//    }
//
//    @Override
//    public int updateBook(Books books) {
//        return bookMapper.updateBook(books);
//    }
//
//    @Override
//    public Books queryBook(int id) {
//
//        return bookMapper.queryBook(id);
//    }
//
//    @Override
//    public PaginationDTO queryAllBooks(Integer curPage, Integer pageSize) {
//        PaginationDTO<Object> paginationDTO = new PaginationDTO<>();
//        Integer totalPage;
//        Integer totalCount = bookMapper.countAllBooks(); //得到书籍总数
//        if(totalCount % pageSize == 0){
//            totalPage = totalCount / pageSize;
//        }else {
//            totalPage = totalCount / pageSize + 1;
//        }
//        if (curPage < 1){
//            curPage = 1;
//        }
//        if (curPage > totalPage){
//            curPage = totalPage;
//        }
//
//        paginationDTO.setPagination(totalPage,curPage);
//        Integer offset = pageSize * (curPage - 1);
//
//        List<Books> books = bookMapper.queryAllBooks(offset, pageSize);
//        paginationDTO.setData(books);
//
//        return paginationDTO;
//    }
//
//    @Override
//    public PaginationDTO queryBooksByName(String bookName, Integer curPage, Integer pageSize) {
//        PaginationDTO<Object> paginationDTO = new PaginationDTO<>();
//        Integer totalPage;
//        Integer totalCount = bookMapper.countBooksByName(bookName);
//        if (totalCount.equals(0)) {
//            return paginationDTO;
//        }
//        if(totalCount % pageSize == 0){
//            totalPage = totalCount / pageSize;
//        }else {
//            totalPage = totalCount / pageSize + 1;
//        }
//        if (curPage < 1){
//            curPage = 1;
//        }
//        if (curPage > totalPage){
//            curPage = totalPage;
//        }
//
//        paginationDTO.setPagination(totalPage,curPage);
//        Integer offset = pageSize * (curPage - 1);
//
//        List<Books> books = bookMapper.queryBooksByName(bookName,offset,pageSize);
//        paginationDTO.setData(books);
//
//        return paginationDTO;
//
//    }
//
//    @Override
//    public int countBooksByName(String bookName) {
//
//        return bookMapper.countBooksByName(bookName);
//    }
//
//    @Override
//    public List<Books> queryAllBook() {
//        return bookMapper.queryAllBook();
//    }
//}
