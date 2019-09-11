package spring.example;

import java.util.Objects;

public class Client {

    private String Id;
    private String fullName;

    public Client(String id, String fullName) {
        Id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return Id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Id == client.Id &&
                Objects.equals(fullName, client.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, fullName);
    }
}
