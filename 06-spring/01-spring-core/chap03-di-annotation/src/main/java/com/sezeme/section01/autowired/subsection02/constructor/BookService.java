package com.sezeme.section01.autowired.subsection02.constructor;

import com.sezeme.section01.autowired.common.BookDAO;
import com.sezeme.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* component scan을 통해 bean 등록, bookServiceConstructor 가 bean name */
@Service("bookServiceConstructor")
public class BookService {

    private BookDAO bookDAO;

    public BookService(){}

    @Autowired // 생성자 주입
    /* Spring 4.3 버전 이후부터 생성자가 1개 뿐이라면 어노테이션을 생략해도
    * 자동으로 생성자 주입이 동작한다. 단, 생성자가 1개 이상이라면 명시적으로 작성해야 한다.
    * */
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
