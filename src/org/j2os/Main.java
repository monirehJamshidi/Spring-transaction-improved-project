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
//        Person person = Person.builder().name("Monirehhhhhhh").family("Jamshidiiiiiiii").build();
//        service.save(person);

//        Person person1 = Person.builder().name("Monireh1").family("Jamshidi1").build();
//        Person person2 = Person.builder().name("Monireh123456789987654321123456").family("Jamshidi1").build();
//        service.manyJobInSingleMethod(person1,person2);


//        service.forceRollbackMethod(Person.builder().name("monireh").family("jamshidi").build());

        //************************
//        Person person1 = Person.builder()
//                .name("Monireh")
//                .family("Jamshidi")
//                .carList(Arrays.asList(
//                        Car.builder().model("BMW").build(),
//                        Car.builder().model("TOYUTA").build()
//                ))
//                .build();
//        Person person2 = Person.builder()
//                .name("Mahdieh")
//                .family("Jamshidi")
//                .carList(Arrays.asList(
//                        Car.builder().model("BENZ").build(),
//                        Car.builder().model("HUNDAI").build()
//                ))
//                .build();

//        //save
//        service.save(person1);
//        service.save(person2);

        //receive und print
        List<Person> personList = service.findAll();
        for (Person person : personList) {
            System.out.println(person.getName());
            for (Car car : person.getCarList()) {
                System.out.println(car.getModel());
            }
        }

    }
}
