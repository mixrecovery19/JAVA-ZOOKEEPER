public class Aquarium extends Enclosure {

    // =========================================================
    // SUBCLASS CONSTRUCTOR
    // This constructor is called when a new Aquarium object
    // is created.
    //
    // Aquarium is a CHILD CLASS that extends the parent
    // Enclosure class.
    //
    // This demonstrates INHERITANCE.
    // =========================================================
    Aquarium() {

        // =====================================================
        // SUPER KEYWORD / CONSTRUCTOR CHAINING
        // super() calls the constructor of the parent class
        // (Enclosure).
        //
        // This passes the specific Aquarium values into the
        // Enclosure parameterized constructor.
        //
        // This demonstrates:
        // - inheritance
        // - constructor chaining
        // - code reuse
        // =====================================================
        super(2345678, "Aquarium", "Water", 5);
    }
}