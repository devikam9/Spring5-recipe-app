package guru.springframework.spring5_recipe_app.domain;


import jakarta.persistence.*;

import lombok.*;

import java.util.Set;


@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uom")
    private Set<Ingredient> ingredients;

}
