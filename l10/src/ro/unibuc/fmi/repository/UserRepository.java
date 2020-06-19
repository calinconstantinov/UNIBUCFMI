package ro.unibuc.fmi.repository;

import ro.unibuc.fmi.connection.DatabaseConnection;
import ro.unibuc.fmi.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserRepository {

    private static UserRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO persons (email, name, registeredDateTime) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM persons WHERE email = ?";
    private static final String UPDATE_STATEMENT = "UPDATE persons SET name = ? WHERE email = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM persons WHERE email=?";

    private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM persons ORDER BY registeredDateTime DESC LIMIT 1";

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }

        return instance;
    }

    public User saveUser(User user) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, DATE_FORMAT.format(user.getRegisteredDateTime()));

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new user: " + e.getMessage());
            return new User();
        }
        return user;
    }

    public User findUser(String email) {
        User user = new User();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, email);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find user: User was not found!");
                    return user;
                }

                System.out.println("User was found!");
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find user: " + e.getMessage());
        }
        return user;
    }

    public User updateUser(User user) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User was updated successfully!");
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update user: " + e.getMessage());
            return new User();
        }

        System.out.println("Something went wrong when trying to update user: User was not found!");
        return new User();
    }

    public boolean deleteUser(String email) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, email);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete user: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete user: User was not found!");
        return false;
    }

    public User findNewestMember() {
        User user = new User();
        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {

            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
                if (!result.next()) {
                    System.out.println("Database might be empty!");
                    return user;
                }

                System.out.println("Newest member was found!");
                user.setEmail(result.getString("email"));
                user.setName(result.getString("name"));
                user.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
            }
        } catch (SQLException | ParseException e) {
            System.out.println("Something went wrong when trying to find the most newly registered user: " + e.getMessage());
        }
        return user;
    }
}
