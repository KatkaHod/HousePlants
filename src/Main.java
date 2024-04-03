import indoorPlants.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import indoorPlants.ListOfPlants;

public class Main {
    public static void main(String[] args) throws PlantException {

        //file settings
        String fileName = Settings.getFileName();
        String fileNameOut = Settings.getFileNameOut();


        //Load from the file 'kvetiny.txt
        ListOfPlants listOfPlants = new ListOfPlants();
        try {
            listOfPlants.loadContentFromFile(fileName);
        } catch (PlantException e) {
            System.err.println(
                    "error when reading from file: " + Settings.getFileName() + ":\n "
                            + e.getLocalizedMessage()+"\n");
        }


        System.out.println("1. return listOfPLants based on kvetiny.txt");
        System.out.println("\nList of plants: " + listOfPlants.getPlantsList() + "\n");


        //add new two plants - Bromelie and bazalka into listOfPlants
        listOfPlants.addPlant(new Plant("Bromelie", "Tropical plant",7, LocalDate.of(2023,3,31), LocalDate.of(2023,3,31)));
        listOfPlants.addPlant(new Plant("Bazalka","v kuchyni",3, LocalDate.of(2021,9,4), LocalDate.of(2021,9,4)));


        System.out.println("2. Two new plants - Bromelie and Bazalka have been added into list.");
        System.out.println("\nList of plants: " + listOfPlants.getPlantsList() + "\n");


        System.out.println("3. return plant via index 2");
        System.out.println(listOfPlants.getPlantViaIndex(2));


        //remove plant via index
        try {
        listOfPlants.removePlantViaIndex(2);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Plant can not be removed.\n" + e.getLocalizedMessage());
        }

        System.out.println("4. return the listOfPlants after deleting the plant at index 2.");
        System.out.println("\nList of plants: " + listOfPlants.getPlantsList() + "\n");


        //save corrected list to new the file - 'kvetinyOutput.txt'
        listOfPlants.saveContentToFile(fileNameOut);


        System.out.println("5. return the new list of plants from the kvetinyOutput.txt");
        //Load from the file 'kvetinyOutput.txt

        ListOfPlants kvetinyOutput = new ListOfPlants();
        try {
            kvetinyOutput.loadContentFromFile(fileNameOut);
        } catch (PlantException e) {
            System.err.println(
                    "error when reading from file: " + Settings.getFileNameOut() + ":\n "
                            + e.getLocalizedMessage()+"\n");
        }

        System.out.println("\n List of plants output: " + kvetinyOutput.getPlantsList() + "\n");



        /* --sorting of plants--
         the sort() method in the Collections class is used to sort the items in the collection.
         -> Collections.sort
        */

        //get list of plants from kvetinyOutput
        List<Plant> plantsList = kvetinyOutput.getPlantsList();

        //sort the list of plants by name
        Collections.sort(plantsList, Comparator.comparing(Plant::getName));

        System.out.println("\n list of plants sorted by name: " + plantsList + "\n");








    }
}
