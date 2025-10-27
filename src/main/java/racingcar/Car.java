package racingcar;

public class Car {
	private static final int MOVE = 4;
	private static final int MAX_NAME = 5;
	
	private final String name;
	private int position = 0;
	
	public Car(String name) {
		Validator.validateCarName(name, MAX_NAME);
		this.name = name;
	}
}
