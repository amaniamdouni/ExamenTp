package com.example.demo.Repository;

import com.example.demo.Entitys.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
}
