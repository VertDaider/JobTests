package duelGame;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 2041275512219239990L;

    private int id;
    private String name;
    private String password;
    private int attack;
    private int hp;
    private int rating;

    public User() {

    }

    public User(String name, String password) {
        this.password = password;
        this.name = name;
    }

    public User(int id, String name, String password, int hp, int attack, int rating) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.hp = hp;
        this.attack = attack;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public boolean equals(User u) {
        return this.password.equals(u.getPassword()) && this.name.equals(u.getName());

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}