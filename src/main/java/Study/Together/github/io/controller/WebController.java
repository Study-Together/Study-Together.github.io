package Study.Together.github.io.controller;

import Study.Together.github.io.recommender.BasicRecommender;
import Study.Together.github.io.recommender.IntegratedRecommender;
import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.sql.ResultSet;

@RestController
public class WebController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	String healthCheck() {
		return "OK";
	}

	@RequestMapping(value = "/addUser/{userInfo}", method = RequestMethod.POST)
	String addUser(@PathVariable("userInfo") String userInfo) {

		String usersFilePath = "src/main/resources/static/data/profiles.csv";
		CSVWriter writer = null;
		String[] record = userInfo.split(",");

		try {
			writer = new CSVWriter(new FileWriter(usersFilePath, true), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
			writer.writeNext(record);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "done";
	}

	@RequestMapping(value = "/getRecommendations", method = RequestMethod.GET)
	String getRecommendations() {
		String line, last = "";
		try {
			BufferedReader input = new BufferedReader(new FileReader(new File("src/main/resources/static/data/profiles.csv")));
			while ((line = input.readLine()) != null) {
				last = line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] currentStudent = last.split(",");
		for(int i =0; i < currentStudent.length; i++){
			currentStudent[i] = currentStudent[i].trim();
		}
		IntegratedRecommender ir = new IntegratedRecommender(currentStudent);
		ir.outputRecommendations();

		return "OK";
	}

	@RequestMapping(value = "/addRating/{ratingInfo}", method = RequestMethod.GET)
	String addRating(@PathVariable("ratingInfo") String ratingInfo) {
		String csv = "src/main/resources/static/data/ratings.csv";
		CSVWriter writer = null;
		String[] record = ratingInfo.split(",");

		try {
			writer = new CSVWriter(new FileWriter(csv, true), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER);
			writer.writeNext(record);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "OK";
	}

}
