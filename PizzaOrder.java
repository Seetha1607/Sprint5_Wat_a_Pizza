import java.util.Scanner;
public class PizzaOrder {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String name = input.next();
		String email = input.next();
		String address = input.next();
		input.nextLine();
		long phoneNo = input.nextLong();
		
		PizzaBill pizzaBill = new PizzaBill();
		pizzaBill.displayCustomerDetails(name,email,phoneNo,address);

		int option;
		int size = 0;
		float totalPizzaPrice = 0;
		float totalGarlicBreadPrice = 0;
		float totalBeveragePrice = 0;
		int noOfPizza = 0;
		int noOfGarlicBread= 0;
		int noOfBeverage = 0;

		do{
			option = input.nextInt();
			if (option == 1){
				size = input.nextInt();
				noOfPizza = input.nextInt();
				float pizzaPrice = pizzaBill.getPriceOfPizzaBasedOnSize(size);
				totalPizzaPrice = pizzaBill.calculatePriceOfPizza(noOfPizza,pizzaPrice);
			} else if (option == 2){
				noOfGarlicBread = input.nextInt();
				float garlicBreadPrice = pizzaBill.getPriceOfGarlicBread();
				totalGarlicBreadPrice = pizzaBill.calculatePriceOfGarlicBread(noOfGarlicBread,garlicBreadPrice);
			} else if (option == 3){
				noOfBeverage = input.nextInt();
				float beveragePrice = pizzaBill.getPriceOfGarlicBread();
				totalBeveragePrice = pizzaBill.calculatePriceOfBeverage(noOfBeverage,beveragePrice);
			}
			option = input.nextInt();
		} while (option != 0);
		float totalBillAmount  = pizzaBill.calculateTotalBill(totalPizzaPrice,totalGarlicBreadPrice,totalBeveragePrice);
		float discountedBillAmount = pizzaBill.calculateDiscountAndReturnBillAmount(totalBillAmount);
		pizzaBill.displayOrderDetails(noOfPizza,noOfGarlicBread,noOfBeverage,size,totalBillAmount,discountedBillAmount);
	}
}
class PizzaBill{
	float pizzaPrice = 0;
	void displayCustomerDetails(String name, String email, long phoneNo, String address){
		System.out.println("Customer Details");
		System.out.println("------------------");
		System.out.println("Name of the Customer is : " + name);
		System.out.println("Email of the Customer is : " + email);
		System.out.println("Contact No of the Customer is : " + phoneNo);
		System.out.println("Address of the Customer is : " + address);
	}
	void displayMenu(){
		System.out.println("Select the items to order");
		System.out.println("Sl No      Item Category");
		System.out.println("------------------------");
		System.out.println("1) Pizza");
		System.out.println("2) Garlic Bread");
		System.out.println("3) Beverage");
	}
	public float getPriceOfPizzaBasedOnSize(int size){
		if(size == 1){
			pizzaPrice = 9.99f;
		} else if(size == 2){
			pizzaPrice = 11.99f;
		} else if (size == 3){
			pizzaPrice = 13.99f;
		}else{
			System.out.println("Invalid size, enter 1, 2 or 3");
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
	public float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice, float totalBeveragePrice){
		return totalPizzaPrice + totalGarlicBreadPrice + totalBeveragePrice;
	}
	public float calculateDiscountAndReturnBillAmount(float totalBillAmount){
		if(totalBillAmount > 50){
			float discount = (totalBillAmount * 10)/100;
			float discountedBillAmount = totalBillAmount - discount;
			return discountedBillAmount; 
		} else {
			return totalBillAmount;
		}
	}
	public void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverage, int size, float totalBillAmount, float discountedBillAmount){
		System.out.println("------------------------------------");
		System.out.println("Order Details");
		System.out.println("-------------");
		System.out.println("The number of pizzas ordered        : " + noOfPizza);
		System.out.println("The number of garlic bread ordered  : " + noOfGarlicBread);
		System.out.println("The number of beverages ordered     : " + noOfBeverage);
		System.out.println("-----------------------------------------------");
		System.out.println("The Total Bill Amount is          : " + "$" + totalBillAmount);
		if(totalBillAmount > 50){
			System.out.println("The Discounted Bill Amount is   : " + "$" + discountedBillAmount);
		} else {
			System.out.println("No Discount on bill");
		}
	}
}
