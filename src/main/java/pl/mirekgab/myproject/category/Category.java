package pl.mirekgab.myproject.category;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name="categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
}
