package Rajesh.projectmanagementsystem.service;


import Rajesh.projectmanagementsystem.model.Issue;
import Rajesh.projectmanagementsystem.model.Project;
import Rajesh.projectmanagementsystem.model.User;
import Rajesh.projectmanagementsystem.repository.IssueRepository;
import Rajesh.projectmanagementsystem.request.IssueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Override
    public Issue getIssueById(Long IssueId) throws Exception {
        Optional<Issue> issue = issueRepository.findById(IssueId);
        if(issue.isPresent()){
            return issue.get();
        }
        throw new Exception("No issues Found with IssueID" + IssueId);
    }

    @Override
    public List<Issue> getIssueByProjectId(Long ProjectId) throws Exception {
        return issueRepository.findByProjectID(ProjectId);
    }

    @Override
    public Issue createIssue(IssueRequest issueRequest, User user) throws Exception {
        Project project = projectService.getProjectById(issueRequest.getProjectId());

        Issue issue = new Issue();
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setStatus(issueRequest.getStatus());
        issue.setProjectID(issueRequest.getProjectId());
        issue.setPriority(issueRequest.getPriority());
        issue.setDueDate(issueRequest.getDueDate());
        issue.setProject(project);
        return issueRepository.save(issue);
    }

    @Override
    public Optional<Issue> updateIssue(Long issueId, IssueRequest updateIssue, Long UserId) throws Exception {
        return Optional.empty();
    }

    @Override
    public void deleteIssue(Long issueId, Long userId) throws Exception {
        getIssueById(issueId);
        issueRepository.deleteById(issueId);
    }

    @Override
    public Issue addUserToIssue(Long issueId, Long userId) throws Exception {
        User user = userService.findUserById(userId);
        Issue issue = getIssueById(issueId);
        issue.setAssignee(user);
        return issueRepository.save(issue);
    }

    @Override
    public Issue updateStatus(Long issueId, String status) throws Exception {
        Issue issue = getIssueById(issueId);
        issue.setStatus(status);
        return issueRepository.save(issue);
    }
}
