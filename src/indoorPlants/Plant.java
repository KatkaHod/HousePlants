package indoorPlants;

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


    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException  {
        if (frequencyOfWatering <= 0) {
            throw new PlantException("Watering frequency cannot be 0 or less. Provided value: " + frequencyOfWatering);
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public int getFrequencyOfWatering()  {
        return frequencyOfWatering;
    }


    //next watering date, based on the frequency of watering.
    public LocalDate getNextWateringDate() throws PlantException {

        if (watering.isBefore(planted)) {
            throw new PlantException("The last day of watering must not be older than the plant was planted. Provided date of watering: " + watering);
        }
        return watering.plusDays(frequencyOfWatering);
    }


    public String getWateringInfo() throws PlantException {

        //capture values and provide default values for null
        String name = getName() != null ? getName() : "null name provided";
        String wateringDate = getWatering() != null ? getWatering().toString() : "No watering date provided";
        String notes = getNotes() != null ? getNotes() : "";

        return "Name of plant: " + getName() + "\n"
                + "Date of the last watering: " + getWatering().toString() + "\n"
                + "Frequency of watering: " + getFrequencyOfWatering() + "\n"
                + "Date of recommended next watering of plant: " + getNextWateringDate().toString() + "\n"
                + "Notes: " + getNotes();
    }

}
