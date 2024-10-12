package guru.springframework.spring5_recipe_app.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
//    @EqualsAndHashCode.Exclude // Exclude from hashCode and equals
    private Recipe recipe;

    // @Lob - to add very large characters more than 255 characters
    @Lob
    private String recipeNotes;

}
