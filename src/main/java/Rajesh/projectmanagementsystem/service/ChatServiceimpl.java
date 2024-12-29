package Rajesh.projectmanagementsystem.service;


import Rajesh.projectmanagementsystem.model.Chat;
import Rajesh.projectmanagementsystem.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceimpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }
}
