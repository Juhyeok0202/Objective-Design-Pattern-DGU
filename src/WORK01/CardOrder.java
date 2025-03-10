package WORK01;

/**
 * OOP Assignment One
 * CardOrder class keeps details of one card order
 * and provides methods to print a card 
 * and determine the price
 *
 */
public class CardOrder {
	private Name name;  	//the name printed on the card
	private char border;    //the card border
	private int numCards;   //the number of cards to be printed
	
	private static final int CARD_LEN = 32;  //the length of the card in characters
	
	//initialises name from value in parameter
	//and sets other instance variables to suitable default values
	//you can create a Name from a single string after L5
      //If you want to start before then, just write name = new Name("A", "B", "C") in the constructor!
	public CardOrder(String fullName) {
		String[] splitedName = fullName.split(" ");
		if (splitedName.length == 2) {
			this.name = new Name(splitedName[0], splitedName[1]);
		} else {
			this.name = new Name(splitedName[0], splitedName[1], splitedName[2]);
		}
		this.border = '*';
		this.numCards = 0;
	}
	
	///////////////////////////////////////////
	//accessor/mutator methods
	
	//returns the character used in the border
	public char getBorder() {
		return this.border;
	}

	//sets the character used in the border 
	//to that provided in the parameter
	public void setBorder(char ch) {
		this.border = ch;
	}
	
	//returns the name 
	public Name getName() {
		return this.name;
	}

	//sets the name used in the card
	//to that provided in the parameter
	public void setName(Name name) {
		this.name = name;
	}
	
	//returns the number of cards to be printed
	public int getNumCards() {
		return this.numCards;
	}
	
	//sets the number of cards to be printed 
	//to that provided in the parameter
	public void setNumCards(int n) {
		this.numCards = n;
	}
	///////////////////////////////////////////
	
	//returns a sample card, including a newline at the end of each line
	public String getSampleCard() {
		return getTopLine() + getBlankLine() + this.getLineWithName()
		       + getBlankLine() + getTopLine();
	}
	
	//returns a String containing the top or bottom line
	//of a card, including a newline character at the end
	private String getTopLine() {
		//use this value until more code written
		return String.valueOf(border).repeat(CARD_LEN) + "\n";
		//return "Topline\n";
	}
	
	//returns a String containing the blank line
	//of a card, with a border char at each end
	//and including the newline character	
	private String getBlankLine() {	
		//use this value until more code written
		return border + " ".repeat(CARD_LEN - 2) + border + "\n";
		//return "Blankline\n";
	}
	
	//returns a String containing the name line
	//of a card, including name, padding and border
	//and including the newline character	
	private String getLineWithName() {
		//use this value until more code written
		String name = this.name.getFullName();
		System.out.println("test fullname : " + name);
		System.out.println("len : " + name.length());
		String padding = " ".repeat((CARD_LEN - 2 - name.length()) / 2);

		if (padding.length() % 2 != 0) {
			return border + padding + name + padding+" " + border + "\n";
		}
		return border + padding + name + padding + border + "\n";
		//return "Nameline\n";
	}
	
	//returns the price of one card
	//in pounds (i,e either 0.20 or 0.25)
	//based on the number of characters in the name to be printed
	//0.20 if <=12 otherwise 0.25
	public double getCardPrice() {
		//use this value until more code written
		return name.getFullName().length() <= 12 ? 0.20 : 0.25;
	}

	//returns the final cost of the order
	//which is the number of cards multiplied by the card price
	//and reduced by 10% if >= 100 cards
    public double getFinalCost() {
		//use this value until more code written
		double totalCost = numCards * getCardPrice();
		return hasDiscount() ? totalCost * 0.9 : totalCost;
    }
    
    //returns true if number of cards < 100, false otherwise
	//returns ture if number of cards >= 100, false otherwise 아닌가요?
    public boolean hasDiscount() {
		return numCards >= 100;
    }
}
