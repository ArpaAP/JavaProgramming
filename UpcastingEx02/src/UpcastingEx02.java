public class UpcastingEx02 {
    public static void printObject(Animal[] objs) {
        for (Animal a: objs) {
            System.out.print(a.name + " -> ");
            a.nature();
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "BlueFish";

        Animal fish = new Fish();
        fish.name = "Whale";
        // fish.color = "Blue";

        Animal person = new Human();
        person.name = "Person1";

        Animal[] animals = {animal, fish, person};
        printObject(animals);
    }
}