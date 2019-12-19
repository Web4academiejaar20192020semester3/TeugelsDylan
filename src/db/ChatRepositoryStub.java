package db;

import domain.Chat;
import domain.Message;
import domain.Person;
import domain.PersonService;

import java.util.ArrayList;

public class ChatRepositoryStub implements ChatRepository {
    private ArrayList<Chat> chats = new ArrayList<>();

    PersonService personService = new PersonService();

    public ChatRepositoryStub(){
        Person p1 = personService.getPerson("dylan@ucll.be");
        Person p2 = personService.getPerson("jonas@ucll.be");
        Chat c1 = new Chat(p1, p2);

        Message m1 = new Message(p1, "hey");
        Message m2 = new Message(p2, "hoi");
        Message m3 = new Message(p1, "alles goe?");
        Message m4 = new Message(p2, "ja, bolt hem maar af");
        Message m5 = new Message(p1, "ok");
        ArrayList<Message> messages = new ArrayList<>();

        c1.setMessage(m1);
        c1.setMessage(m2);
        c1.setMessage(m3);
        c1.setMessage(m4);
        c1.setMessage(m5);

        add(c1);
    }

    @Override
    public void add(Chat c) {
        chats.add(c);
    }

    @Override
    public ArrayList<Chat> getAll() {
        return chats;
    }

    @Override
    public Chat getChat(Person pers1, Person pers2) {
        String person1 = pers1.getUserId();
        String person2 = pers2.getUserId();

        for(Chat chat: getAll()){
            ArrayList<Person> members = chat.getMembers();

            if(members.get(0).getUserId().equals(person1)) {
                if(members.get(1).getUserId().equals(person2)) {
                    return chat;
                }
            }

            if(members.get(0).getUserId().equals(person2)) {
                if (members.get(1).getUserId().equals(person1)) {
                    return chat;
                }
            }
        }
        return null;
    }
}
