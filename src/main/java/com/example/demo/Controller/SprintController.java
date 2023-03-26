package com.example.demo.Controller;

import com.example.demo.Entitys.Sprint;
import com.example.demo.Service.SprintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sprints")
@RequiredArgsConstructor
public class SprintController {

    private final SprintService sprintService;
    @PostMapping("/addSprintToProj")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable int idProject){
        sprintService.addSprintAndAssignToProject(sprint,idProject);
    }
}
