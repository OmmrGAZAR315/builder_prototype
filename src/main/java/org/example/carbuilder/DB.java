package org.example.carbuilder;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class DB {
    public static void selectAllCars(List<Car> builder) {
        String sql = "SELECT * FROM cars ORDER BY 'id' DESC";
        try (Statement statement = dbConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            // Iterate through the result set and create Car objects
            while (resultSet.next()) {
                String ownerName = resultSet.getString("ownerName");
                String model = resultSet.getString("model");
                String color = resultSet.getString("color");
                String engine = resultSet.getString("engine");
                String fuelType = resultSet.getString("fuelType");

                // Create a new Car object
                builder.add(new ConcreteCarBuilder()
                        .setOwnerName(ownerName)
                        .setModel(model)
                        .setColor(color)
                        .setEngine(engine)
                        .setFuelType(fuelType)
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertCar(Car car) {
        String insertSql = "INSERT INTO `cars` (ownerName,model, color, engine ,fuelType,created_at) " +
                "VALUES (?, ?,?,?,?,?)";
        try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, car.getOwnerName());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getColor());
            preparedStatement.setString(4, car.getEngine());
            preparedStatement.setString(5, car.getFuelType());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
