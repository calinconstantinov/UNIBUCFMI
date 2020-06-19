package ro.unibuc.fmi;

import ro.unibuc.fmi.exception.PersonNotFoundException;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        readFromFile();
        writeToFile();

        PersonService personService = new PersonService();
        personService.readPersonsFromFile();

        try {
            Person person = personService.getPersonByName("calin");
            System.out.println("Found person: " + person.getName());
        } catch (PersonNotFoundException e) {
            System.out.println("Not found!");
        }

        Person person = new Person("ionel", 40);
        personService.addPerson(person);

        personService.writePersonsToFile();
    }

    public static void readFromFile() throws IOException {
        InputStreamReader inputStreamReader = new FileReader("read.txt");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println("Read line: " + currentLine);
        }
        //not closed in case of exception
        bufferedReader.close();
    }

    public static void writeToFile() {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter = null;
        try {
            outputStreamWriter = new FileWriter("write.txt");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("line 1");
            bufferedWriter.newLine();
            bufferedWriter.write("line 2");
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Could not even close: " + e.getMessage());
                }
            }
        }
    }
}
