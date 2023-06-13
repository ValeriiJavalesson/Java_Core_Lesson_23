package Task_2_1;

import java.util.Comparator;

public class CompareByPages implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {

        return o1.getNumberOfPages() - o2.getNumberOfPages();

    }

}