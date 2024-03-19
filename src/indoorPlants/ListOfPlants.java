package indoorPlants;

import java.util.ArrayList;
import java.util.List;
import java.io.*; //reading from the file
import java.io.PrintWriter;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class ListOfPlants {

    //atribut - provided value - Class Plant
    private List<Plant> plantsList = new ArrayList<>();


    //load from txt. file
    public void ReadContentFromFile(String fileName) throws PlantException {
        int lineCounter = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(Settings.getDelimiter());
                if (parts.length != 5) throw new PlantException("Incorrect count of items on line number:  " + lineCounter + ": "+line+"!");

                String name = parts[0];
                String notes = parts[1];
                int frequencyOfWatering = Integer.parseInt(parts[2]);










            }




        }



    }
















    //add a plant to the list
    public void addPlant(Plant newPlant) {
        plantsList.add(newPlant);
    }

    //Add multiple plants at once
    public void addPlants(List<Plant> plants){
        this.plantsList.addAll(plants);
    }

    //get a plant through the index
    public Plant getPlantViaIndex(int index) {
        if (index >= 0 && index < plantsList.size()) {
            return plantsList.get(index);
        } else {
            throw new IllegalArgumentException("Invalid index. Provided index: " + index);
        }
    }

    //method for removing a specific plant list by index
    public void removePlantViaIndex(int index) {
        if (index >= 0 && index < plantsList.size()) {
            plantsList.remove(index);
        } else {
            System.err.println("Invalid plant list index.");
        }
    }


    


























}
