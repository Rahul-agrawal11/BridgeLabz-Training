// FriendNode represents a single friend ID in friend list
class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

// User class holds user details and friend list
class User {
    int userId;
    String name;
    int age;
    FriendNode friends;   // Head of friend list

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
    }
}

// Node class for User Linked List
class UserNode {
    User user;
    UserNode next;

    UserNode(User user) {
        this.user = user;
        this.next = null;
    }
}

// Social Media Management using Singly Linked List
class SocialMedia {

    UserNode head = null;

    // Add a new user
    void addUser(int id, String name, int age) {
        User user = new User(id, name, age);
        UserNode node = new UserNode(user);

        node.next = head;
        head = node;
    }

    // Find user by ID
    User findUserById(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.user.userId == userId)
                return current.user;
            current = current.next;
        }
        return null;
    }

    // Add friend connection (both ways)
    void addFriendConnection(int userId1, int userId2) {

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found");
            return;
        }

        addFriend(user1, userId2);
        addFriend(user2, userId1);

        System.out.println("Friend connection added");
    }

    // Helper: add friend to user's friend list
    void addFriend(User user, int friendId) {

        FriendNode node = new FriendNode(friendId);
        node.next = user.friends;
        user.friends = node;
    }

    // Remove friend connection (both ways)
    void removeFriendConnection(int userId1, int userId2) {

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found");
            return;
        }

        removeFriend(user1, userId2);
        removeFriend(user2, userId1);

        System.out.println("Friend connection removed");
    }

    // Helper: remove friend from list
    void removeFriend(User user, int friendId) {

        FriendNode current = user.friends;
        FriendNode prev = null;

        while (current != null) {
            if (current.friendId == friendId) {
                if (prev == null)
                    user.friends = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Display all friends of a user
    void displayFriends(int userId) {

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friends;

        if (temp == null) {
            System.out.println("No friends");
            return;
        }

        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends between two users
    void findMutualFriends(int userId1, int userId2) {

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        boolean found = false;

        FriendNode f1 = user1.friends;

        while (f1 != null) {
            FriendNode f2 = user2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.print(f1.friendId + " ");
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.print("None");

        System.out.println();
    }

    // Search user by name
    void searchByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.user.name.equalsIgnoreCase(name)) {
                displayUser(current.user);
                return;
            }
            current = current.next;
        }
        System.out.println("User not found");
    }

    // Search user by ID
    void searchById(int userId) {
        User user = findUserById(userId);
        if (user != null)
            displayUser(user);
        else
            System.out.println("User not found");
    }

    // Count friends of each user
    void countFriends() {
        UserNode current = head;

        while (current != null) {
            int count = 0;
            FriendNode temp = current.user.friends;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            System.out.println(
                current.user.name + " has " + count + " friends"
            );
            current = current.next;
        }
    }

    // Display user details
    void displayUser(User user) {
        System.out.println(
            "User ID: " + user.userId +
            "\nName: " + user.name +
            "\nAge: " + user.age +
            "\n-------------------"
        );
    }
}

// Main class
class SocialMediaApp {

    public static void main(String[] args) {

        SocialMedia sm = new SocialMedia();

        // Add users
        sm.addUser(1, "Rahul", 21);
        sm.addUser(2, "Amit", 22);
        sm.addUser(3, "Sagar", 20);
        sm.addUser(4, "Rohit", 23);

        // Add friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        // Display friends
        sm.displayFriends(1);
        sm.displayFriends(3);

        // Mutual friends
        sm.findMutualFriends(1, 2);

        // Search users
        sm.searchByName("Rahul");
        sm.searchById(4);

        // Remove friend connection
        sm.removeFriendConnection(1, 3);
        sm.displayFriends(1);

        // Count friends
        sm.countFriends();
    }
}
