public class Enclosure {

    // =========================================================
    // INSTANCE VARIABLES / OBJECT STATE
    // These fields store the data (state) of each Enclosure
    // object.
    //
    // Every object created from this class will have its own
    // separate values.
    //
    // This demonstrates ENCAPSULATION of data.
    // =========================================================
    int enclosureId;
    String enclosureName;
    String enclosureType;
    int enclosureCapacity;

    // =========================================================
    // OBJECT ASSOCIATION
    // This field stores a reference to a Zookeeper object.
    //
    // This creates an object-to-object relationship.
    //
    // One Enclosure has one assigned Zookeeper.
    //
    // This is a one-to-one / many-to-one style relationship
    // depending on overall design.
    // =========================================================
    Zookeeper keeper;

    // =========================================================
    // DEFAULT CONSTRUCTOR
    // This constructor is called when no parameters are passed.
    //
    // It provides default values for an Enclosure object.
    //
    // Demonstrates constructor overloading.
    // =========================================================
    Enclosure() {
        this.enclosureId = 1234567;
        this.enclosureName = "Savannah";
        this.enclosureType = "Grassland";
        this.enclosureCapacity = 10;
    }

    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // This constructor allows custom values to be passed when
    // creating an Enclosure object.
    //
    // This demonstrates:
    // - constructor overloading
    // - object initialization
    // - use of parameters
    // =========================================================
    Enclosure(int enclosureId, String enclosureName,
              String enclosureType, int enclosureCapacity) {

        // =====================================================
        // "this" refers to the current object instance.
        //
        // Used to distinguish between instance variables and
        // constructor parameters.
        // =====================================================
        this.enclosureId = enclosureId;
        this.enclosureName = enclosureName;
        this.enclosureType = enclosureType;
        this.enclosureCapacity = enclosureCapacity;
    }

    // =========================================================
    // ASSOCIATION METHOD
    // Assigns a Zookeeper object to this Enclosure.
    //
    // Demonstrates object interaction and association.
    //
    // This method creates the relationship:
    // one enclosure -> one keeper
    // =========================================================
    public void assignKeeper(Zookeeper k) {
        this.keeper = k;
    }

    // =========================================================
    // INSTANCE METHOD / OBJECT BEHAVIOUR
    // Displays the current state of the Enclosure object.
    //
    // Demonstrates encapsulated behaviour.
    // =========================================================
    public void displayDetails() {

        // =====================================================
        // OUTPUTTING OBJECT STATE
        // Printing the data stored in the current object.
        // =====================================================
        System.out.println("Enclosure ID: " + enclosureId);
        System.out.println("Enclosure Capacity: " + enclosureCapacity);
        System.out.println("Enclosure Name: " + enclosureName);
        System.out.println("Enclosure Type: " + enclosureType);

        // =====================================================
        // CONDITIONAL LOGIC / NULL CHECK
        // Ensures that a keeper has been assigned before trying
        // to access the keeper object's fields.
        //
        // This prevents NullPointerException.
        //
        // Strong example of defensive programming.
        // =====================================================
        if (keeper != null) {

            // =================================================
            // ACCESSING ANOTHER OBJECT'S DATA
            // Demonstrates object reference usage.
            //
            // This enclosure object accesses fields stored
            // inside the linked Zookeeper object.
            // =================================================
            System.out.println("Assigned Keeper Name: "
                    + keeper.givenName + " "
                    + keeper.familyName);
        }
    }
}