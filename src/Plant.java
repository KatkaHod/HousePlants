import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted; //planting date of the plant
    private LocalDate watering; //Watering day of the plant
    private int frequencyOfWatering;

    //first constructor
    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    //second constructor
    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }

    //third constructor
    public Plant(String name) {
        this(name, "", LocalDate.now(), LocalDate.now(), 7);
    }


    //get methods
    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    //watering date + recommended day of next watering (how many days)
    public LocalDate getNextWateringDate() {
        return watering.plusDays(frequencyOfWatering);
    }

   //created method which return name of plant, last date of watering and next date of recommend watering.
    public String getWateringInfo() {
        return "Name of plant: " + getName() + "\n"
                + "Date of the last watering: " + getWatering().toString() + "\n"
                + "Date of recommended next watering of plant: " + getNextWateringDate().toString();
    }

}
