import java.util.Scanner;
public class PizzaOrder {
	void displayCustomerDetails(String name, String email, long phoneNo, String address){
	}
	void displayMenu(){
	}
	public float getPriceOfPizzaBasedOnSize(int size){
		float pizzaPrice = 0;
		if(size == 1){
			pizzaPrice = 9.99f;
		} else if(size == 2){
			pizzaPrice = 11.99f;
		} else if (size == 3){
			pizzaPrice = 13.99f;
		}else{
			System.out.println("Invalid size, enter 1,2 or 3");
			pizzaPrice = 0;
		}
		return pizzaPrice;
	}
	public float getPriceOfGarlicBread(){
		return 5.99f;
	}
	public float getPriceOfBeverage() {
		return 1.99f;
	}
	public float calculatePriceOfPizza(int noOfPizza, float pizzaPrice){
		return pizzaPrice * noOfPizza;
	}
	public float calculatePriceOfGarlicBread(int noOfGarlicBread, float garlicBreadPrice){
		return garlicBreadPrice * noOfGarlicBread;
	}
	public float calculatePriceOfBeverage(int noOfBeverage, float beveragePrice){
		return beveragePrice * noOfBeverage;
	}
	public float calculateTotalBill


}