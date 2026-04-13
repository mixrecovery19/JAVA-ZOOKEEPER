public class Main {
    public static void main(String[] args) {

        // =========================================================
        // OBJECT INSTANTIATION / OBJECT CREATION
        // Creating multiple Zookeeper objects from the Zookeeper class.
        // Each object is its own instance with its own state (data).
        // This demonstrates object creation and multiple objects in memory.
        // =========================================================
        Zookeeper zookeeper = new Zookeeper(1111111, "Michael", "Kalaf");
        Zookeeper zookeeper2 = new Zookeeper(2222222, "John", "Doe");
        Zookeeper zookeeper3 = new Zookeeper(3333333, "Jane", "Smith");
        Zookeeper zookeeper4 = new Zookeeper(4444444, "Emily", "Johnson");

        // =========================================================
        // METHOD CALLING / ENCAPSULATED BEHAVIOUR
        // Calling a method that belongs to the Zookeeper object.
        // This demonstrates that objects contain both data and behaviour.
        // =========================================================
        zookeeper.displayDetails();
        zookeeper2.displayDetails();
        zookeeper3.displayDetails();
        zookeeper4.displayDetails();

        // =========================================================
        // INHERITANCE + POLYMORPHISM
        // Cage, Aquarium and Aviary are subclasses of Enclosure.
        // Each child class extends the parent Enclosure class.
        //
        // Because each subclass "is an" Enclosure,
        // they can be stored in Enclosure variables.
        // This is true runtime polymorphism.
        // =========================================================
        Enclosure cage = new Cage();
        Enclosure aquarium = new Aquarium();
        Enclosure aviary = new Aviary();

        // =========================================================
        // COMPOSITION / CONTROLLER CLASS DESIGN
        // EnclosureManager acts as a central controller class.
        // This simulates real-world system design where a manager/service
        // class coordinates interactions between objects.
        // =========================================================
        EnclosureManager manager = new EnclosureManager();

        // =========================================================
        // COLLECTIONS / AGGREGATION
        // Adding multiple Enclosure objects into the manager's ArrayList.
        // Demonstrates storing objects in collections.
        // =========================================================
        manager.addEnclosure(cage);
        manager.addEnclosure(aquarium);
        manager.addEnclosure(aviary);

        // =========================================================
        // OBJECT RELATIONSHIPS / ASSOCIATION
        // Assigning different Zookeepers to different Enclosures
        // through the manager controller.
        //
        // This demonstrates object-to-object relationships.
        // =========================================================
        manager.assignKeeperToEnclosure(0, zookeeper);
        manager.assignKeeperToEnclosure(1, zookeeper2);
        manager.assignKeeperToEnclosure(2, zookeeper3);

        // =========================================================
        // REPORTING / ITERATION THROUGH COLLECTIONS
        // Calls the manager's printReport() method which loops through
        // the collection of Enclosure objects and prints each one.
        // =========================================================
        manager.printReport();

        // =========================================================
        // DIRECT OBJECT METHOD CALLING
        // Repeating keeper assignments directly on the Enclosure objects.
        // This is useful for demonstration purposes to show
        // direct interaction between objects.
        // =========================================================
        cage.assignKeeper(zookeeper);
        aquarium.assignKeeper(zookeeper2);
        aviary.assignKeeper(zookeeper3);

        // =========================================================
        // ONE-TO-MANY RELATIONSHIP
        // Demonstrates one Zookeeper being assigned multiple Enclosures
        // using an ArrayList inside the Zookeeper class.
        //
        // This is a classic one-to-many OOP relationship.
        // =========================================================
        zookeeper2.assignEnclosure(cage);
        zookeeper2.assignEnclosure(aquarium);
        zookeeper2.assignEnclosure(aviary);

        // =========================================================
        // DEMONSTRATION / HYPOTHETICAL EXAMPLE
        // Additional example to show that another Zookeeper
        // can also reference an Enclosure in the collection.
        // Included for learning and demonstration purposes.
        // =========================================================
        zookeeper4.assignEnclosure(cage);

        // =========================================================
        // POLYMORPHIC ARRAY
        // Storing different subclass objects in a parent class array.
        //
        // This is one of the strongest demonstrations of polymorphism.
        // Different object types are all treated as Enclosure.
        // =========================================================
        Enclosure[] enclosures = {cage, aquarium, aviary};

        // =========================================================
        // ENHANCED FOR LOOP / POLYMORPHIC METHOD DISPATCH
        // Looping through the array of Enclosure objects.
        // Each object calls its own displayDetails() method.
        //
        // Demonstrates polymorphic behaviour and iteration.
        // =========================================================
        for (Enclosure enclosure : enclosures) {
            enclosure.displayDetails();
        }
    }
}