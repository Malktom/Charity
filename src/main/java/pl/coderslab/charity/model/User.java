package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
    private String password;
//    @ElementCollection
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
//    @Transient
//    private Set<String> roles = Set.of("USER");

//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//        this.roles = Set.of("USER");
//    }


}
