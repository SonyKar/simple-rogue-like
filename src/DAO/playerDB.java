package DAO;

import Model.Login;
import Model.Player;
import Utilities.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class playerDB {
    private final Connection connection;

    public playerDB() {
        this.connection = DBConnection.getConnection();
    }

    public Player read(Login login) {
        Player player = new Player();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from player where user_id=?");
            preparedStatement.setInt(1, login.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                player.setName(login.getName());
                player.setCurrentHealth(rs.getInt("current_health"));
                player.setHealth(rs.getInt("health"));
                player.setDamage(rs.getInt("damage"));
                player.setLuck(rs.getInt("luck"));
                player.setCoins(rs.getInt("coins"));
                player.setCharacteristicLevel(rs.getInt("characteristicLevel"));
                player.setNumberOfVisitedRooms(rs.getInt("level"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return player;
    }

    public void write(Player player, Login login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO player VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, login.getId());
            preparedStatement.setInt(2, player.getCurrentHealth());
            preparedStatement.setInt(3, player.getHealth());
            preparedStatement.setInt(4, player.getDamage());
            preparedStatement.setInt(5, player.getLuck());
            preparedStatement.setInt(6, player.getCoins());
            preparedStatement.setInt(7, player.getCharacteristicLevel());
            preparedStatement.setInt(8, player.getNumberOfVisitedRooms());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void update(Player player, Login login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE player SET current_health = ?, health = ?, damage=?, luck=?, coins=?, characteristicLevel=?, `level`=? WHERE user_id = ?");
            preparedStatement.setInt(1, player.getCurrentHealth());
            preparedStatement.setInt(2, player.getHealth());
            preparedStatement.setInt(3, player.getDamage());
            preparedStatement.setInt(4, player.getLuck());
            preparedStatement.setInt(5, player.getCoins());
            preparedStatement.setInt(6, player.getCharacteristicLevel());
            preparedStatement.setInt(7, player.getNumberOfVisitedRooms());
            preparedStatement.setInt(8, login.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
