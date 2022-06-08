//Name: Nitit Ngamphotchanamongkol
//ID: 6388093
//Section: 2

public class CreditCard{
	
	//**************************** DO NOT MODIFY **********************************//
	public static enum CardType{ VISA, AMERICANEXPRESS, JCB, MASTERCARD }; 
					// different types of credit card 
	
	public static final double CARDLIMIT = 5000.00;	
					// assume that for "each payment transaction" the maximum amount is 5,000
	
	private String number;		// card's number
	private CardType type;		// card's type
	//*****************************************************************************//
	
	public boolean card = false;
	
	/**
	 * Constructor initializes card number and card type
	 * @param number
	 * @param type
	 */
	public CreditCard(String number, CardType type) {
		//******************* YOUR CODE HERE ******************
		this.number = number;
		this.type = type;
		//*****************************************************
		
	}
	
	
	/**
	 * Verify the validity of the card information. Different card type has different format of card number as follow
	 * VISA -> the number must be 16 digits, and start with number 4
	 * AMERICANEXPRESS -> the number must be 15 digits, and start with either 34 or 37
	 * JCB -> the number must be 16 digits, and start with 3528 to 3589
	 * MASTERCARD -> the number must be 16 digits, and start with 51 or 52
	 * 
	 * For example, if the card is VISA and has number "4234567890123456", this card is valid.
	 * If the card is JCB and has number "4234567890123456", this card is invalid.
	 * 
	 * @return True if the card is valid, otherwise return false
	 */
	public boolean isValid() {
		//******************* YOUR CODE HERE ******************
		if(this.type == CardType.VISA) {
			if((this.number.length()==16) && this.number.startsWith("4")) {
				this.card = true;
				return true;
			}else {
				return false;
			}
		}else {
			if(this.type == CardType.AMERICANEXPRESS) {
				if((this.number.length()==15) && (this.number.startsWith("34")||this.number.startsWith("37"))) {
					card = true;
					return true;
				}else {
					return false;
				}
			}else {
				if(this.type == CardType.JCB) {
					if(this.number.length()==16) {
						for(int i=3528; i<=3589; i++) {
							if(this.number.startsWith(Integer.toString(i))) {
								card = true;
								return true;
							}
						}
					}else {
						return false;
					}
				}else {
					if(this.type == CardType.MASTERCARD) {
						if((this.number.length()==16) && (this.number.startsWith("51")||this.number.startsWith("52"))) {
							card = true;
							return true;
						}
					}
				}
			}
		}
		return false;
		
		//*****************************************************
	}
	
	
	/**
	 * If the card is valid, formats the card's number according to the card's type.
	 * AMERICANEXPRESS (15 digits): #### ###### ##### (4-6-5)
	 * VISA, JCB, MASTERCARD (16 digits): #### #### #### #### (4-4-4-4)
	 * 
	 * For example, if the card is VISA and has number "4234567890123456", 
	 * the string value "4234 5678 9012 3456" will be returned.
	 * 
	 * if the card is AMERICANEXPRESS and has number "343456789012345", 
	 * the string value "3434 567890 12345" will be returned.
	 * 
	 * If the card information is invalid, returns empty string.
	 * 
	 * @return a string of formatted card's number
	 */
	public String getFormattedCardNumber() {
		//******************* YOUR CODE HERE ******************
		String fin = null;
		
		if(this.card) {
			if(this.type == CardType.AMERICANEXPRESS && this.number.length()==15) {
				fin = this.number;
				return new StringBuilder(new String(fin)).insert(4," ").insert(11, " ").toString();
			}else {
				if(this.number.length()==16) {
					fin = this.number;
					return new StringBuilder(new String(fin)).insert(4," ").insert(9, " ").insert(14, " ").toString();
				}else {
					return fin;
				}
			}
		}return null;
		
		//*****************************************************
	}
	
	
	//**************************** DO NOT MODIFY **********************************//
	
	/**
	 * Get the value of card's type
	 * @return a String of card's type
	 */
	public String getType() {
		return type.name();
	}
	
	
	/**
	 * Get the raw card number before formatted
	 * @return a String of card's number
	 */
	public String getNumber() {
		return this.number;
	}
	
	//*****************************************************************************//

}