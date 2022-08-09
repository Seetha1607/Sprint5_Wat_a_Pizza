import java.util.Scanner;
class PizzaOrder {
    void displayCustomerDetails(String name, String email, long phoneNumber, String address) {
    }

    void displayMenu() {
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
            //System.out.println("Invalid size, Enter 1,2 or 3");
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
        System.out.println("The Total Bill Amount is : " + "$" + totalBillAmount);
        return totalBillAmount;
    }

    public float calculateDiscountAndReturnBillAmount(float totalBillAmount) {
        float discount = (totalBillAmount * 10) / 100;
        float totalDiscountedBill = totalBillAmount - discount;
        System.out.println("The Discounted Bill Amount is : " + "$" + totalDiscountedBill);
        return totalDiscountedBill;
    }

    public void displayOrderDetails(int noOfPizza, int noOfGarlicBread, int noOfBeverage, int size, float totalBillAmount,
                                    float totalPriceAfterDiscounted) {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Customer Details      ");
        System.out.println("----------------------");
        String name = input.next();
        System.out.println("Name of the Customer is : " + name);
        String email = input.next();
        System.out.println("Email of the Customer is : " + email);
		String address = input.nextLine();
        System.out.println("Address of the Customer is : " + address);
        long phoneNumber = input.nextLong();
        System.out.println("Contact No of the Customer is : " + phoneNumber);
        System.out.println("-----------------------------------------------");
        System.out.println("Order Details ");
        System.out.println("----------------");
        PizzaOrder pizzaOrder = new PizzaOrder();
        int size= 0;
        int option;
        float totalPizzaPrice = 0;
        float totalGarlicBreadPrice = 0;
        float totalBeverageBill = 0;

        do {
            //System.out.println("Enter 1 for Pizza, 2 for Garlic Bread and 3 for Beverages");
            option = input.nextInt();

            switch (option) {
                case 1:
                    float priceOfPizza = 0;
                    if (size == 1) {
                        priceOfPizza = 9.99f;
                    } else if (size == 2) {
                        priceOfPizza = 5.99f;
                    } else if (size == 3) {
                        priceOfPizza = 1.99f;
                    } else {
                        //System.out.println("Invalid size, Enter 1,2 or 3");
                        priceOfPizza = 0;
                    }
                    size = input.nextInt();
                    int noOfPizza = input.nextInt();
                    System.out.println("The number of pizzas ordered : " + noOfPizza);
                    priceOfPizza = pizzaOrder.getPriceOfPizzaBasedOnSize(size);
                    totalPizzaPrice = totalPizzaPrice + (pizzaOrder.calculatePriceOfPizza(noOfPizza, priceOfPizza));
                    break;
                case 2:
                    int noOfGarlicBread = input.nextInt();
                    System.out.println("The number of garlic bread ordered : " + noOfGarlicBread);
                    float priceOfGarlicBread = pizzaOrder.getPriceOfGarlicBread();
                    totalGarlicBreadPrice = totalGarlicBreadPrice + (pizzaOrder.calculatePriceOfGarlicBread(noOfGarlicBread, priceOfGarlicBread));
                    //System.out.println("Your total Garlic Bread Bill : " + " $ " + totalGarlicBreadBill);
                    break;
                case 3:
                    int noOfBeverage = input.nextInt();
                    System.out.println("The number of beverages ordered : " + noOfBeverage);
                    float priceOfBeverage = pizzaOrder.getPriceOfBeverage();
                    totalBeverageBill = totalBeverageBill + (pizzaOrder.calculatePriceOfBeverage(noOfBeverage, priceOfBeverage));
                    //System.out.println("Your total Beverage Bill : " + " $ " + totalBeverageBill);
                    break;
            }
            //System.out.println("Do you want to place another order enter 1 to continue or 0 to exit");
            option = input.nextInt();
        }while (option != 0);
        System.out.println("----------------------------------------------------------------------------------------");
        float totalBillAmount = pizzaOrder.calculateTotalBill(totalPizzaPrice,totalGarlicBreadPrice,totalBeverageBill);
        if(totalBillAmount > 50){
            float discountedBill = pizzaOrder.calculateDiscountAndReturnBillAmount(totalBillAmount);
        }else {
            System.out.println("No Discount on Bill");
        }
    }
}

