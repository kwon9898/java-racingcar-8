package racingcar;

public class Validator {
	
	private static final int MIN_ROUND = 1;
	
	public static void validateCarNameInput(String input) {
		if(input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
		}
		if(input.endsWith(",")) {
			throw new IllegalArgumentException("자동차 이름 입력이 쉼표로 끝날 수 없습니다.");
		}
		if(input.contains(",,")) {
			throw new IllegalArgumentException("자동차 이름 입력 사이에 쉼표가 연속될 수 없습니다.");
		}
	}
	
	public static void validateCarName(String name, int maxLength) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > maxLength) {
            throw new IllegalArgumentException("자동차 이름은 " + maxLength + "자 이하만 가능합니다.");
        }
    }
	
	public static void validateRoundsInput(String input) {
        int rounds;
        try {
            rounds = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }

        if (rounds < MIN_ROUND) {
            throw new IllegalArgumentException("시도할 횟수는 " + MIN_ROUND + " 이상이어야 합니다.");
        }
    }
}
