package org.j2os;

import org.j2os.common.Spring;
import org.j2os.entity.Car;
import org.j2os.entity.Person;
import org.j2os.service.PersonService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        PersonService service = (PersonService) Spring.getBean("personService");

//        Person person1 = new Person().setName("amirsam").setCarList(Arrays.asList(new Car().setModel("PRIDE"), new Car().setModel("PEYKAN")));
//        Person person2 = new Person().setName("hasan").setCarList(Arrays.asList(new Car().setModel("S500"), new Car().setModel("207")));
//
//        service.save(person1);
//        service.save(person2);

        List<Person> personList = service.findAll();
        for (Person person : personList) {
            System.out.println(person.getName());
            for (Car car : person.getCarList()) {
                System.out.println(car.getModel());
            }
        }

    }
}
