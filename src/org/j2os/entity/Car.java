package org.j2os.entity;

import javax.persistence.*;

@Entity(name = "car")
@Table(name = "car")
public class Car {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String model;

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public long getId() {
        return id;
    }

    public Car setId(long id) {
        this.id = id;
        return this;
    }
}
