package com.example.demo.Repository;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Project,Integer> {
    List<Project> findBySprintsStartDateAfter(LocalDate thisDay);
    List<Project> findallByUserRoleAndUserFirstnameUserLastname(Role role, String firstname, String lastname);
}
