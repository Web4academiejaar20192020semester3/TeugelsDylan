package domain;

import db.ChatRepository;
import db.ChatRepositoryStub;

import java.util.ArrayList;

public class ChatService {
    private ChatRepository chatRepository = new ChatRepositoryStub();

    public ChatService(){}

    public void addChat(Chat c){ getChatRepository().add(c); }

    public ArrayList<Chat> getAllChats(){
        return getChatRepository().getAll();
    }

    public Chat getChat(Person person1, Person person2) {
        if(getChatRepository().getChat(person1, person2) != null) {
            return getChatRepository().getChat(person1, person2);
        }
        else if (getChatRepository().getChat(person2, person1) != null) {
            return getChatRepository().getChat(person2, person1);
        }
        else{
            Chat chat = new Chat(person1, person2);
            getChatRepository().add(chat);
            return chat;
        }
    };

    private ChatRepository getChatRepository(){
        return chatRepository;
    }
}
