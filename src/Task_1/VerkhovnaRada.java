package Task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerkhovnaRada {
    private List<Faction> factions = new ArrayList<>();
    private static final VerkhovnaRada INSTANCE = new VerkhovnaRada();

    private VerkhovnaRada() {
    }

    public static VerkhovnaRada getInstance() {
        List<Faction> factions = new ArrayList<>();
        return INSTANCE;
    }

    public void addFaction(String name) {
        if (!isFactionPresent(name)) {
            factions.add(new Faction(name));
            System.out.println("Фракцію " + name + " додано");
        } else System.out.println("Фракція з цією назвою вже зареєстрована в раді.");

    }

    public void removeFaction(String name) {
        factions = factions.stream()
                .filter(faction -> !faction.getFactionName().equalsIgnoreCase(name))
                .toList();
    }

    public void addDeputyToFaction(String factionName, Deputy deputy) {
        factions.stream()
                .filter(faction -> faction.getFactionName().equalsIgnoreCase(factionName))
                .forEach(faction -> faction.addDeputy(deputy));
    }

    public boolean isFactionPresent(String factionName) {
        return factions.stream()
                .anyMatch(faction -> faction.getFactionName().equalsIgnoreCase(factionName));
    }

    public void showAllFaction() {
        factions.forEach(faction -> System.out.println(faction.getFactionName()));
    }

    public void showDeputiesFromFaction(String factionName) {
        factions.stream()
                .filter(faction -> faction.getFactionName().equalsIgnoreCase(factionName))
                .forEach(Faction::showAllDeputiesFromFaction);
    }

    public void removeDeputy(String name) {
        boolean isDeputyWasPresent = false;
        for (Faction f : factions) {
            if (f.isDeputyPresent(name)) {
                isDeputyWasPresent = true;
                break;
            }
        }
        if (isDeputyWasPresent)
            factions.forEach(f -> f.removeDeputy(name));
        System.out.println("Депутат " + name + " видалений.");

    }

    public void clearFaction(String factionName) {
        factions.stream()
                .filter(faction -> faction.getFactionName().equalsIgnoreCase(factionName))
                .forEach(Faction::clearFaction);
    }

    public void giveBribe(String deputyName, int value) {
            List<Deputy> allDeputies = factions.stream()
                    .collect(ArrayList::new, (deputies, faction) -> deputies.addAll(faction.getDeputyList()), (deputies, deputies2) -> deputies.addAll(deputies2));
            allDeputies.stream()
                    .filter(deputy -> deputy.getLastName().equalsIgnoreCase(deputyName))
                    .forEach(deputy -> deputy.giveBribe(value));
    }

    public void showAllBribetakers() {
        factions.forEach(Faction::showBribetakersFromFaction);
    }

    public void showMostBribetaker() {
        List<Deputy> allDeputies = factions.stream()
                .collect(ArrayList::new, (deputies, faction) -> deputies.addAll(faction.getDeputyList()), (deputies, deputies2) -> deputies.addAll(deputies2));
        allDeputies.stream()
                .sorted(Comparator.comparingInt(Deputy::getBribeValue).reversed())
                .limit(1).forEach(deputy -> {
                    System.out.print(deputy);
                    System.out.println(" Розмір хабаря: " + deputy.getBribeValue());
                });

    }
}
