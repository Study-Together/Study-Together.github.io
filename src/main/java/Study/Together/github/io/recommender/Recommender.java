package Study.Together.github.io.recommender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Recommender {

  protected static final int STUDENT_NAME = 0;
  protected static final int UNIVERSITY = 2;
  protected static final int STUDENT_ID = 4;
  protected static final int LANGUAGE = 5;
  protected static final int DESIRED_CLASS = 6;
  protected static final int ON_CAMPUS = 7;
  protected static final int OFF_CAMPUS = 8;
  protected static final int MONDAY = 9;
  protected static final int FRIDAY = 14;
  protected static final int SIMILARITY = 15;
  protected static final int RATING = 16;
  protected static final int SIMILARITY_CONSTANT = 10;

  private String profilesFilePath = "src/main/resources/static/data/profiles.csv";
  private String recommendationsFilePath = "src/main/resources/static/data/recommendations.csv";

  protected List<String[]> lines = new ArrayList<String[]>();
  protected List<String[]> suitablePartners = new ArrayList<String[]>();

  public List<String[]> getSuitablePartners() {
    return this.suitablePartners;
  }

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

}
