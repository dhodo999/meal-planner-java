package Domain;

import java.sql.Timestamp;

public class User {
    
    private int userID;
    private String name;
    private Timestamp dateCreated;

    public User(int userID, String name, Timestamp dateCreated) {

        this.userID = userID;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", name=" + name + ", dateCreated=" + dateCreated + '}';
    }
}
