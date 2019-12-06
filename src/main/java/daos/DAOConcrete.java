package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOConcrete implements DAOInterface {



    @Override
    public Car findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars WHERE id=" + id);
            if (rs.next()) {
                return extractCarFromResultSet(rs);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    private Car extractCarFromResultSet(ResultSet rs) throws SQLException{
        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setColor(rs.getString("color"));

        return car;
    }

    @Override
    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars");
            List cars = new ArrayList<Car>();
            while(rs.next()){
                Car car = extractCarFromResultSet(rs);
                cars.add(car);
            }
            return cars;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Car update(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getColor());
            ps.setInt(6, car.getVin());
            int i = ps.executeUpdate();

            if (i == 1) return car;

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Car create(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cars VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getColor());
            ps.setInt(6, car.getVin());
            int i = ps.executeUpdate();

            if (i == 1) return car;

        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM cars WHERE id=" + id);
            if (i == 1) return true;
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

}
