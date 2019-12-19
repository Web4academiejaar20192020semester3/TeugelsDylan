package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	private String userId;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private String salt;
	private String firstName;
	private String lastName;
	private String status;
	private String geslacht;
	private String leeftijd;
	@JsonIgnore
	private ArrayList<Person> friends;

	public Person(String userId, String password, String firstName,
				  String lastName,String geslacht, String leeftijd) {
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setStatus("Offline");
		setGeslacht(geslacht);
		setLeeftijd(leeftijd);
		friends = new ArrayList<>();

	}

	public Person(String userId, String password, String salt,
				  String firstName, String lastName, String geslacht, String leeftijd) {
		setUserId(userId);
		setPassword(password);
		setSalt(salt);
		setFirstName(firstName);
		setLastName(lastName);
		setStatus("Offline");
		setGeslacht(geslacht);
		setLeeftijd(leeftijd);
		friends = new ArrayList<>();
	}

	public Person() {
	}


	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Person> getFriends() {
		return friends;
	}

	private void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public String getGeslacht() { return geslacht; }

	private void setLeeftijd(String leeftijd) {
		this.leeftijd = leeftijd;
	}

	public String getLeeftijd() { return leeftijd; }

	public void addFriend(Person person) {
		if (person == null) {
			throw new IllegalArgumentException("No person given");
		}
		this.friends.add(person);
	}

	public boolean isFriend(Person person) {
		boolean isFriend = false;
		for (Person p : getFriends()) {
			if (person.equals(p)) isFriend = true;
		}
		return isFriend;
	}

	@Override
	public String toString() {
		return "Person{" +
				"userId='" + userId + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", status='" + status + '\'' +
				", geslacht='" + geslacht + '\'' +
				", leeftijd='" + leeftijd + '\'' +
				", friends=" + friends +
				'}';
	}
}