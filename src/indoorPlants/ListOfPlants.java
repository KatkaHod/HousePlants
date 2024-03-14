package indoorPlants;

import java.util.ArrayList;
import java.util.List;
import java.io.*; //reading from the file


public class ListOfPlants {

    private List<Plant> plantsList = new ArrayList<>();


    //export list of plant to file
    public void exportToFile(String newFileListOfPlants) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(newFileListOfPlants))) {
            outputStream.writeObject(this);
            System.out.println("The plant list has been successfully exported to a file.");
        } catch (IOException e) {
            System.err.println("Error exporting to file:  " + e.getMessage());
        }
    }


    public static ListOfPlants importFromFile(String plants) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(plants))) {
            ListOfPlants plantList = (ListOfPlants) inputStream.readObject();
            System.out.println("The plant list has been successfully read from the file.");
            return plantList;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading from file: " + e.getMessage());
            return null;
        }
    }


    //add a plant to the list
    public void addPlant(Plant newPlant) {
        plantsList.add(newPlant);
    }








}
