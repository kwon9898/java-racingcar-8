package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGameController {
	
	public void run() {
		try {
			List<Car> car = createCarFromInput();
			int round = getRoundFromInput();
			runRace(car,round);
			announceWinner(car);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	private List<Car> createCarFromInput(){
		String nameInput = InputRacingGame.readCarName();
		Validator.validateCarNameInput(nameInput);
		
		return Arrays.stream(nameInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
	}
	
	private int getRoundFromInput() {
		String roundInput = InputRacingGame.readRound();
		Validator.validateRoundsInput(roundInput);
		return Integer.parseInt(roundInput);
	}
	
	private void runRace(List<Car> car, int round) {
		for(int i = 0 ; i < round ; i++) {
			raceOneRound(car);
			OutPutRacingGame.printRoundResult(car);
		}
	}
	
	private void raceOneRound(List<Car> car) {
		for (Car cars : car) {
			cars.moveCar(randomNumberOfRace());
		}
	}
	
	private int randomNumberOfRace() {
		return Randoms.pickNumberInRange(0, 9);
	}
	
	private void announceWinner(List<Car> car) {
		int maxPosition = findMaxPosition(car);
		List<String> winner = findWinnerName(car, maxPosition);
		OutPutRacingGame.printWinner(winner);
	}
	
	private int findMaxPosition(List<Car> car) {
		int maxPosition = 0;
		for (Car cars : car) {
			if(cars.getPosition() > maxPosition) {
				maxPosition = cars.getPosition();
			}
		}
		return maxPosition;
	}
	
	private List<String> findWinnerName(List<Car> car, int maxPosition){
		return car.stream()
				.filter(cars -> cars.getPosition() == maxPosition)
				.map(Car::getName)
				.collect(Collectors.toList());
	}
}
