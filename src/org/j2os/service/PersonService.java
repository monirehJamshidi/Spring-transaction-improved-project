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

    @Transactional
    public void update(Person person){
        entityManager.merge(person);
    }

    @Transactional
    public void remove(Person person){
        entityManager.remove(entityManager.merge(person));
    }

    public Person findById(Long id){
        return entityManager.find(Person.class, id);
    }

    @Transactional
    public void manyJobInSingleMethod(Person person1, Person person2){
        entityManager.persist(person1);
        entityManager.persist(person2);
    }

    @Transactional(rollbackFor = Exception.class)
    public void forceRollbackMethod(Person person) throws Exception{
        entityManager.persist(person);
        throw new Exception("Force!!!");
    }

    @Transactional(rollbackFor = CustomizeException.class)
    public void facadeMethod(Person person) throws Exception, CustomizeException {
        subMethodForFacadeMethod1();
        try {
            subMethodForFacadeMethod2();
        } catch (CustomizeException e) {
            throw e;
        }
    }
    public void subMethodForFacadeMethod1() throws Exception {
        System.out.println("subMethodForFacadeMethod1 ...");
    }

    public void subMethodForFacadeMethod2() throws Exception, CustomizeException {
        System.out.println("subMethodForFacadeMethod2 ...");
        throw new CustomizeException();
    }
}
