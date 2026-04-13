// =========================================================
// IMPORTING ARRAYLIST FROM JAVA COLLECTION FRAMEWORK
// ArrayList is used to store multiple Enclosure objects.
//
// This allows the manager class to act as a central system
// controller that can manage many enclosures.
//
// Demonstrates use of dynamic collections.
// =========================================================
import java.util.ArrayList;

public class EnclosureManager {

    // =========================================================
    // PRIVATE INSTANCE VARIABLE / ENCAPSULATION
    // This field stores multiple Enclosure objects.
    //
    // "private" is an access modifier that restricts direct
    // access from outside the class.
    //
    // This is a strong example of ENCAPSULATION.
    //
    // Only methods inside this class should directly manage
    // this collection.
    // =========================================================
    private ArrayList<Enclosure> enclosures;

    // =========================================================
    // CONSTRUCTOR
    // Automatically called when an EnclosureManager object
    // is created using "new".
    //
    // It initializes the ArrayList ready to store Enclosures.
    //
    // Demonstrates object initialization.
    // =========================================================
    public EnclosureManager() {

        // =====================================================
        // CREATING A NEW EMPTY COLLECTION
        // This initializes the list so objects can be added.
        // =====================================================
        enclosures = new ArrayList<>();
    }

    // =========================================================
    // ADD METHOD / OBJECT BEHAVIOUR
    // This method adds an Enclosure object into the manager's
    // collection.
    //
    // Demonstrates:
    // - object association
    // - aggregation
    // - use of collection methods
    // =========================================================
    public void addEnclosure(Enclosure e) {

        // =====================================================
        // add() inserts the object into the ArrayList.
        // =====================================================
        enclosures.add(e);
    }

    // =========================================================
    // ASSOCIATION / CONTROLLER METHOD
    // This method links a Zookeeper object to a specific
    // Enclosure object stored in the list.
    //
    // This demonstrates:
    // - object interaction
    // - controller class design
    // - method delegation
    // =========================================================
    public void assignKeeperToEnclosure(int index, Zookeeper k) {

        // =====================================================
        // VALIDATION / BOUNDARY CHECKING
        // Prevents invalid index access.
        //
        // Ensures the requested enclosure exists in the list.
        //
        // This is defensive programming.
        // =====================================================
        if (index >= 0 && index < enclosures.size()) {

            // =================================================
            // get(index) retrieves the specific Enclosure object
            // from the ArrayList.
            //
            // Then assignKeeper() is called on that object.
            //
            // This is METHOD CHAINING / DELEGATION.
            //
            // The manager delegates the action to the Enclosure.
            // =================================================
            enclosures.get(index).assignKeeper(k);
        }
    }

    // =========================================================
    // REPORTING METHOD / ITERATION
    // Loops through all Enclosure objects in the collection
    // and displays their details.
    //
    // Demonstrates:
    // - iteration
    // - enhanced for loop
    // - polymorphic object handling
    // - centralized reporting
    // =========================================================
    public void printReport() {

        // =====================================================
        // ENHANCED FOR LOOP
        // Loops through every Enclosure object in the list.
        //
        // This is clean collection iteration.
        // =====================================================
        for (Enclosure e : enclosures) {

            // =================================================
            // METHOD CALL ON EACH OBJECT
            // Calls displayDetails() on each Enclosure object.
            //
            // Demonstrates polymorphic method dispatch if
            // subclasses are used.
            // =================================================
                e.displayDetails();
    
                // =================================================
                // FORMATTED OUTPUT / REPORT STRUCTURE
                // Used to visually separate report entries.
                // =================================================
                System.out.println("----------------------");
            }
        }
    
        // =========================================================
        // REPORTING METHOD / STRING BUILDER
        // Returns all Enclosure details as a formatted string.
        //
        // Demonstrates:
        // - StringBuilder for efficient string concatenation
        // - return values
        // - null checking
        // =========================================================
        public String getReportAsString() {
            StringBuilder report = new StringBuilder();
    
            for (Enclosure e : enclosures) {
                report.append("Enclosure ID: ").append(e.enclosureId).append("\n");
                report.append("Enclosure Name: ").append(e.enclosureName).append("\n");
                report.append("Enclosure Type: ").append(e.enclosureType).append("\n");
                report.append("Enclosure Capacity: ").append(e.enclosureCapacity).append("\n");
    
                if (e.keeper != null) {
                    report.append("Assigned Keeper: ")
                        .append(e.keeper.givenName)
                        .append(" ")
                        .append(e.keeper.familyName)
                        .append("\n");
                }
    
                report.append("----------------------\n");
            }
    
            return report.toString();
        }
    }