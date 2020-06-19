package ro.unibuc.fmi;

import ro.unibuc.fmi.exception.PersonNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private List<Person> persons = new ArrayList<>();

    public void readPersonsFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("persistence.txt"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Person person = new Person(dataFields[0], Integer.parseInt(dataFields[1]));
                addPerson(person);
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + persons.size() + " persons!");
    }

    public void writePersonsToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("persistence.txt"))) {
            for (Person person : persons) {
                bufferedWriter.write(person.getName() + "," + person.getAge());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully wrote " + persons.size() + " persons!");
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person getPersonByName(String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        throw new PersonNotFoundException("Could not find person: " + name);
    }
}
