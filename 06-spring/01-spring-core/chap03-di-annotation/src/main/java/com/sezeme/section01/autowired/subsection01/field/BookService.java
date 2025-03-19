package com.sezeme.section01.autowired.subsection01.field;

import com.sezeme.section01.autowired.common.BookDAO;
import com.sezeme.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* component scan을 통해 bean 등록, bookServiceField 가 bean name */
@Service("bookServiceField")
public class BookService {

    // BookDAO 타입의 bean 객체를 이 프로퍼티에 자동으로 추가한다.
    @Autowired  // 필드 주입
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }
}
