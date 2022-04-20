package utils;


import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    User Karsten = new User("Karsten", "over18");
    User Leif = new User("Leif", "under18");
    User both = new User("user_admin", "test");

    if(Karsten.getUserPass().equals("test")||Leif.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role adultRole = new Role("admin");
    Role childRole = new Role("user");
    Karsten.addRole(adultRole);
    Leif.addRole(childRole);
    both.addRole(adultRole);
    both.addRole(childRole);
    em.persist(adultRole);
    em.persist(childRole);
    em.persist(Karsten);
    em.persist(Leif);
    em.persist(both);
    em.getTransaction().commit();
   /* System.out.println("PW: " + .getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");*/
   
  }

}
