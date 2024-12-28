package Rajesh.projectmanagementsystem.repository;

import Rajesh.projectmanagementsystem.model.Comment;
import Rajesh.projectmanagementsystem.service.CommentServiceimpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
    List<Comment> findByIssueId(Long issueId);
}
