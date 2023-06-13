package Task_2_1;

public class Book implements Comparable<Book>{
    private int numberOfPages;
    private String bookName;

    Book(int numberOfPages, String bookName){
        this.numberOfPages = numberOfPages;
        this.bookName = bookName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public int compareTo(Book o) {
        if (this.getBookName().compareTo(o.getBookName())==0)
            return this.getNumberOfPages() - o.getNumberOfPages();
        else
            return this.getBookName().compareTo(o.getBookName());
    }
}
