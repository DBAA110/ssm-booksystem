package com.gang.controller;

import com.gang.dto.PaginationDTO;
import com.gang.pojo.Books;
import com.gang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model,
                       @RequestParam(name="curPage",defaultValue = "1") Integer curPage,
                       @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize){
        PaginationDTO paginationDTO = bookService.queryAllBooks(curPage,pageSize);
        model.addAttribute("list",paginationDTO);
        /*model.addAttribute("books",paginationDTO.getData());*/
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper() {

        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBookByName(@RequestParam(name = "bookName",required = false)String bookName,
                                  @RequestParam(name="curPage",defaultValue = "1") Integer curPage,
                                  @RequestParam(name = "pageSize",defaultValue = "5")Integer pageSize,
                                  Model model){
        int count = bookService.countBooksByName(bookName);
        if (count == 0){
            model.addAttribute("error","未查到相关书籍");
            model.addAttribute("list",null);
            return "allBook";
        }
        PaginationDTO paginationDTO = bookService.queryBooksByName(bookName, curPage, pageSize);
        model.addAttribute("bookName",bookName);
        model.addAttribute("list",paginationDTO);
        return "allBook";
    }
}

