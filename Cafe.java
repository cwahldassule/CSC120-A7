
/* This is a stub for the Cafe class */
/**
 * class for a cafe with inventory
 */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean wifi;

    /**
     * creats a cafe
     * @param coffee ounces of coffee
     * @param sugar amt of sugar
     * @param cream amt of cream
     * @param cups amt of cups
     * @param name name of the cafe
     * @param address adddress of the cafe
     * @param nFloors number of floors
     */
    public Cafe (int coffee, int sugar, int cream, int cups, String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * constructor for a cafe
     * @param coffee coffee to start
     * @param cups cups to start
     * @param name name of cafe
     * @param address adress of cafe
     * @param nFloors number of floors
     */
    public Cafe (int coffee, int cups, String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * creats a constructor for cafe
     * @param coffee amount of coffee
     * @param sugar amount of sugar
     * @param cream amount of cream
     * @param cups amout of cups
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors
     * @param wifi t/f has wifi
     */
    public Cafe (int coffee, int sugar, int cream, int cups, String name, String address, int nFloors, boolean wifi) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        this.wifi = wifi;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * "sells" coffee by removing from inventory
     * @param size how many ounces of cofee
     * @param nSugarPackets amt of sugar
     * @param nCreams amt of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        //if(size > this.nCoffeeOunces | nSugarPackets > this.nSugarPackets | nCreams > this.nCreams | nCups == 0){
        //    System.out.println("Restocking...");
        //    this.restock(20, 10, 10,10);}
        if(size > this.nCoffeeOunces){
            this.restock(400,0,0,0);
        }
        if(nSugarPackets > this.nSugarPackets){
            this.restock(0, 200,0,0);
        }
        if(nCreams>this.nCreams){
            this.restock(0,0,200,0);
        }
        if(nCups == 0){
            this.restock(0,0,0,200);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    /**
     * restocks inventory
     * @param nCoffeeOunces amt of coffee to restock
     * @param nSugarPackets amt of sugar to restock
     * @param nCreams amt of cream to restock
     * @param nCups amt of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    /**
     * prints inventory
     */
    public void printInvt(){
        System.out.println("Coffee "+nCoffeeOunces);
        System.out.println("Suagar "+nSugarPackets);
        System.out.println("Cream "+nCreams);
        System.out.println("Cups "+nCups);
    }

    /**
     * prints all available methods
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n");
        System.out.println("+ sellCoffee()");
        System.out.println("+ printInvt()");
    }
    
    /**
     * doesn't allow a change in floor
     */
    public void goToFloor(int floorNum) {
            throw new RuntimeException("Sorry...employees only :/");
    }

    /**
     * doesn't allow a change in floor
     */
    public void goUp() {
        throw new RuntimeException("Sorry...employees only :/");
    }

    /**
     * doesn't allow a change in floor
     */
    public void goDown() {
        throw new RuntimeException("Sorry...employees only :/");
    }

    /**
     * accessor for wifi
     * @return t/f for wifi
     */
    public boolean hasWifi(){
        return this.wifi;
    }

    public static void main(String[] args) {
        Cafe campus = new Cafe(400, 200, 200, 200, "Campus Cafe", "Smith College", 3);
        campus.sellCoffee(100, 2, 2);
        campus.printInvt();
        campus.sellCoffee(12, 2, 2);
        campus.printInvt();
        campus.showOptions();

    }
    
}
