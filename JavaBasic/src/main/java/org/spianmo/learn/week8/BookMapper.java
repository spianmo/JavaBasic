package org.spianmo.learn.week8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName BookMapper
 * @Description TODO
 * @Author Finger
 * @Date 11/2/2020
 **/
public class BookMapper {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book("老人与海", new BigDecimal("20.98"), "3214567899875"),
                new Book("C++Primer", new BigDecimal("180.18"), "5214567899875"),
                new Book("恐怖主义", new BigDecimal("10.18"), "5114567899875"),
                new Book("FAKE BOOK", new BigDecimal("20.18"), "511114567899875"),
                new Book("Java程序设计基础", new BigDecimal("60.00"), "1214447899875")};
        IBookService bookService = new BookServiceImpl();

        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            try {
                bookService.isPutOnTheShelf(book);
            } catch (ExpensiveBookException | IllegalBookNameException | NonStandardISBNException e) {
                System.err.println(book.getName()+" 上架失败！原因："+e.showMsg());
                continue;
            }
            list.add(book);
            System.out.println(book.getName()+" 上架成功！");
        }

        System.out.println("=========>处理结果数据集为:"+ Arrays.toString(list.toArray(new Book[0])));
    }
}
