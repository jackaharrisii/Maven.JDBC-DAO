package daos;

import java.sql.Connection;

public class App {

    private int id;
    private Car car;

    private DAOConcrete daoConcrete = new DAOConcrete();

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        run();
    }

    public static void run(){
        // PRINTS THE CAR WITH ID == 1
//        System.out.println(new DAOConcrete().findById(1).toString());

        // PRINTS ALL CARS IN THE CONSOLE
        System.out.println(new DAOConcrete().findAll());

        Car newTracker = new Car(7, "Geo", "Tracker", 1980, "red", 12345);

        // UPDATES AN EXISTING CAR
        // (DOESN'T WORK YET)
        // THE INTERFACE WANTS TO PASS A CAR INTO UPDATE, BUT THAT WON'T WORK - WE NEED TO PASS THE CAR, THE FIELD, AND THE NEW VALUE
//        System.out.println(new DAOConcrete().update(newTracker));

        // CREATES A NEW TRACKER AT THE BOTTOM OF MY TABLE
//        System.out.println(new DAOConcrete().create(newTracker));

        // DELETES THE CAR WITH ID == 1
//        System.out.println(new DAOConcrete().delete(1));
    }

}
