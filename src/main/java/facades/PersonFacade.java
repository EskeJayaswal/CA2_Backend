package facades;

import entities.Person;
import security.errorhandling.AuthenticationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonFacade {

    private static EntityManagerFactory emf;
    private static PersonFacade instance;

    private PersonFacade() {
    }

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    public Person getVeryfiedPerson(String name, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        Person person;
        try {
            person = em.find(Person.class, name);
            if (person == null || !person.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }

        } finally {
            em.close();
        }
        return person;
    }
}
