package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.model.Issue;
import Rajesh.projectmanagementsystem.model.User;
import Rajesh.projectmanagementsystem.request.IssueRequest;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.Optional;


public interface IssueService {

    Issue getIssueById(Long IssueId) throws Exception;

    List<Issue> getIssueByProjectId(Long ProjectId) throws Exception;

    Issue createIssue(IssueRequest issue, User user) throws Exception;

    Optional<Issue> updateIssue(Long issueId, IssueRequest updateIssue, Long UserId) throws Exception;

    void deleteIssue(Long issueId, Long userId) throws Exception;

    Issue addUserToIssue(Long issueId, Long userId) throws  Exception;

    Issue updateStatus(Long issueId, String status) throws Exception;
}
