package org.spianmo.learn.week8;

/**
 * @ClassName IBookService
 * @Description TODO
 * @Author Finger
 * @Date 11/2/2020
 **/
public interface IBookService {
    boolean isPutOnTheShelf(Book book) throws NonStandardISBNException, ExpensiveBookException, IllegalBookNameException;
}
