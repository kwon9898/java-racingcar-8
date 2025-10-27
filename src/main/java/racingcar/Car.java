package racingcar;

public class Car {
	private static final int MIN_MOVE = 4;
	private static final int MAX_NAME = 5;
	
	private final String name;
	private int position = 0;
	
	public Car(String name) {
		Validator.validateCarName(name, MAX_NAME);
		this.name = name;
	}
	
	public void moveCar(int randomNumber) {
		if(randomNumber >= MIN_MOVE) {
			this.position++;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getCurrentPosition() {
		return "-".repeat(this.position);
	}
}
