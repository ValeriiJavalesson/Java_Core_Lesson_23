package Task_2_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> library = new ArrayList<Book>();
        library.add(new Book(312, "Mathematics"));
        library.add(new Book(122, "History"));
        library.add(new Book(163, "Geography"));
        library.add(new Book(92, "Music"));
        library.add(new Book(33, "Biology"));
        library.add(new Book(31, "Biology"));
        library.add(new Book(32, "Biology"));
        library.add(new Book(55, "Physics"));

        System.out.println("Список до сортування:");
        System.out.println();
        library.forEach(b ->
                System.out.println(b.getBookName() + " " + b.getNumberOfPages()));
        System.out.println();

        library = library.stream()
                .sorted(new CompareByPages().reversed())
                .toList();
        System.out.println("Список після сортування за кількістю сторінок за допомогою Comparator:");
        System.out.println();
        for (Book b : library) {
            System.out.println(b.getBookName() + " " + b.getNumberOfPages());
        }
        System.out.println();

        library = library.stream().sorted()
                .toList();
        System.out.println("Список після сортування за назвою та кількістю сторінок за допомогою Comparable:");
        System.out.println();
        for (Book b : library) {
            System.out.println(b.getBookName() + " " + b.getNumberOfPages());
        }
        System.out.println();
    }
}
