package Study.Together.github.io.controller;

import au.com.bytecode.opencsv.CSVWriter;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class WebController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	String healthCheck() {
		return "OK";
	}

	@RequestMapping(value = "/addUser/{userId}", method = RequestMethod.POST)
	String addUser(@PathVariable("userId") String userId,
				   @RequestParam("info") String allInfo) {

		String csv = "";//"../resources/static/data/UsersData.csv";
		CSVWriter writer = null;

		String userInfo = userId+","+allInfo;
		String[] record = userInfo.split(",");

		try {
			writer = new CSVWriter(new FileWriter(csv, true));
			writer.writeNext(record);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "done";
	}

	@RequestMapping(value = "/getRecommendations/{userId}", method = RequestMethod.GET)
	String getRecommendations(@PathVariable("userId") String userId) {
		return "OK";
	}

	@RequestMapping(value = "/ratePartners/{userId}", method = RequestMethod.POST)
	String ratePartners(@PathVariable("userId") String userId,
				   		@RequestParam("partnerID") String partnerID,
						@RequestParam("partnerRating") String partnerRating) {

		String csv = "../resources/static/data/UsersRatings.csv";
		CSVWriter writer = null;

		String userInfo = userId+","+partnerID+","+partnerRating;
		String[] record = userInfo.split(",");

		try {
			writer = new CSVWriter(new FileWriter(csv, true));
			writer.writeNext(record);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "OK";
	}

}
