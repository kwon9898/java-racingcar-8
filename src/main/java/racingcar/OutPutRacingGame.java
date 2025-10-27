package racingcar;

import java.util.List;

public class OutPutRacingGame {
	
	public static void printResultHeader() {
        System.out.println("\n실행 결과");
    }
    
    public static void printRoundResult(List<Car> car) {
        for (Car cars : car) {
            System.out.printf("%s : %s\n", cars.getName(), cars.getCurrentPosition());
        }
        System.out.println();
    }
    
    public static void printWinner(List<String> winner) {
        String winnerName = String.join(", ", winner);
        System.out.printf("최종 우승자 : %s\n", winnerName);
    }
}
