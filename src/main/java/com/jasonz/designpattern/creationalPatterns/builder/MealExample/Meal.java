package creationalPatterns.builder.MealExample;

public class Meal
{
	//food��drink�ǲ���
	private String food;
	private String drink;
	
	public void setFood(String food) {
		this.food = food; 
	}

	public void setDrink(String drink) {
		this.drink = drink; 
	}

	public String getFood() {
		return (this.food); 
	}

	public String getDrink() {
		return (this.drink); 
	}
}