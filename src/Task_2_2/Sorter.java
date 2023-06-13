package Task_2_2;

import java.util.Comparator;

public class Sorter {
    public static Comparator<Commodity> sortByName = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity o1, Commodity o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };
    public static Comparator<Commodity> sortByLength = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (o1.getLength() - (o2.getLength()) == 0)
                return o1.getName().compareToIgnoreCase(o2.getName());
            return o1.getLength() - (o2.getLength());
        }
    };
    public static Comparator<Commodity> sortByWidth = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (o1.getWidth() - (o2.getWidth()) == 0)
                return o1.getName().compareToIgnoreCase(o2.getName());
            return o1.getWidth() - (o2.getWidth());
        }
    };
    public static Comparator<Commodity> sortByWeight = new Comparator<Commodity>() {
        @Override
        public int compare(Commodity o1, Commodity o2) {
            if (o1.getWeight() - (o2.getWeight()) == 0)
                return o1.getName().compareToIgnoreCase(o2.getName());
            return o1.getWeight() - (o2.getWeight());
        }
    };
}