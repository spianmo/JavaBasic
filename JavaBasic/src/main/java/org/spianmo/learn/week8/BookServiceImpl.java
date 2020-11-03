package org.spianmo.learn.week8;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author Finger
 * @Date 11/2/2020
 **/
public class BookServiceImpl implements IBookService {

    private static final ArrayList<String> PROHIBITED_WORDS = new ArrayList<String>() {
        {
            add("暴力");
            add("恐怖");
        }
    };

    @Override
    public boolean isPutOnTheShelf(Book book) throws NonStandardISBNException, ExpensiveBookException, IllegalBookNameException {
        if (!book.getIsbn().matches("^[0-9]{13}$")) {
            throw new NonStandardISBNException("不是13位数字");
        }
        if (book.getPrice().compareTo(new BigDecimal(100)) > 0) {
            throw new ExpensiveBookException("价格大于100元");
        }
        if (isContainsProhibitedWords(book.getName())) {
            throw new IllegalBookNameException("书名含非法字符");
        }
        return true;
    }

    public boolean isContainsProhibitedWords(String input) {
        for (String str : PROHIBITED_WORDS) {
            if (input.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
