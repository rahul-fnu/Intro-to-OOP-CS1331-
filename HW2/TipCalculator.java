import java.util.Scanner;
public class TipCalculator{
	public static void main(String[] args) {
	int i = 1;
	double sum = 0;
	double price = 0;
	Scanner myScanner = new Scanner (System.in );
	System.out.println("Welcome to Tip Calculator!");
	System.out.println("Enter the prices of your items. Enter -1 to enter tip percentage.");
	while (price != -1){
		System.out.print("Item " + i + ": $");
		price = myScanner.nextDouble();
		if (price!= -1)
			sum += price;
		i++;
	}
	if (price == -1){
		System.out.print("Enter the tip percentage:");
		double tip = myScanner.nextDouble();
		System.out.printf("Subtotal : $%.2f\n",sum);
		double tipInDollars = tip * sum;
		System.out.printf("Tip : $%.2f\n",tipInDollars);
		double total = tipInDollars + sum;
		System.out.printf("Total : $%.2f\n",total);

	}
}
}