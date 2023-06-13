package Task_1;

public class Human {
	private int weight;
	private int height;
	
	Human(int weight, int height){
		this.height = height;
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return ", Вага: " + weight + ", Ріст: " + height;
	}

}
