package Task_1;

public class Deputy extends Human {

	private String firstName;
	private String lastName;
	private int age;
	private boolean bribetaker;
	private int bribeValue;

	public Deputy(int weight, int height, String firstName, String lastName, int age, boolean bribetaker) {
		super(weight, height);
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.bribetaker = bribetaker;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribetaker() {
		return bribetaker;
	}

	public void setBribetaker(boolean bribetaker) {
		this.bribetaker = bribetaker;
	}

	public int getBribeValue() {
		return bribeValue;
	}

	public void setBribeValue(int bribeValue) {
		this.bribeValue = bribeValue;
	}

	public void giveBribe(int value){
		if (bribetaker){
			if (value>5000) System.out.println("Поліція ув’язнить депутата " + getLastName());
			else bribeValue += value;
		}

		else System.out.println("Депутат " + getLastName() + " не бере хабарів.");
	}

	@Override
	public String toString() {
		return "Депутат: [Прізвище: " + lastName + ", Ім’я: " + firstName + ", Вік: " + age + super.toString() + "]";
	}

}
