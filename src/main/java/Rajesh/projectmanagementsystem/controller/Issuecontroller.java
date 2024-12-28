package Rajesh.projectmanagementsystem.controller;

import Rajesh.projectmanagementsystem.DTO.IssueDTO;
import Rajesh.projectmanagementsystem.model.Issue;
import Rajesh.projectmanagementsystem.model.User;
import Rajesh.projectmanagementsystem.request.IssueRequest;
import Rajesh.projectmanagementsystem.response.AuthResponse;
import Rajesh.projectmanagementsystem.response.MessageResponse;
import Rajesh.projectmanagementsystem.service.IssueService;
import Rajesh.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class Issuecontroller {

    @Autowired
    private IssueService issueService;

    @Autowired
    private UserService userService;

    @GetMapping("/{issueId}")
    public ResponseEntity<Issue>getIssueByID(@PathVariable Long issueId) throws Exception{
        return ResponseEntity.ok(issueService.getIssueById(issueId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Issue>> getIssueByProjectId(@PathVariable Long projectId) throws Exception{
        return ResponseEntity.ok(issueService.getIssueByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<IssueDTO>createIssue(@RequestBody IssueRequest issue,
                                               @RequestHeader("Authorization") String token) throws Exception{
        System.out.println("issue-------" + issue);
        User tokenUser = userService.findUserProfileByJwt(token);
        User user = userService.findUserById(tokenUser.getId());

        Issue createdIssue = issueService.createIssue(issue, tokenUser);
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setDescription(createdIssue.getDescription());
        issueDTO.setDueDate(createdIssue.getDueDate());
        issueDTO.setId(createdIssue.getId());
        issueDTO.setPriority(createdIssue.getPriority());
        issueDTO.setProject(createdIssue.getProject());
        issueDTO.setProjectID(createdIssue.getProjectId());
        issueDTO.setStatus(createdIssue.getStatus());
        issueDTO.setTitle(createdIssue.getTitle());
        issueDTO.setTags(createdIssue.getTags());
        issueDTO.setAssignee(createdIssue.getAssignee());
        return ResponseEntity.ok(issueDTO);

    }

    @DeleteMapping("/{issueId}")
    public ResponseEntity<MessageResponse> deleteIssue(@PathVariable Long issueId,
                                                    @RequestHeader("Authorization") String token) throws Exception{
        User user = userService.findUserProfileByJwt(token);
        issueService.deleteIssue(issueId, user.getId());
        MessageResponse res = new MessageResponse();
        res.setMessage("Issue Deleted");
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{issueId}/assignee/{userId}")
    public ResponseEntity<Issue> addUserToIssue(@PathVariable Long issueId, @PathVariable Long userId) throws Exception{
        Issue issue = issueService.addUserToIssue(issueId, userId);
        return ResponseEntity.ok(issue);
    }

    @GetMapping("/assignee/{assigneeId}")
    public ResponseEntity<List<Issue>> getIssuesByAssigneeId(@PathVariable Long assigneeId) throws Exception{
        List<Issue> issues = issueService.getIssueByProjectId(assigneeId);
        return ResponseEntity.ok(issues);
    }

    @PutMapping("/{issueId}/status/{status}")
    public ResponseEntity<Issue> updateIssueStatus(@PathVariable String status, @PathVariable Long issueId) throws Exception{
        Issue issue = issueService.updateStatus(issueId, status);
        return ResponseEntity.ok(issue);
    }


}
