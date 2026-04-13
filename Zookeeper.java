// =========================================================
// IMPORTING A JAVA COLLECTION CLASS
// ArrayList is part of Java's Collection Framework.
// It allows dynamic storage of multiple objects.
//
// Unlike a fixed-size array, an ArrayList can grow as
// objects are added.
//
// This is used to model a one-to-many relationship.
// =========================================================
import java.util.ArrayList;

public class Zookeeper {

    // =========================================================
    // INSTANCE VARIABLES / FIELDS / OBJECT STATE
    // These variables store the data (state) for each
    // Zookeeper object.
    //
    // Every object created from this class will have its own
    // separate values for id, givenName, familyName,
    // and assignedEnclosures.
    //
    // This demonstrates ENCAPSULATION of data.
    // =========================================================
    int id;
    String givenName;
    String familyName;

    // =========================================================
    // ONE-TO-MANY RELATIONSHIP
    // This ArrayList stores multiple Enclosure objects.
    //
    // One Zookeeper can be responsible for many Enclosures.
    //
    // This demonstrates:
    // - object association
    // - aggregation
    // - one-to-many relationship
    // - use of collections
    // =========================================================
    ArrayList<Enclosure> assignedEnclosures;

    // =========================================================
    // CONSTRUCTOR
    // The constructor is automatically called when a new
    // Zookeeper object is created using "new".
    //
    // It initializes the object state.
    //
    // "this" refers to the current object instance.
    //
    // This demonstrates constructor-based object initialization.
    // =========================================================
    Zookeeper(int id, String givenName, String familyName) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;

        // =====================================================
        // INITIALISING THE COLLECTION
        // Creates an empty ArrayList ready to store Enclosure
        // objects.
        //
        // Each Zookeeper object gets its own separate list.
        // =====================================================
        this.assignedEnclosures = new ArrayList<>();
    }

    // =========================================================
    // INSTANCE METHOD / OBJECT BEHAVIOUR
    // This method belongs to the Zookeeper object.
    //
    // It displays the current state of the object.
    //
    // Demonstrates encapsulated behaviour.
    // =========================================================
    public void displayDetails() {
        System.out.println("Zookeeper ID: " + id);
        System.out.println("Given Name: " + givenName);
        System.out.println("Family Name: " + familyName);

        // =====================================================
        // COLLECTION METHOD
        // size() is a built-in ArrayList method.
        //
        // It returns the number of Enclosure objects currently
        // assigned to this Zookeeper.
        //
        // This directly demonstrates the one-to-many relationship.
        // =====================================================
        System.out.println("Assigned Enclosures: " + assignedEnclosures.size());

        System.out.println();
    }

    // =========================================================
    // ASSOCIATION METHOD
    // Adds an Enclosure object to this Zookeeper's list.
    //
    // This method creates the relationship:
    // one Zookeeper -> many Enclosures
    //
    // Demonstrates:
    // - object interaction
    // - object references
    // - one-to-many relationship
    // =========================================================
    public void assignEnclosure(Enclosure enclosure) {

        // =====================================================
        // add() is an ArrayList method.
        // It inserts the object reference into the collection.
        // =====================================================
        assignedEnclosures.add(enclosure);
    }
}