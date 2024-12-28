package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.model.Chat;
import Rajesh.projectmanagementsystem.model.Message;
import Rajesh.projectmanagementsystem.model.Project;
import Rajesh.projectmanagementsystem.model.User;
import Rajesh.projectmanagementsystem.repository.MessageRepository;
import Rajesh.projectmanagementsystem.repository.ProjectRepository;
import Rajesh.projectmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;

import java.time.LocalDateTime;
import java.util.List;

public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectService projectService;

    @Override
    public Message sendMessage(Long SenderId, Long projectId, String content) throws Exception {
        User sender = userRepository.findById(SenderId)
                .orElseThrow(()->new Exception("User not found with id: " + SenderId));
        Chat chat = projectService.getProjectById(projectId).getChat();

        Message message = new Message();
        message.setContent(content);
        message.setSender(sender);
        message.setCreatedAt(LocalDateTime.now());
        message.setChat(chat);
        Message savedMessage = messageRepository.save(message);
        chat.getMessages().add(savedMessage);
        return savedMessage;
    }

    @Override
    public List<Message> getMessagesByProjectId(Long projectId) throws Exception {
        Chat chat = projectService.getChatByProjectId(projectId);
        List<Message> findByChatIdOrderByCreatedAtAsc = messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId());
        return findByChatIdOrderByCreatedAtAsc;
    }


}
