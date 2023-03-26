package com.example.demo.Service;

import com.example.demo.Entitys.Project;

import java.util.List;

public interface ProjetService {
     void addProject(Project project);
     void assignProjectToUser (int projectId, int userId);
     void assignProjectToClient(int projectId, String firstName, String lastName);
     List<Project> getAllCurrentProject() ;
     public List<Project> getProjectsByScrumMaster(String fName, String lName);
}
