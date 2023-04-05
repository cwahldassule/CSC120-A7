/* This is a stub for the House class */
import java.util.ArrayList;
import java.util.Arrays;
/**
 * creates a house
 */
public class House extends Building{
  private ArrayList<String> residents;
  private boolean hasDiningRoom = false;
  private boolean hasElevator = false;

  /**
   * initializes a house
   * @param residents array list of residents
   * @param hasDiningRoom says if it has a dining room
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors
   */
    public House(ArrayList<String> residents, boolean hasDiningRoom, String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.residents = residents;
        this.hasDiningRoom = hasDiningRoom;
        this.hasElevator = hasElevator;
        System.out.println("You have built a house: 🏠");
    }

    /**
     * constructor for house
     * @param hasDiningRoom t/f for has a dining hall
     * @param name name of house
     * @param address adress of house
     * @param nFloors number of floors
     */
    public House(boolean hasDiningRoom, String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.hasDiningRoom = hasDiningRoom;
        this.residents = new ArrayList<>();
        System.out.println("You have built a house: 🏠");
    }

    /**
     * constructor for house
     * @param name name of house
     * @param address adress of house
     * @param nFloors number of floors
     */
    public House(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.residents = new ArrayList<>();
        System.out.println("You have built a house: 🏠");}
  /**
   * accessor for hasDiningRoom
   * @return bool for hasDiningRoom
   */
    public boolean hasDiningRoom(){
        return this.hasDiningRoom;
    }

  /**
   * accessor-like for number of residents
   * @return the number of residents
   */
    public int nResidents(){
        return residents.size();
    }
    
 /**
 * does the house have an elevator
 * @return true or false
 */
    public boolean hasElevator(){
        return this.hasElevator;
    }
  /**
   * adds someone to residents list
   * @param name who is moving in
   */
    public void moveIn(String name){
        if(!this.residents.contains(name)){
            residents.add(name);}
        else{
            throw new RuntimeException("This resident has already moved in :0");}
    }

  /**
     * changes which floor someone is on
     */
    public void goToFloor(int floorNum) {
        if(this.hasElevator){
            if (this.activeFloor == -1) {
                throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
            }
            if (floorNum < 1 || floorNum > this.nFloors) {
                throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
            }
            System.out.println("You are now on floor #" + floorNum + " of " + this.name);
            this.activeFloor = floorNum;
            }
        else{
            throw new RuntimeException("This building does not have an elevator...you have to walk :0");
        }
        }
        

  /**
   * removes someone from residents list
   * @param name who is moving out
   * @return their name
   */
    public String moveOut(String name){
        if(this.residents.contains(name)){
            residents.remove(name);
            return name;
        }
        else{
            throw new RuntimeException("This resident does not live here :0");
        }
    }

  /**
   * checks to see if a person is a resident
   * @param person name of the person
   * @return bool of if a person is in residents array list
   */
    public boolean isResidents(String person){
        return residents.contains(person);
  }

  /**
   * prints a list of available methods
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    System.out.println("+ hasDiningRoom()" + "\n+ hasElevator");
    System.out.println("+ moveIn()" + "\n+ moveOut()");
    System.out.println("+ nResidents()\n+ isResident()");
}

  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("Emma", "Ashby", "Rachel", "Ashley"));
    House Chase = new House(list, true, "Chase", "Elm Street", 3, true);
    System.out.println(Chase);
    System.out.println(Chase.hasDiningRoom());
    System.out.println(Chase.nResidents());
    Chase.moveIn("Chloe");
    System.out.println(Chase.nResidents());
    Chase.moveOut("Chloe");
    try{Chase.moveOut("Chloe");}
    catch(RuntimeException e){
      System.out.println(e.getMessage());}
    System.out.println(Chase.nResidents());
    System.out.println(Chase.isResidents("Ashby"));
    System.out.println(Chase.isResidents("Chloe"));
    Chase.showOptions();
  }

}