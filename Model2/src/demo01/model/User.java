package demo01.model;

import java.io.Serializable;

public class User implements Serializable {
    private	int id;
    private	String name;
    private String password;
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new String("[ "+getName() + "," + getEmail() + ","+ getPassword() + "," + getId() +" ]");
    }
}
