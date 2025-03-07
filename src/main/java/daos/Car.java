package daos;

import java.util.List;

public class Car implements DTOInterface{

        private Integer id;
        private String make;
        private String model;
        private Integer year;
        private String color;
        private Integer vin;

        public Car(){
            this.id = 0;
            this.make = "";
            this.model = "";
            this.year = 0;
            this.color = "";
            this.vin = 0;
        }

        public Car(Integer id, String make, String model, Integer year, String color, Integer vin){
            this.id = id;
            this.make = make;
            this.model = model;
            this.year = year;
            this.color = color;
            this.vin = vin;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVin() {
        return vin;
    }

    @Override
    public String toString(){
        if(this != null)
            return String.format("\n************\nId: %d\nMake: %s\nModel: %s\nYear: %d\nColor: %s\nVIN: %d\n************\n",
                this.getId(), this.getMake(), this.getModel(), this.getYear(), this.getColor(), this.getVin());
        else return "wah-wah........404, this car does not exist";
    }

}
