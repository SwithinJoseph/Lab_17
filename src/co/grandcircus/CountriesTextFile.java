package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	public static ArrayList<Country> readFromFile(String fileName) {
		ArrayList<Country> country = new ArrayList<>();
		Path path = Paths.get(fileName);

		File file = path.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();

			while (line != null) {
				String[] countryValues = line.split(",");
				Country c = new Country(countryValues[0], countryValues[1]);
				country.add(c);
				line = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Something happened with the file...");
		} catch (IOException e) {
			System.out.println("Something happened when attempting to read from the file...");
		}
		return country;
	}

	public static void writeToFile(ArrayList<Country> country) {
		String fileName = "countries.txt";

		Path path = Paths.get(fileName);

		File file = path.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			for (Country c : country) {
				output.println(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Hey, contact customer service!");
		} finally {
			output.close();
		}

	}

	public static void createOurFile() {

		String fileName = "countries.txt";

		Path path = Paths.get(fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);

			} catch (IOException e) {
				//System.out.println("Something went terribly wrong.");
			}
		} else {

		}
	}

	public static void createDir() {

		String dirPath = "country_list";

		Path folder = Paths.get(dirPath);

		if (Files.notExists(folder)) {

			try {
				Files.createDirectories(folder);
				//System.out.println("The file was created successfully");

			} catch (IOException e) {

				//System.out.println("Something went wrong with the folder creation");
			}

		} else {
			//System.out.println("The folder already exists!");
		}
	}

}
