package Task_1;

import java.util.ArrayList;
import java.util.List;

public class Faction {
    private List<Deputy> deputyList;
    private String factionName;

    Faction(String name) {
        factionName = name;
        deputyList = new ArrayList<Deputy>();
    }

    public void addDeputy(Deputy deputy) {
        deputyList.add(deputy);
    }

    public List<Deputy> getDeputyList() {
        return deputyList;
    }

    public void showAllDeputiesFromFaction(){
        deputyList.forEach(System.out::println);
    }

    public boolean isDeputyPresent(String name){
        return deputyList.stream()
                .anyMatch(d->d.getLastName().equalsIgnoreCase(name));
    }

    public String getFactionName() {
        return factionName;
    }

    public void removeDeputy(String name){
        deputyList = deputyList.stream()
                .filter(d->!d.getLastName().equalsIgnoreCase(name))
                .toList();
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public void clearFaction() {
        while (deputyList.size() > 0) {
            deputyList.remove(0);
        }
    }

    public void showBribetakersFromFaction(){
        deputyList.stream()
                .filter(Deputy::isBribetaker)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Фракція " + factionName ;
    }


}
