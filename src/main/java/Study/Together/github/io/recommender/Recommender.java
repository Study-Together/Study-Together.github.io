package Study.Together.github.io.recommender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Recommender {

  private String profilesFilePath = "src/main/resources/static/data/profiles.csv";
  private String recommendationsFilePath = "src/main/resources/static/data/recommendations.csv";

  protected List<String[]> lines = new ArrayList<String[]>();
  protected List<String[]> suitablePartners = new ArrayList<String[]>();

  protected void readData() {
    BufferedReader dataBR;

    try {
      dataBR = new BufferedReader(new FileReader(profilesFilePath));
      String thisLine = "";

      while ((thisLine = dataBR.readLine()) != null) {
          lines.add(thisLine.split(","));
      }
      dataBR.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  protected void outputData() {
    try {
      FileWriter writer = new FileWriter(recommendationsFilePath);
      for (String[] partner : suitablePartners) {
        CSVUtils.writeLine(writer, Arrays.asList(partner));
      }

      writer.flush();
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
