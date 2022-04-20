package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;

@Path("info")
public class PersonResource {


    public static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allPersons() {
        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery ("SELECT p from Person p", entities.Person.class);
            List<Person> persons = query.getResultList();
            return "[" + persons.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("under18")
    @RolesAllowed("under18")
    public String getFromU18() {
        String thisPerson = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello kid: " + thisPerson + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("over18")
    @RolesAllowed("over18")
    public String getFromO18() throws IOException {
        //String thisPerson = securityContext.getUserPrincipal().getName();
        String name = FACADE.getCocktailNames();
        return name;
    }
}
