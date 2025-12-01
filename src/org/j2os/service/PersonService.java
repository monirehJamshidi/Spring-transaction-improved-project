package org.j2os.service;

import org.j2os.entity.Person;
import org.j2os.exception.CustomizeException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Service
@Scope("prototype")
public class PersonService {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)//Note: Dont use @Autowire
    private EntityManager entityManager;

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    public List<Person> findAll() {
        return entityManager.createQuery("select p from person p", Person.class).getResultList();
    }
}
