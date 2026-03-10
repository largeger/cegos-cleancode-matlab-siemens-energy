package c02_oop;

import java.util.ArrayList;
import java.util.List;

/*
Explanation
1. Low Cohesion (UserAccount):
    - Die Klasse UserAccount verwaltet sowohl Benutzerdaten als auch die Anzeige von Benutzerinformationen und Freundeslisten.
    - Durch die Vermischung von Verantwortlichkeiten wird die Wartung erschwert, da Änderungen an der Datenverwaltung oder der Anzeige
      Anpassungen an der gesamten Klasse erfordern.
2. High Cohesion (UserManager und UserPrinter):
    - UserManager ist ausschließlich für die Verwaltung der Benutzerdaten verantwortlich.
    - UserPrinter ist für die Anzeige der Benutzerinformationen und der Freundesliste zuständig.
    - Jede Klasse hat eine einzelne, fokussierte Verantwortung, wodurch sie leichter zu warten und zu erweitern ist.
*/

// Low Cohesion Example
public class Cohesion {

    static class UserAccount {
        private String name;
        private int age;
        private List<String> friends;

        public UserAccount(String name, int age) {
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
        }

        public void addFriend(String friendName) {
            friends.add(friendName);
        }

        public void displayUserDetails() {
            System.out.println("User: " + name + ", Age: " + age);
        }

        public void printFriends() {
            System.out.println("Friends of " + name + ":");
            for (String friendName : friends) {
                System.out.println("- " + friendName);
            }
        }
    }

    // High Cohesion Example
    static class UserManager {
        private String name;
        private int age;
        private List<String> friends;

        public UserManager(String name, int age) {
            this.name = name;
            this.age = age;
            this.friends = new ArrayList<>();
        }

        public void addFriend(String friendName) {
            friends.add(friendName);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<String> getFriends() {
            return friends;
        }
    }

    static class UserPrinter {
        public static void displayUserDetails(UserManager user) {
            System.out.println("User: " + user.getName() + ", Age: " + user.getAge());
        }

        public static void printFriends(UserManager user) {
            System.out.println("Friends of " + user.getName() + ":");
            for (String friendName : user.getFriends()) {
                System.out.println("- " + friendName);
            }
        }
    }

    public static void main(String[] args) {
        // Low Cohesion example
        System.out.println("Low Cohesion Example:");
        UserAccount user1 = new UserAccount("Alice", 30);
        user1.addFriend("Bob");
        user1.addFriend("Charlie");
        user1.displayUserDetails();
        user1.printFriends();

        System.out.println("\nHigh Cohesion Example:");
        UserManager user2 = new UserManager("Alice", 30);
        user2.addFriend("Bob");
        user2.addFriend("Charlie");

        UserPrinter.displayUserDetails(user2);
        UserPrinter.printFriends(user2);
    }

}
