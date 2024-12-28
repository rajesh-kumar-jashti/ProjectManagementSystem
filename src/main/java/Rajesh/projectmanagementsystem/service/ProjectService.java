package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.model.Chat;
import Rajesh.projectmanagementsystem.model.Project;
import Rajesh.projectmanagementsystem.model.User;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project, User user) throws Exception;

    List<Project> getProjectByTeam(User user, String category, String tag) throws Exception;

    Project getProjectById(Long projectId) throws Exception;

    void deleteProject(Long ProjectId, Long UserId)throws  Exception;

    Project updateProject(Project updatedProject, Long Id)throws Exception;

    void addUserToProject(Long projectId, Long UserId) throws Exception;

    void removeUserToProject(Long projectId, Long UserId) throws Exception;

    Chat getChatByProjectId(Long projectId) throws Exception;

    List<Project> searchProjects(String keyword, User user) throws Exception;
}
