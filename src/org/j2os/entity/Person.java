package org.j2os.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person")
@Table(name = "person")
public class Person {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_fk")
    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public Person setCarList(List<Car> carList) {
        this.carList = carList;
        return this;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
