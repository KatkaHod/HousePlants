package indoorPlants;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ListOfPlants {

    //Attribute list of 'Plant'
    private List<Plant> plantsList = new ArrayList<>();


    //load from txt. file
    public void loadContentFromFile(String fileName) throws PlantException {
        int lineCounter = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //Split the loaded line into parts according to the separator
                String[] parts = line.split(Settings.getDelimiter());
                if (parts.length != 5) throw new PlantException("Incorrect count of items on line number:  " + lineCounter + ": "+line+"!");

                //parses the individual parts of the row to the appropriate data types
                String name = parts[0];
                String notes = parts[1];
                int frequencyOfWatering = Integer.parseInt(parts[2]);
                LocalDate watering = LocalDate.parse(parts[3]);
                LocalDate planted = LocalDate.parse(parts[4]);

                //Creates a new Plant object with the loaded data and add the created Plant object to the 'plantsList'
                Plant plant = new Plant(name, notes,planted,watering,frequencyOfWatering);
                plantsList.add(plant);
            }//end of while

        } catch (FileNotFoundException e) {
            throw new PlantException("File "+fileName+" not found!\n"+ e.getLocalizedMessage());
        }
        catch (NumberFormatException e) {
            throw new PlantException("Error when reading a numeric value on line number: "+lineCounter+":\n"
                    + e.getLocalizedMessage());
        }
        catch (DateTimeParseException e) {
            throw new PlantException("Error reading date on line number: "+ lineCounter +":\n"
                    + e.getLocalizedMessage());
        }

    }//end of method



    //save content to txt. file
    public void saveContentToFile(String fileName) throws PlantException {
        String delimiter = Settings.getDelimiter();
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {

            //Scrolls through the plant list and makes an entry in the file for each plant in the list.
            for (Plant plant : plantsList) {
                //Writes data about one plant on one line of the file. The individual data are separated by a separator. For example tab - \t or ; or :
                writer.println(plant.getName() + delimiter
                        + plant.getNotes() + delimiter
                        + plant.getPlanted() + delimiter
                        + plant.getWatering() + delimiter
                        + plant.getFrequencyOfWatering() + delimiter);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("File "+fileName+" not found!\n" + e.getLocalizedMessage());

        } catch (IOException e) {
            throw new PlantException("Output error when writing to file: "+fileName +":\n"+ e.getLocalizedMessage());
        }

    }



    //==================Other methods=================================================


    //return new array list (copy)
    public List<Plant> getPlantsList() {
        return new ArrayList<>(plantsList);
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



}//end of the class
