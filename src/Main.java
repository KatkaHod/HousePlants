import indoorPlants.ListOfPlants;
import indoorPlants.PlantException;
import indoorPlants.Settings;

import indoorPlants.ListOfPlants;
import indoorPlants.ListOfPlants.*;


public class Main {
    public static void main(String[] args) {

        String fileName = Settings.getFilename();
        System.out.println(Settings.getFilename());


        //load the kvetiny.txt file
        ListOfPlants listOfPlants = new ListOfPlants();
        try{
            listOfPlants.loadContentFromFile(fileName);
        } catch (PlantException e) {
            System.err.println(
                    "error when reading from file: " + Settings.getFilename() + ":\n "
                            + e.getLocalizedMessage()+"\n");
        }

        //print the copy of the list
        System.out.println("\nList of plants: " + listOfPlants.getPlantsList() + "\n");

        //add new two plants






    }
}
