package org.example;

import org.example.dao.PersonDao;
import org.example.interfaces.Dao;
import org.example.models.Person;
import org.example.servises.FileWorker;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        task(new Person(1, "Jonny", 47));

        Dao<Person> dao = new PersonDao();

        dao.index().forEach(System.out::println);

        System.out.println("- - - - - - - - - - - - - - - -");

        System.out.println(dao.show(4));
    }

    /**
     * Реализуйте сериализацию и десериализацию этого класса в файл
     *
     * @param person
     */
    private static void task(Person person) {
        String path = "" +
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "db.json";

        FileWorker.serializeObject(person, path);
        System.out.println(FileWorker.deserializeObject(path, Person.class));
    }
}