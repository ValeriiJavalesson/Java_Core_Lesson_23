package Task_2_2;

import java.util.*;

public class Main {
    static String input = "";

    public static void main(String[] args) {
        List<Commodity> gifts = new ArrayList<>();
        gifts.add(new Commodity("Plate", 30, 30, 200));
        gifts.add(new Commodity("Pan", 42, 52, 880));
        gifts.add(new Commodity("Cup", 10, 20, 150));
        gifts.add(new Commodity("Fork", 20, 5, 40));
        gifts.add(new Commodity("Spoon", 25, 5, 40));
        gifts.add(new Commodity("Knife", 32, 12, 320));
        Scanner scan = new Scanner(System.in);

        while (true) {
            showMenu();
            input = scan.next();
            switch (input) {
                case "1" -> {
                    System.out.println("Введіть назву товару");
                    String name = scan.next();
                    System.out.println("Введіть довжину товару");
                    int length = scan.nextInt();
                    System.out.println("Введіть висоту товару");
                    int width = scan.nextInt();
                    System.out.println("Введіть вагу товару");
                    int weight = scan.nextInt();
                    gifts.add(new Commodity(name, length, width, weight));
                    System.out.println("Товар успішно додано!");
                    showCommodity(gifts);
                }
                case "2" -> {
                    System.out.println("Введіть назву товару, який потрібно видалити");
                    String name = scan.next();
                    if (isCommodityPresent(gifts, name)) {
                        gifts = gifts.stream()
                                .filter(commodity -> !commodity.getName().equalsIgnoreCase(name))
                                .toList();
                        System.out.println("Товар видалено!");
                        showCommodity(gifts);
                    } else System.out.println("Такого товару не існує!");
                }
                case "3" -> {
                    System.out.println("Введіть назву товару, який потрібно змінити");
                    String name = scan.next();
                    if (isCommodityPresent(gifts, name)){
                    gifts.stream()
                            .filter(commodity -> commodity.getName().equalsIgnoreCase(name))
                            .forEach(commodity -> {
                                System.out.println("Введіть нову назву товару" + "(" + "поточна "
                                        + commodity.getName() + ")");
                                commodity.setName(scan.next());
                                System.out.println("Введіть нову довжину товару" + "(" + "поточна "
                                        + commodity.getLength() + ")");
                                commodity.setLength(scan.nextInt());
                                System.out.println("Введіть нову висоту товару" + "(" + "поточна "
                                        + commodity.getWidth() + ")");
                                commodity.setWidth(scan.nextInt());
                                System.out.println("Введіть нову вагу товару" + "(" + "поточна "
                                        + commodity.getWeight() + ")");
                                commodity.setWeight(scan.nextInt());
                                System.out.println("Товар успішно замінено!");
                            });
                    showCommodity(gifts);}
                    else System.out.println("Такого товару не існує!");
                }
                case "4" -> {
                    System.out.println("Відсортовано за назвою:");
                    gifts = gifts.stream().sorted(Sorter.sortByName).toList();
                    showCommodity(gifts);
                }
                case "5" -> {
                    System.out.println("Відсортовано за довжиною:");
                    gifts = gifts.stream().sorted(Sorter.sortByLength).toList();
                    showCommodity(gifts);
                }
                case "6" -> {
                    System.out.println("Відсортовано за шириною:");
                    gifts = gifts.stream().sorted(Sorter.sortByWidth).toList();
                    showCommodity(gifts);
                }
                case "7" -> {
                    System.out.println("Відсортовано за вагою:");
                    gifts = gifts.stream().sorted(Sorter.sortByWeight).toList();
                    showCommodity(gifts);
                }
                case "8" -> {
                    System.out.println("Введіть номер товару");
                    int input = scan.nextInt();
                    if (input > gifts.size() || input <= 0) {
                        System.out.println("Товару з цим номером не знайдено!");
                    } else {
                        showOneCommodity(gifts.get(input - 1));
                    }
                }
                case "0" -> System.exit(0);
            }
        }
    }

    public static boolean isCommodityPresent(List<Commodity> list, String name) {
        return list.stream()
                .anyMatch(c -> c.getName().equalsIgnoreCase(name));
    }

    public static void showCommodity(List<Commodity> list) {
        System.out.print("Назва товару   Довжина   Ширина    Вага\n");
        System.out.print("------------   -------   ------    ----\n");
        list.forEach(c ->
                System.out.printf("%-10s %11d %8d %7d\n", c.getName(), c.getLength(), c.getWidth(), c.getWeight()));
    }

    public static void showOneCommodity(Commodity c) {
        System.out.print("Назва товару   Довжина   Ширина    Вага\n");
        System.out.print("------------   -------   ------    ----\n");
        System.out.printf("%-10s %11d %8d %7d\n", c.getName(), c.getLength(), c.getWidth(), c.getWeight());
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("1-Додати товар");
        System.out.println("2-Видалити товар");
        System.out.println("3-Замінити товар");
        System.out.println("4-Сортувати товари за назвою");
        System.out.println("5-Сортувати товари за довжиною");
        System.out.println("6-Сортувати товари за шириною");
        System.out.println("7-Сортувати товари за вагою");
        System.out.println("8-Вивести товар за номером");
        System.out.println("0-Exit");
    }
}