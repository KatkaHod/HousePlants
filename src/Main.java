import indoorPlants.*;

import java.time.LocalDate;
import indoorPlants.ListOfPlants;
import indoorPlants.ListOfPlants.*;


public class Main {
    public static void main(String[] args) {

        String fileName = Settings.getFilename();



        //load the kvetiny.txt file
        ListOfPlants listOfPlants = new ListOfPlants();
        try{
            listOfPlants.loadContentFromFile(fileName);
        } catch (PlantException e) {
            System.err.println(
                    "error when reading from file: " + Settings.getFilename() + ":\n "
                            + e.getLocalizedMessage()+"\n");
        }


        System.out.println("Load from the file 'kvetiny.txt'");
        System.out.println("\nList of plants: " + listOfPlants.getPlantsList() + "\n");

        System.out.println("add new two plants - Bromelie and bazalka into listOfPlants");
        listOfPlants.addPlant(new Plant("Bromelie", "Tropical plant", LocalDate.of(2023,3,31), LocalDate.of(2023,3,31), 7));
        listOfPlants.addPlant(new Plant("Bazalka","v kuchyni", LocalDate.of(2021,9,4), LocalDate.of(2021,9,4),3));

        System.out.println("return to listOfPlants and check that two new plants have been added.");
        System.out.println("\nList of plants: " + listOfPlants.getPlantsList() + "\n");

        System.out.println("return plant via index");
        System.out.println(listOfPlants.getPlantViaIndex(2));

        System.out.println("remove plant via index. Index: 2");

        try {
        listOfPlants.removePlantViaIndex(2);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Plant can not be removed.\n" + e.getLocalizedMessage());
        }



    }
}
