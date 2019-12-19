package db;

import domain.Chat;
import domain.Person;

import java.util.ArrayList;

public interface ChatRepository {

    void add(Chat c);

    ArrayList<Chat> getAll();

    Chat getChat(Person p1, Person p2);
}