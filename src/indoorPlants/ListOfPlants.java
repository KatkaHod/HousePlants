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


    //load /read from the text file
















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
