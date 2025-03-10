package WORK01;

// Test Driver
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test01();
		test02();
		test03();
	}

	private static void test01(){
		/**
		 * 두 글자와 세 글자 이름에 대해서 아래 세 가지 메서드를 테스트합니다.
		 * 1. getInits()
		 * 2. getFirstAndLastName()
		 * 3. getLastCommaFirst()
		 */
		System.out.println("[test01 : 두 글자와 세 글자 이름에 대해서 아래 세 가지 메서드를 테스트합니다.]");
		Name n1 = new Name("Jane", "Black");
		System.out.println(n1.getInits() + " " + n1.getFirstAndLastName());
		System.out.println(n1.getLastCommaFirst());
		System.out.println();

		Name n2 = new Name("Mary", "Ann", "Smith");
		System.out.println(n2.getInits() + " " + n2.getFirstAndLastName());
		System.out.println(n2.getLastCommaFirst());
		System.out.println();
	}

	private static void test02(){
		/**
		 * 이름, 테두리 문자, 명함 개수를 받아 CardOrder를 만들고 이름을 인쇄
		 */
		System.out.println("[test02 : 이름, 테두리 문자, 명함 개수를 받아 CardOrder를 만들고 이름을 인쇄]");
		//given
		String fName = "Jane Black";
		char border = '-';
		int numCards = 2;

		//when
		CardOrder cardOrder = new CardOrder(fName);

		//then
		Name name = cardOrder.getName();
		String firstName = name.getFirstName();
		String lastName = name.getLastName();
		String middleName = name.getMiddleName()!=null ? name.getMiddleName() : "";

		System.out.println(firstName + " " + middleName +" "+ lastName+"\n");
	}
	private static void test03(){
		/**
		 * 테두리를 지정하고 set메소드를 이용하여 카드의 개수를 지정한 후 내용을 인쇄
		 */
		System.out.println("[test03 : 테두리를 지정하고 set메소드를 이용하여 카드의 개수를 지정한 후 내용을 인쇄]");
		//given
		String fName = "Jane Black";
		char border = '-';
		int numCards = 1;

		//when
		CardOrder cardOrder = new CardOrder(fName);
		cardOrder.setNumCards(2);

		//then
		int updatedNumCards = cardOrder.getNumCards();
		for (int i = 0; i < updatedNumCards; ++i) {
			System.out.println(cardOrder.getSampleCard());
		}

		System.out.println("명함 개수 : " + updatedNumCards);
		System.out.println("테두리 : " + cardOrder.getBorder());
	}
}
