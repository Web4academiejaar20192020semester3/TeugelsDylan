package db;

import domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonRepositoryStub() {
		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", "man", "18");
		add(administrator);
		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", "vrouw", "19");
		add(jan);
		Person dylan = new Person("dylan@ucll.be", "t", "Dylan", "Teugels", "man", "20");
		add(dylan);
		Person jonas = new Person("jonas@ucll.be", "t", "Jonas", "De Roover", "man", "21");
		add(jonas);
		friends(dylan, jonas);
	}
	
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);
		
		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}

	public void friends(Person x, Person y){
		if(!x.getFriends().contains(y)){
			x.addFriend(y);
		}
		if(!y.getFriends().contains(x)){
			y.addFriend(x);
		}
	}
}
