/* This is a stub for the Library class */
import java.util.Hashtable;
/**
 * creates a library that extends the building class
 */
public class Library extends Building {
  private Hashtable < String, Boolean > collection;
  private boolean hasElevator = false;
  /**
   * constructor for library
   * @param name name of library
   * @param address address of library
   * @param nFloors number of floors
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable < String, Boolean > ();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * constructor for a library
   * @param collection starting collection of books
   * @param name name of library
   * @param address adress of library
   * @param nFloors number of floors
   * @param hasElevator t/f for if library has an elevator
   */
  public Library(Hashtable<String, Boolean> collection, String name, String address, int nFloors, boolean hasElevator) {
    this.collection = collection;
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * constructor for library
   * @param name name of library
   * @param address adress of library
   * @param nFloors number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable < String, Boolean > ();
    System.out.println("You have built a library: 📖");
  }

  /**
   * adds a book to the library
   * @param title title of the book
   */
  public void addTitle(String title) {
    if (!this.containsTitle(title)) {
      collection.put(title, true);
    } else {
      throw new RuntimeException("This book is already present");
    }
  }

  /**
   * removes a book from the library
   * @param title title of book
   * @return title of book
   */
  public String removeTitle(String title) {
    if (this.containsTitle(title)) {
      collection.remove(title);
      return title;
    } else {
      throw new RuntimeException("This book is not in the library :0");
    }
  }

  /**
   * checks out a book from the library
   * @param title name of book
   */
  public void checkOut(String title) {
    if (this.containsTitle(title) && this.isAvailable(title)) {
      collection.replace(title, false);
    } else {
      throw new RuntimeException("This book is not in the library or is not available :0");
    }
  }

  /**
   * returns a book to the library
   * @param title title of the book
   */
  public void returnBook(String title) {
    if (this.containsTitle(title) && !this.isAvailable(title)) {
      collection.replace(title, true);
    } else {
      throw new RuntimeException("This book has already been returned :0");
    }
  }

  /**
   * checks to see if the book exists in the library
   * @param title title of the book
   * @return bool of if it exists
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * checks to see if the book has been checked out
   * @param title title of book
   * @return bool for if it is available
   */
  public boolean isAvailable(String title) {
    return collection.get(title);
  }

  /**
   * prints each book and their availability status
   */
  public void printCollection() {
    if (!this.collection.isEmpty()) {
      collection.forEach((title, avail) -> System.out.println("Available: " + avail + "     Title: " + title));
    } else {
      throw new RuntimeException("This library is book-less :0");
    }
  }

  /**
   * accessor for if the library has an elevator
   * @return true or false
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }

  /**
   * prints out options
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    System.out.println("+ addTitle()\n+ removeTitle()\n+ checkOut()\n+ returnBook()\n+ containsTitle()\n+ isAvailable()\n+ printCollection()\n+ hasElevator()");
  }

  /**
   * changes which floor someone is on
   */
  public void goToFloor(int floorNum) {
    if (this.hasElevator) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    } else {
      throw new RuntimeException("This building does not have an elevator...you have to walk :0");
    }
  }

  public static void main(String[] args) {
    Library nielson = new Library("Nielson", "Smith", 4, true);
    nielson.addTitle("Of Mice and Men");
    nielson.addTitle("Parable of the Sower");
    nielson.checkOut("Of Mice and Men");
    try {
      nielson.checkOut("Of Mice and Men");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      nielson.checkOut("Parable of the talents");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    nielson.removeTitle("Of Mice and Men");
    nielson.removeTitle("Parable of the Sower");
    try {
      nielson.printCollection();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    Hashtable<String, Boolean> cary_collection = new Hashtable<>();
    cary_collection.put("A Gentleman in Moscow", true);
    Library cary = new Library(cary_collection, "Cary Memorial Library", "123 Mass Ave", 3, true);
    cary.printCollection();
    nielson.showOptions();
  }

}