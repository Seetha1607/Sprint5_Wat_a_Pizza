import java.util.Scanner;

 public class PizzaOrder {
    void displayCustomerDetails(String customerName, String customerEmail, long phoneNumber, String customerAddress) {
        System.out.println("Name of the Customer is : " + customerName);
        System.out.println("Email of the Customer is : " + customerEmail);
        System.out.println("Contact no of the Customer is :" + phoneNumber);
        System.out.println("Address of the Customer is : " + customerAddress);
    }
    void displayMenu() {
		System.out.println("Select items to order");
        System.out.println("Sl no  Category");
        System.out.println("1)    Pizza");
        System.out.println("2)    Garlic Bread");
        System.out.println("3)    Beverage");
    }
    public float getPriceOfPizzaBasedOnSize(int size) {
        float priceOfPizza = 0;
        if (size == 1) {
            priceOfPizza = 9.99f;
        } else if (size == 2) {
            priceOfPizza = 5.99f;
        } else if (size == 3) {
            priceOfPizza = 1.99f;
        } else {
            System.out.println("Invalid size, Enter 1,2 or 3");
            priceOfPizza = 0;
        }
        return priceOfPizza;
    }
    public float getPriceOfGarlicBread() {
        return 5.99f;
    }
    public float getPriceOfBeverage() {
        return 1.99f;
    }
    public float calculatePriceOfPizza(int noOfPizza, float priceOfPizza) {
        return noOfPizza * priceOfPizza;
    }
    public float calculatePriceOfGarlicBread(int noOfGarlicBread, float priceOfGarlicBread) {
        return noOfGarlicBread * priceOfGarlicBread;
    }
    public float calculatePriceOfBeverage(int noOfBeverage, float priceOfBeverage) {
        return noOfBeverage * priceOfBeverage;
    }
    public float calculateTotalBill(float totalPizzaPrice, float totalGarlicBreadPrice, float totalBeveragePrice) {
        float totalBillAmount = totalPizzaPrice + totalGarlicBreadPrice + totalBeveragePrice;
        return totalBillAmount;
    }
    public float calculateDiscountAndReturnBillAmount(float totalBillAmount) {
        if(totalBillAmount > 50) {
            float discount = (totalBillAmount * 10) / 100;
            float totalDiscountedBill = totalBillAmount - discount;
            return totalDiscountedBill;
        }
        else {
            return totalBillAmount;
        }
    }
    public void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverage, int size, float totalBillAmount,
                                    float totalDiscountedBillAmount) {
        System.out.println("----------------------------------------");
        System.out.println("Order Details  ");
        System.out.println("---------------");
        System.out.println("The number of pizzas ordered : " + noOfPizza);
        System.out.println("The number of garlic bread ordered : " + noOfGarlicBread);
        System.out.println("The number of beverages ordered : " + noOfBeverage);
        System.out.println("------------------------------------------");
        System.out.println("The Total Bill Amount is : " + "$" + totalBillAmount);
        if (totalBillAmount > 50) {
            System.out.println("The Discounted Bill Amount is : " + "$" + totalDiscountedBillAmount);
        } else {
            System.out.println("No Discount on Bill");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String customerName = input.next();
        String customerEmail = input.next();
        long phoneNumber = input.nextLong();
        input.nextInt();
        String customerAddress = input.nextLine();

        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.displayCustomerDetails(customerName, customerEmail, phoneNumber, customerAddress);

        int option;
        int noOfPizza = 0;
        int size = 0;
        int noOfGarlicBread = 0;
        int noOfBeverage = 0;
        float totalPizzaPrice = 0;
        float totalBeveragePrice = 0;
        float totalGarlicBreadPrice = 0;

        do {
            //Enter the option to select from the menu;
            option = input.nextInt();
            switch (option) {
                case 1: {
                    noOfPizza = input.nextInt();
                    size = input.nextInt();
                    float priceOfPizza = pizzaOrder.getPriceOfPizzaBasedOnSize(size);
                    totalPizzaPrice = totalPizzaPrice + pizzaOrder.calculatePriceOfPizza(noOfPizza,priceOfPizza);
                    break;
                }
                case 2: {
                    noOfGarlicBread = input.nextInt();
                    float priceOfGarlicBread = pizzaOrder.getPriceOfGarlicBread();
                    totalGarlicBreadPrice = totalGarlicBreadPrice + pizzaOrder.calculatePriceOfGarlicBread(noOfGarlicBread, priceOfGarlicBread);
                    break;
                }
                case 3: {
                    noOfBeverage = input.nextInt();
                    float priceOfBeverage = pizzaOrder.getPriceOfBeverage();
                    totalBeveragePrice = totalBeveragePrice + pizzaOrder.calculatePriceOfBeverage(noOfBeverage, priceOfBeverage);
                    break;
                }
            }//press enter 1 to order again or 0 to exit
            // option = input.nextInt();
        } while (option != 0);
        float totalBillAmount = pizzaOrder.calculateTotalBill(totalPizzaPrice, totalGarlicBreadPrice, totalBeveragePrice);
        float totalDiscountedBill = pizzaOrder.calculateDiscountAndReturnBillAmount(totalBillAmount);
        pizzaOrder.displayOrderDetails(noOfPizza, noOfGarlicBread, noOfBeverage, size, totalBillAmount, totalDiscountedBill);
    }
}