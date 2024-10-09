import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
    private String fruitName;
    private int fruitQty;

    public Fruit(String fruitName, int fruitQty) {
        this.fruitName = fruitName;
        this.fruitQty = fruitQty;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitQty() {
        return fruitQty;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public void setFruitQty(int fruitQty) {
        this.fruitQty = fruitQty;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fruitName='" + fruitName + '\'' +
                ", fruitQty=" + fruitQty +
                '}';
    }

    @Override
    public int compareTo(Fruit other) {
        int nameComparison = this.fruitName.compareTo(other.fruitName);
        if (nameComparison != 0) {
            return nameComparison; 
        }
        return Integer.compare(this.fruitQty, other.fruitQty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return fruitQty == fruit.fruitQty && Objects.equals(fruitName, fruit.fruitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitName, fruitQty);
    }
}
Driver.java
java
Copy code
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", 5));
        fruits.add(new Fruit("Banana", 3));
        fruits.add(new Fruit("Orange", 4));
        fruits.add(new Fruit("Apple", 2));
        fruits.add(new Fruit("Banana", 7));
        fruits.add(new Fruit("Grapes", 10));

        Collections.sort(fruits);

        fruits.forEach(System.out::println);
    }
}