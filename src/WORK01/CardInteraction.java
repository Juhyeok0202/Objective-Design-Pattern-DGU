package WORK01;/*
 * OOP Assignment 1
 * Contains methods for interaction with user
 */
import java.util.Scanner;
public class CardInteraction {
	private Scanner scanner;
	private CardOrder card;
	
	public CardInteraction() {
		scanner = new Scanner(System.in);
	}
	
	//runs the program as follows:
	//Gets details of card name from user
	//Displays card
	//Repeatedly, until user responds ok
	//	Asks the user if they would like to change the border
	//	If so, change the border and print the new card
	//Print the price of the order
	//print whether a discount is applicable or not
	public void run() {
		//Alter this gradually to add more details
		System.out.println("명함에 표시할 이름을 영문으로 입력하세요.(최대 28자 / 공백 1개 이상)");
		String name = getNameFromUser();
		card = new CardOrder(name);

		System.out.println("주문할 카드 개수를 입력하세요.(1~1000 사이의 수만 가능)");
		int numCards = getNumberFromUser();
		card.setNumCards(numCards);

		System.out.println("\n[샘플 미리 보기]");
		System.out.println(card.getSampleCard());

		//사용자가 만족할 때까지 테두리 변경
		while (true) {
			System.out.println("테두리 문자를 변경하시겠습니까?(ok/no)");
			if (scanner.nextLine().trim().toLowerCase().equals("no")) {
				break;
			}

			System.out.println("변경할 테두리 문자를 입력하세요.(ex. * or - or # or etc.)");
			char newBorder = scanner.nextLine().charAt(0);
			card.setBorder(newBorder);

			System.out.println("\n[수정된 샘플 미리 보기]");
			System.out.println(card.getSampleCard());
		}

		// 가격 정보 출력
		System.out.println("총 주문 가격 : " + card.getFinalCost() + "$");
		System.out.println("할인 적용 여부 : " + (card.hasDiscount() ? "적용됨(10%)" : "미적용"));
	}

	//repeatedly requests and reads name from user
	//until valid (i.e. <=28 chars and contains at least one space
	//finally returns the valid text
	private String getNameFromUser() {
		//use this value until more code written
		while (true) {
			String input = scanner.nextLine();

			if (input.length() <= 28 && input.contains(" ")) {
				return input;
			}
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		}
	}
	
	//repeatedly requests and reads number from user
	//until valid number entered i.e. between 1 and 1000
	//finally returns the valid number	
	private int getNumberFromUser() {
		//use this number until more code written

		while (true) {
			try {
				int num = Integer.parseInt(scanner.nextLine());
				if (num >= 1 && num <= 1000) {
					return num;
				}
				System.out.println("잘못된 입력입니다.");
			} catch (Exception e) {
				System.out.println("유효한 숫자를 입력하세요.");
			}

		}
	}
}


