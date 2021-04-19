package duelGame;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    public static ArrayList<User> select() {
        ArrayList<User> users = new ArrayList<>();

        try {
            Connection conn = ConnectionProvider.getConn();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                int hp = resultSet.getInt(4);
                int attack = resultSet.getInt(5);
                int rating = resultSet.getInt(6);
                User user = new User(id, name, password, hp, attack, rating);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    public static int findByName(String name) {
        User user = null;

        try {
            Connection conn = ConnectionProvider.getConn();
            String sql = "select * from users where name like \"?\"";

            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int userId = resultSet.getInt(1);
                    String userName = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    int hp = resultSet.getInt(4);
                    int attack = resultSet.getInt(5);
                    int rating = resultSet.getInt(6);
                    user = new User(userId, userName, password, hp, attack, rating);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user.getId();
    }

    public static User selectOne(int id) {
        User user = null;
        try {
            Connection conn = ConnectionProvider.getConn();

            String sql = "SELECT * FROM users WHERE id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int userId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    int hp = resultSet.getInt(4);
                    int attack = resultSet.getInt(5);
                    int rating = resultSet.getInt(6);
                    user = new User(userId, name, password, hp, attack, rating);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public static int insert(User user) {
        try {
            Connection conn = ConnectionProvider.getConn();

            String sql = "INSERT INTO users (name, password) Values (?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPassword());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public static int update(User user) {
        try {
            Connection conn = ConnectionProvider.getConn();

            String sql = "UPDATE users SET rating = ?, attack = ?, hp = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, user.getRating());
                preparedStatement.setInt(2, user.getAttack());
                preparedStatement.setInt(3, user.getHp());
                preparedStatement.setInt(4, user.getId());

                return preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public static boolean validate(User user) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getConn();

            PreparedStatement ps = con.prepareStatement(
                    "select * from users where name=? and password=?");

            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return status;
    }

    public static boolean isExist(String name) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getConn();

            PreparedStatement ps = con.prepareStatement(
                    "select * from users where name=?");

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        try {
            Connection conn = ConnectionProvider.getConn();

            String sql = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}