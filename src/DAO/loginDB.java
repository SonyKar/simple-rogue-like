package DAO;

import Model.Login;
import Utilities.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static main.Main.player;

public class loginDB {
    private final Connection connection;

    public loginDB() {
        this.connection = DBConnection.getConnection();
    }

    public Login read(String loginText, String password) {
        Login login = null;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from user where login=? && password=?");
            preparedStatement.setString(1, loginText);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                login = new Login(rs.getString("login"), rs.getInt("id"));
                player = new playerDB().read(login);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return login;
    }
}
