package c04_professional_classes;

public class ComparableDemo {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice", 165),
            new Person("Bob", 175),
            new Person("Charlie", 160),
            new Person("David", 180),
            new Person("Eve", 170)
        };
        sort(people);
        printArray(people);
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static class Person implements Comparable<Person> {
        private String name;
        private int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int compareTo(Person other) {
            return Integer.compare(this.height, other.height);
        }

        @Override
        public String toString() {
            return name + " (" + height + " cm)";
        }
    }
}
