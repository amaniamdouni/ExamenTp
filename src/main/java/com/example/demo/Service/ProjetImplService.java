package com.example.demo.Service;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.Role;
import com.example.demo.Entitys.User;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.SprintRepository;
import com.example.demo.Repository.UserRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetImplService implements ProjetService {

    private final ProjetRepository projetRepository;
    private final UserRepositroy userRepositroy;
    private final SprintRepository sprintRepository;


    @Override
    public void addProject(Project project) {
        projetRepository.save(project);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projetRepository.findById(projectId).orElse(null);
        User user = userRepositroy.findById(userId).orElse(null);
        Assert.notNull(project,"project must be null");
        Assert.notNull(user,"user must be null");
        List<User> users = new ArrayList<>();
        project.getUser();
        users.add(user);
        projetRepository.save(project);
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Project project=projetRepository.findById(projectId).orElse(null);
        User user=userRepositroy.findByNomPrenom(firstName,lastName);
        if (user!=null && user.getRole().equals("CLIENT"))
        {
           project.setUser(user);
           projetRepository.save(project);
        }
    }

    @Override
    public List<Project> getAllCurrentProject() {
        LocalDate thisDay = LocalDate.now();
        List<Project> projects=projetRepository.findBySprintsStartDateAfter(thisDay);
        return projects;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String firstname, String lastname) {
        return projetRepository.findallByUserRoleAndUserFirstnameUserLastname(Role.SCRUM_MASTER,firstname,lastname);
    }

}
