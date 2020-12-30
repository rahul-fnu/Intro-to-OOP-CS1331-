//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
public class HawaiianName{
	public static void main(String[] args) {
		String newName ="";
		System.out.println("Welcome to Hawaii! Let's check if your name is Hawaiian enough.\n");
		Scanner p = new Scanner(System.in);
		String name;
		String repeat = "y";
		while(repeat.equals("y")){
		System.out.print("Enter your name: ");
		name = p.next();
		name = name.toLowerCase();
		int size = name.length();
		for (int i = 0; i < size ; i++){
			if ((name.charAt(i) == 'a')|| (name.charAt(i) == 'e') || (name.charAt(i) == 'i') || (name.charAt(i) == 'o') || (name.charAt(i) == 'u') || (name.charAt(i) == 'k') || (name.charAt(i) == 'l') || (name.charAt(i) == 'h') || (name.charAt(i) == 'm') || (name.charAt(i) == 'n'))
				newName += name.charAt(i);}
		
		if (name.equals(newName))
			System.out.println("Aloha, "+ name);
		else{
			System.out.println("Sorry " +name+", you aren’t Hawaiian enough to come!");
			System.out.println("Let’s make your name... "+newName);
			System.out.println("Aloha, "+ newName);}
		
		System.out.print("Would you to try again? (y/n): ");
		repeat = p.next();


			}

	

		}
	}	
