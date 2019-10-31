package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {
	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		CountriesTextFile.createOurFile();
		int userChoice;
		ArrayList<Country> country = new ArrayList<>();
		country.add(new Country("India", "1,339,000,000"));
		country.add(new Country("The United States", "325,700,000"));
		country.add(new Country("China", "1,386,000,000"));
		country.add(new Country("Rwanda", "12,210,000"));
		CountriesTextFile.createDir();
		CountriesTextFile.createOurFile();

		System.out.println("Welcome to the Countries Maintenance Application!");

		do {

			System.out.println("1. - See the list of countries\n2. – Add a country\n3. – Exit");
			userChoice = Validator.getIntBetween(scnr, "Enter menu number: ", 1, 3);
			
			if (userChoice == 1) {

				CountriesTextFile.writeToFile(country);
				ArrayList<Country> countriesFromFile = CountriesTextFile.readFromFile("countries.txt");
				CountriesTextFile.readFromFile("countries.txt");
				for (Country c : country) {
					System.out.println(c);
				}

			} else if (userChoice == 2) {
				System.out.println("Enter country: ");
				String name = scnr.nextLine();
				System.out.println("Enter population: ");
				String pop = scnr.nextLine();

				Country c = new Country(name, pop);
				country.add(c);
				CountriesTextFile.writeToFile(country);
				System.out.println("\nThis country has been saved!");

			}

		} while (userChoice != 3);

		System.out.println("Buh-bye!");

	}

}
