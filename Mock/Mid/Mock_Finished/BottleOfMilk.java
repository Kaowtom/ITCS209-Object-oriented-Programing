// Name: Nitit Ngamphotchanamongkol
// ID: 6388093
// Section: 2

public class BottleOfMilk extends Item{

	private double originalVolume = 0;		//ml
	private double currentVolume = 0;
	
	public BottleOfMilk(double _purchasePrice, double _age, double weight, double _volume) {
		super(_purchasePrice, _age, weight);
		originalVolume = _volume;
		currentVolume =originalVolume;
	}

	@Override
	public double getCurrentValue() {
		//Your Code Goes Here
		double currentv=0;
		currentv = super.getPurchasePrice()*(currentVolume/originalVolume);
		return currentv;
	}
	
	@Override
	public String toString()
	{
		return "[Milk"+": Value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Milk left = "+getVolume()+" ml]";
	}
	
	public void drink(double vol)
	{
		System.out.println("Drinking "+vol+" ml of milk");
		currentVolume -= vol;
		if(currentVolume < 0) currentVolume = 0;
	}
	
	@Override
	public double getWeight()
	{
		return super.getWeight()*(currentVolume/originalVolume);
	}
	
	public double getVolume()
	{
		return currentVolume;
	}
	
	public BottleOfMilk clone()
	{
		//Your Code Goes Here
		
		return new BottleOfMilk(super.getPurchasePrice(), super.getAge(), super.getWeight(), currentVolume);
	}
}
