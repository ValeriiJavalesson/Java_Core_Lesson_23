package Task_1;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        VerkhovnaRada verkhovnaRada = VerkhovnaRada.getInstance();
        verkhovnaRada.addFaction("Слово");
        verkhovnaRada.addFaction("Вітер");
        verkhovnaRada.addFaction("Вогонь");

        verkhovnaRada.addDeputyToFaction("Слово", new Deputy(90, 188, "Олег", "Зарічний", 55, false));
        verkhovnaRada.addDeputyToFaction("Слово", new Deputy(102, 174, "Віталій", "Яровий", 35, false));
        verkhovnaRada.addDeputyToFaction("Вітер", new Deputy(82, 181, "Андрій", "Коваль", 31, true));
        verkhovnaRada.addDeputyToFaction("Слово", new Deputy(77, 191, "Олександр", "Нечипора", 40, true));
        verkhovnaRada.addDeputyToFaction("Вогонь", new Deputy(82, 181, "Віталій", "Ганжа", 35, true));
        verkhovnaRada.addDeputyToFaction("Слово", new Deputy(83, 187, "Валерій", "Приходько", 47, true));
        verkhovnaRada.addDeputyToFaction("Вогонь", new Deputy(80, 180, "Іван", "Залізний", 40, true));

        while (true) {
            menu();
            input = scan.next().toLowerCase();
            if (input.equals("0"))
                break;
            switch (input) {
                case "1" -> {
                    System.out.println("Введіть назву фракції");
                    verkhovnaRada.addFaction(scan.next());
                }
                case "2" -> {
                    System.out.println("Введіть назву фракції, яку треба видалити");
                    String inputString = scan.next();
                    if (!verkhovnaRada.isFactionPresent(inputString)) {
                        System.out.println("Такої фракції не існує!");
                        break;
                    }
                    verkhovnaRada.removeFaction(inputString);
                    System.out.println("фракцію " + inputString + " видалено!");
                }
                case "3" -> {
                    System.out.println("Список всих фракцій");
                    verkhovnaRada.showAllFaction();
                }
                case "4" -> {
                    System.out.println("Введіть назву фракції, яку треба очистити");
                    String inputString = scan.next();
                    if (!verkhovnaRada.isFactionPresent(inputString)) {
                        System.out.println("Такої фракції не існує");
                        break;
                    }
                    verkhovnaRada.clearFaction(inputString);
                    System.out.println("Фракцію " + inputString + " очищено!");
                }
                case "5" -> {
                    System.out.println("Введіть назву фракції, щоб вивести список її депутатів");
                    String inputString = scan.next();
                    if (!verkhovnaRada.isFactionPresent(inputString)) {
                        System.out.println("Такої фракції не існує!");
                        break;
                    }
                    verkhovnaRada.showDeputiesFromFaction(inputString);
                }
                case "6" -> {
                    System.out.println("Введіть назву фракції, до якої треба додати депутата");
                    String nameFaction = scan.next();
                    if (!verkhovnaRada.isFactionPresent(nameFaction)) {
                        System.out.println("Такої фракції не існує");
                        break;
                    }
                    System.out.println("Введіть ім’я депутата");
                    String firstName = scan.next();
                    System.out.println("Введіть прізвище депутата");
                    String lastName = scan.next();
                    System.out.println("Введіть вагу депутата");
                    int weight = scan.nextInt();
                    System.out.println("Введіть зріст депутата");
                    int height = scan.nextInt();
                    System.out.println("Введіть вік депутата");
                    int age = scan.nextInt();
                    System.out.println("Депутат хабарник?(так/ні)");
                    boolean b = scan.next().equalsIgnoreCase("так");
                    verkhovnaRada.addDeputyToFaction(nameFaction, new Deputy(weight, height, firstName, lastName, age, b));
                    System.out.println("Депутата додано");
                }
                case "7" -> {
                    System.out.println("Введіть прізвище депутата, якого потрібно видалити");
                    verkhovnaRada.removeDeputy(scan.next());
                }
                case "8" -> {
                    System.out.println("Список всих хабарників у раді:");
                    verkhovnaRada.showAllBribetakers();
                }
                case "9" -> {
                    System.out.println("Найбільший хабарик у раді:");
                    verkhovnaRada.showMostBribetaker();
                }
                case "10" -> {
                    verkhovnaRada.giveBribe("Зарічний", 2000);
                    verkhovnaRada.giveBribe("Приходько", 8000);
                    verkhovnaRada.giveBribe("Нечипора", 1510);
                    verkhovnaRada.giveBribe("Нечипора", 3000);
                    verkhovnaRada.giveBribe("Ганжа", 4500);
                    verkhovnaRada.giveBribe("Яровий", 4000);
                    verkhovnaRada.giveBribe("Залізний", 5100);
                    System.out.println("Хабарі роздано!");
                }
            }
        }
    }

    private static void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Введіть номер операції з наведених нижче:");
        System.out.println("1 - Щоб додати фракцію");
        System.out.println("2 - Щоб видалити конкретну фракцію");
        System.out.println("3 - Щоб вивести усі фракції");
        System.out.println("4 - Щоб очистити конкретну фракцію");
        System.out.println("5 - Щоб вивести конкретну фракцію");
        System.out.println("6 - Щоб додати депутата до фракції");
        System.out.println("7 - Щоб видалити депутата з фракції");
        System.out.println("8 - Щоб вивести список всих хабарників у раді");
        System.out.println("9 - Щоб вивести найбільшого хабарника у раді");
        System.out.println("10 - Щоб роздати хабарі");
        System.out.println("0 - Щоб закінчити роботу з програмою");
    }

}
