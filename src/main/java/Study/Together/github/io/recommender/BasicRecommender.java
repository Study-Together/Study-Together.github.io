package Study.Together.github.io.recommender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicRecommender {

  private static final int STUDENT_NAME = 0;
  private static final int UNIVERSITY = 2;
  private static final int STUDENT_ID = 4;
  private static final int LANGUAGE = 5;
  private static final int DESIRED_CLASS = 6;
  private static final int ON_CAMPUS = 7;
  private static final int OFF_CAMPUS = 8;
  private static final int MONDAY = 9;
  private static final int FRIDAY = 14;
  private static final int SIMILARITY = 15;

  private static final int SIMILARITY_CONSTANT = 10;

  private String profilesFilePath = "src/main/resources/static/data/profiles.csv";
  private String recommendationsFilePath = "src/main/resources/static/data/recommendations2.csv";

  private List<String[]> lines;
  private List<String[]> suitablePartners;
  private String[] currentStudent;

  public BasicRecommender() {
    super();
    this.lines = new ArrayList<String[]>();
    this.suitablePartners = new ArrayList<String[]>();
  }

  public BasicRecommender(String[] currentStudent) {
    super();
    this.currentStudent = currentStudent;
    this.lines = new ArrayList<String[]>();
    this.suitablePartners = new ArrayList<String[]>();
  }

  public void setCurrentStudent(String[] currentStudent) {
    this.currentStudent = currentStudent;
  }

  public void setFilePath(String filePath) {
    this.profilesFilePath = filePath;
  }

  public void recommend() {

    readData();

    String[][] array = new String[lines.size()][0];
    lines.toArray(array);

    for (int i = 0; i < lines.size(); i++) {
//      suitablePartners = new ArrayList<String[]>();
      List<String> suitableDays = new ArrayList<String>();
      int similarity = 0;
      if(array[i][STUDENT_ID] != currentStudent[STUDENT_ID]){
//                System.out.println("not same id");
        if(array[i][DESIRED_CLASS].replaceAll("\\s+","").equals(currentStudent[DESIRED_CLASS])){
//                    System.out.println("same class");
          similarity += SIMILARITY_CONSTANT;
          if(array[i][ON_CAMPUS].replaceAll("\\s+","").equals(currentStudent[ON_CAMPUS]) ||
                array[i][OFF_CAMPUS].replaceAll("\\s+","").equals(currentStudent[OFF_CAMPUS])){
            similarity += SIMILARITY_CONSTANT;
            //System.out.println("possible locations");
            for (int j = MONDAY; j < FRIDAY; j++) {
              if(array[i][j].replaceAll("\\s+","").equals(currentStudent[j])){
                  //System.out.println(currentStudent[j]);
                  suitableDays.add(currentStudent[j]);
                  similarity += SIMILARITY_CONSTANT;
              }
            }
          }
        }

        if (array[i][UNIVERSITY].replaceAll("\\s+","").equals(currentStudent[UNIVERSITY])) {
          similarity += SIMILARITY_CONSTANT;
        }
        if (array[i][LANGUAGE].replaceAll("\\s+","").equals(currentStudent[LANGUAGE])) {
          similarity += SIMILARITY_CONSTANT;
        }

        array[i][SIMILARITY] = Integer.toString(similarity) + "%";
        if(!suitableDays.isEmpty()){
          suitablePartners.add(lines.get(i));
          System.out.println(array[i][STUDENT_NAME] + " and " + currentStudent[STUDENT_NAME] + " can study together");
          System.out.print("suitable: ");
          String[] temp = lines.get(i);
          for (int j = 0; j < temp.length; ++j) {
            if (j != 0) {
              temp[j] = temp[j].replaceAll(" ", "");
            }
          }
        }

      }
    }

    outputData();
  }

  private void outputData() {
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

  private void readData() {
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