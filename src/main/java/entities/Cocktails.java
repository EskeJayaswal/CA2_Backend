package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cocktails")
@NamedQuery(name="Cocktails.deleteAllRows", query = "DELETE from Cocktails")
public class Cocktails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="ingredient1")
    private String ingredient1;

    @Column(name="ingredient2")
    private String ingredient2;

    @Column(name="ingredient3")
    private String ingredient3;

    @ManyToMany(mappedBy="cocktailsList")
    private List<Person> personList = new ArrayList<>();

    public Cocktails() {
    }

    public Cocktails(String ingredient1, String ingredient2, String ingredient3) {
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktails cocktails = (Cocktails) o;
        return Objects.equals(id, cocktails.id) && Objects.equals(ingredient1, cocktails.ingredient1) && Objects.equals(ingredient2, cocktails.ingredient2) && Objects.equals(ingredient3, cocktails.ingredient3) && Objects.equals(personList, cocktails.personList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient1, ingredient2, ingredient3, personList);
    }

    @Override
    public String toString() {
        return "Cocktails{" +
                "id=" + id +
                ", ingredient1='" + ingredient1 + '\'' +
                ", ingredient2='" + ingredient2 + '\'' +
                ", ingredient3='" + ingredient3 + '\'' +
                ", personList=" + personList +
                '}';
    }
}
