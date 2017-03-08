package Study.Together.github.io.recommender;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegratedRecommender {

  protected static final int STUDENT_ID = 4;

  private String recommendationsFilePath = "src/main/resources/static/data/recommendations.csv";
  private String basicRecFilePath = "src/main/resources/static/data/BRrecommendations.csv";
  private String CFFilePath = "src/main/resources/static/data/CFrecommendations.csv";

  private BasicRecommender basicRec;
  private CollaborativeFilter collabFilter;

  private List<String[]> suitablePartners;

  public IntegratedRecommender(String[] currentStudent) {
    basicRec = new BasicRecommender(currentStudent);
    collabFilter = new CollaborativeFilter(Integer.parseInt(currentStudent[STUDENT_ID]));
    this.suitablePartners = new ArrayList<String[]>();
  }

  public void outputRecommendations() {
    // output results from BasicRecommender to CSV
    basicRec.recommend();
    suitablePartners = basicRec.getSuitablePartners();
    outputData(basicRecFilePath);

    // output results from CollaborativeFilter to CSV
    collabFilter.recommend();
    suitablePartners = collabFilter.getSuitablePartners();
    outputData(CFFilePath);

    // output combined results to CSV
    suitablePartners.clear();
    suitablePartners.addAll(basicRec.getSuitablePartners());
    suitablePartners.addAll(collabFilter.getSuitablePartners());
    outputData(recommendationsFilePath);
  }

  private void outputData(String filePath) {
    try {
      FileWriter writer = new FileWriter(filePath);
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
