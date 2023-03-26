package com.example.demo.Entitys;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Setter(AccessLevel.NONE)
    private Integer idsp;
    private String description;
    private Date startDate;

   @ManyToOne
    private Project project;
}
