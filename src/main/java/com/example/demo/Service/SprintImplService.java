package com.example.demo.Service;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.Sprint;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.SprintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintImplService implements SprintService {
    private final ProjetRepository projetRepository;
    private final SprintRepository sprintRepository;


    @Override
    @Transactional
    public void addSprintAndAssignToProject(Sprint sprint, int idProject)
    {
        Project project = projetRepository.findById(idProject).orElse(null);
        Assert.notNull(project, "Project must not be null");
        sprintRepository.saveAndFlush(sprint);
        List<Sprint> sprints = new ArrayList<>();
        sprints.add(sprint);
        project.setSprints(sprints);
        projetRepository.save(project);
    }
}
