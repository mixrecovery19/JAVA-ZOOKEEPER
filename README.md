Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 1 of 3
Workshop Extension
Bringing it home! - ***Perfect Reminder*** 
***Wonder who's Social Media posts these bright sparks were part of, the corrupt cop, the drug dealing or the poor woman used by the two***
This Workshop is an extension of the project developed in this week’s OOP Concepts
Workshop.
Starting with that code…
Creating the ZooKeeper class
1. Create a new class called ZooKeeper and add fields:
Id
givenName
familyName
2. Add a method called displayDetails() that prints the ZooKeeper’s details
3. In main(), create one ZooKeeper object and call displayDetails()
Linking ZooKeeper to Enclosure
4. Modify the Enclosure class
Add a new field: ZooKeeper keeper
Add a method: assignKeeper(ZooKeeper k). Inside the method, assign the keeper to the
enclosure
5. Update the displayDetails() method in Enclosure. Display:
enclosureId
capacity
the assigned ZooKeeper’s name
(Hint: use keeper.givenName and keeper.familyName)
6. In main(), create:
One Enclosure
One ZooKeeper
7. Assign the ZooKeeper to the Enclosure and display the result
Working with multiple objects
8. Create multiple ZooKeeper objects
9. Create multiple Enclosure objects (e.g. Cage, Aquarium, Aviary)
10. Assign different ZooKeepers to different Enclosures
11. Display all Enclosures and their assigned ZooKeepers
Introducing polymorphism with collections
12. Create an array of Enclosure objects
13. Store different types of Enclosures in the array
14. Loop through the array and call displayDetails()
Observe: Each Enclosure still behaves correctly, even though the array type is Enclosure
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 2 of 3
Thinking about polymorphism
15. Why can one Enclosure variable store different types such as Cage, Aquarium, and Aviary?
16. What concept from object-oriented programming allows this?
Extending the design (one-to-many relationship)
17. Modify ZooKeeper so that it can be assigned to more than one Enclosure
(Hint: use an array or ArrayList of Enclosure)
18. Add a method assignEnclosure(Enclosure e)
19. Update your program so that a ZooKeeper can manage multiple Enclosures
20. Display which Enclosures each ZooKeeper is responsible for
Extension of Extension. Looking ahead
The purpose of this extension is not to review this week’s OOP material.
It is to prepare you for the upcoming assignment and to help you start thinking about how
these concepts are used in real-world systems.
Create a new class called EnclosureManager.
This class will act as a central controller that brings the different parts of your program together
into a complete system. This class will:
• Store enclosures
• Assign ZooKeepers
• Display a report
Your starter code:
public class EnclosureManager {
private ArrayList<Enclosure> enclosures;
public EnclosureManager() {
enclosures = new ArrayList<>();
}
public void addEnclosure(Enclosure e) {
enclosures.add(e);
}
public void assignKeeperToEnclosure(int index, ZooKeeper k) {
if (index >= 0 && index < enclosures.size()) {
enclosures.get(index).assignKeeper(k);
}
}
public void printReport() {
for (Enclosure e : enclosures) {
e.displayDetails();
System.out.println("----------------------");
}
}
}
Bachelor of Information Technology
BIT235 Object Oriented Programming, 2026 Semester 1 Page 3 of 3
How to use it in MainDriver:
public class MainDriver {
public static void main(String[] args) {
EnclosureManager manager = new EnclosureManager();
Cage c1 = new Cage();
Aquarium a1 = new Aquarium();
ZooKeeper z1 = new ZooKeeper(1000001, "Sam", "Lee");
ZooKeeper z2 = new ZooKeeper(1000002, "Alex", "Kim");
manager.addEnclosure(c1);
manager.addEnclosure(a1);
manager.assignKeeperToEnclosure(0, z1);
manager.assignKeeperToEnclosure(1, z2);
manager.printReport();
}
}
