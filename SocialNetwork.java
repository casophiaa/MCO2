import java.util.List;
import java.util.TreeSet;

public class SocialNetwork {
    private Graph graph;

    public SocialNetwork(Graph data) {
        this.graph = data;
    }

    public void showFriendList(int personId) {
        TreeSet<Integer> friends = graph.getFriends(personId);
        if (friends.isEmpty()) {
            System.out.println("\nNo friends found for person " + personId);
        } else {
            System.out.println("\nPerson " + personId + " has " + friends.size() + " friends!");
            System.out.print("List of friends: ");
            for (int friend : friends) {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
    }

    public void dispConnection(int person1, int person2) {
        if (!graph.hasConnection(person1, person2)) {
            System.out.println("\nNo connection found between " + person1 + " and " + person2);
        } else {
            List<Integer> connectionPath = graph.getConnectionPath(person1, person2);
            System.out.println("\nThere is a connection from " + person1 + " to " + person2 + "!");
            for (int i = 0; i < connectionPath.size(); i++) {
                if (i < connectionPath.size() - 1) {
                    System.out.println(connectionPath.get(i) + " is friends with " + connectionPath.get(i+1));
                }
            }
        }
    }
}
