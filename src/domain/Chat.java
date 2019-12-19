package domain;

import java.util.ArrayList;

public class Chat {

    private ArrayList<Person> members = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();

    public Chat() {
    }

    public Chat(Person member1, Person member2){
        addMember(member1);
        addMember(member2);
        System.out.println("chat aangemaakt");
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public void addMember(Person person){
        this.members.add(person);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessage(Message message) {
        this.messages.add(message);
    }

    public String toString(){
        return "CHAT --- " + members.get(0).getFirstName() + " & " + members.get(1).getFirstName();
    }


}

