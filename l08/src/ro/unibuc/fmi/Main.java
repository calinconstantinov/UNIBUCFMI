package ro.unibuc.fmi;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Person1", 23);
        Person person2 = new Person("Person2", 14);
        Person person3 = new Person("Person3", 24);
        Person person4 = new Person("Person4", 17);
        Person person5 = new Person("Person5", 30);
        Person person6 = new Person("Person6", 12);
        Person person7 = new Person("Person7", 8);
        Person person8 = new Person("Person8", 30);
        Person person9 = new Person("Person9", 24);
        Person person10 = new Person("Person10", 30);

        List<Person> persons = new ArrayList<>(List.of(person1, person2, person3, person4, person5,
                person6, person7, person8, person9, person10));

        persons.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
        System.out.println("");

        persons.forEach(person -> {
            System.out.println(person);
        });
        System.out.println("");

        persons.forEach(person -> System.out.println(person));
        System.out.println("");

        persons.forEach(System.out::println);
        System.out.println("");


        persons.stream()
                .filter(person -> person.getAge() >= 18)
                .forEach(person -> person.setUnderAged(false));
        persons.forEach(person -> System.out.println(person.getAge() + " " + person.getUnderAged()));
        System.out.println("");


        persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);


        persons.removeIf(Person::getUnderAged);
        persons.forEach(person -> System.out.println(person.getAge()));
        System.out.println("");


        List<Integer> integers = IntStream.range(1, 10)
                .boxed()
                .collect(Collectors.toList());
        integers.forEach(integer -> System.out.print(integer + " "));
        System.out.println("");


        System.out.println(IntStream.range(1, 20)
                .filter(integer -> integer % 5 == 0)
                .sum()
        );


        System.out.println(persons.stream()
                .mapToInt(Person::getAge)
                .sum()
        );

        System.out.println(persons.stream()
                .mapToInt(Person::getAge)
                .map(age -> ++age)
                .filter(increasedAge -> increasedAge % 2 == 0)
                .map(filteredAge -> filteredAge + 3)
                .sum()
        );


        Map<Integer, List<String>> ageToNames = new HashMap<>();
        persons.forEach(
                person -> ageToNames
                        .computeIfAbsent(person.getAge(), ArrayList::new)
                        .add(person.getName())
        );
        System.out.println(ageToNames);


        System.out.println(persons.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList()))
                )
        );
    }
}
