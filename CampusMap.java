import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House(true, "Chase", "41 Elm street", 4));
        myMap.addBuilding(new Library("Hillyer", "2 Chapin way", 4, true));
        myMap.addBuilding(new Library("Neilson", "7 Neilson Drive", 4, true));
        myMap.addBuilding(new Cafe(400, 400, 400, 400, "Campus Cafe", "1 Chapin way", 3));
        myMap.addBuilding(new Cafe(200, 200, 200, 200, "Compass Cafe", "6 Neilson Drive", 1));
        myMap.addBuilding(new Building("Ceramics studio", "81 Green Street", 1));
        myMap.addBuilding(new House(true, "Lamount", "5 Chapin way", 5));
        myMap.addBuilding(new Building("Burton Hall", "8 Chapin Way", 4));
        myMap.addBuilding(new House(true, "Chapin", "3 Chapin Way", 5));
        myMap.addBuilding(new Building("Campus Center", "1 Chapin Way", 4));
        System.out.println(myMap);
    }
    
}
