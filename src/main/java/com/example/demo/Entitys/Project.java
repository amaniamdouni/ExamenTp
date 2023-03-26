package com.example.demo.Entitys;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Setter(AccessLevel.NONE)
    private Integer idp;
    private String title;
    private String decription;

    @ManyToMany(mappedBy = "projects")
    private List<User> users;

    @ManyToOne
    private User user;

    @OneToMany (mappedBy = "project",cascade = CascadeType.PERSIST )
    private List<Sprint> sprints;
}
