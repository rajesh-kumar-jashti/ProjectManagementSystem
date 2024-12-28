package Rajesh.projectmanagementsystem.service;

import Rajesh.projectmanagementsystem.model.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Long SenderId, Long projectId, String content) throws Exception;

    List<Message> getMessagesByProjectId(Long projectId) throws Exception;
}
