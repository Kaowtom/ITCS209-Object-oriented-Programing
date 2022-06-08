// Name: Nitit Ngamphotchanamongkol
// ID: 6388093
// Section: 2

public class Book extends Item{
	
	private StringBuilder note = null;
	
	public Book(double _purchasePrice, double _age, double weight) {
		super(_purchasePrice, _age, weight);
		note = new StringBuilder();

	}

	@Override
	public double getCurrentValue() {
		//Your Code Goes Here
		double currentp=0;
		currentp = super.getPurchasePrice()*Math.pow(0.9,super.getAge());
		return currentp;
	}

	@Override
	public String toString()
	{
		return "[Book: value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Note = \""+getNote()+"\"]";
	}
	
	public void takeNote(String _note)
	{
		System.out.println("Taking note: \""+_note+"\"");
		note.append(_note);
	}
	
	public String getNote()
	{
		return note.toString();
	}
	
	public Book clone()
	{
		//Your Code Goes Here
		Book a = new Book(super.getPurchasePrice(), super.getAge(), super.getWeight());
		a.note.append(getNote());
		return a;
	}
}
