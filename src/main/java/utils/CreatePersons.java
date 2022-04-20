package utils;

import entities.Person;
import entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CreatePersons {
    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Person Karsten = new Person("Karsten", "tester");
        Person Leif = new Person("Leif", "test");

        em.getTransaction().begin();
        Role o18Role = new Role("over18");
        Role u18Role = new Role("under18");
        Karsten.addRole(o18Role);
        Leif.addRole(u18Role);
        em.persist(o18Role);
        em.persist(u18Role);
        em.persist(Karsten);
        em.persist(Leif);
        em.getTransaction().commit();
    }
}
