package Rajesh.projectmanagementsystem.repository;

import Rajesh.projectmanagementsystem.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
