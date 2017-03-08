package Study.Together.github.io.recommender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class CollaborativeFilter extends Recommender {

  /**
   * CSV must have the following format:
   * userID,itemID,rating
   */
  private String ratingsFilePath = "src/main/resources/static/data/ratings.csv"; // temporary sample ratings

  private int userID;
  private int recNumber;
  private List<String[]> ratedUsers;
  private Map<String, Integer> map;

  private double similarityThreshold = 0.1;
  private DataModel model;

  public CollaborativeFilter() {
    super();
    this.ratedUsers = new ArrayList<String[]>();
    this.map = new HashMap<String,Integer>();
  }

  public CollaborativeFilter(int userID) {
    this.userID = userID;
    this.ratedUsers = new ArrayList<String[]>();
    this.map = new HashMap<String,Integer>();
  }

  /**
   * Pull relevant data from profiles.csv to ratings.csv
   */
  private void pullRatings() {
    readData();

    String[][] array = new String[lines.size()][0];
    lines.toArray(array);

    FileWriter writer;
    try {
      writer = new FileWriter(ratingsFilePath);
      for (String[] user : lines) {
        String[] ratedUser = {Integer.toString(userID), user[STUDENT_ID], user[RATING]};
        map.put(user[STUDENT_ID], lines.indexOf(user));
        this.suitablePartners.add(ratedUser);
        CSVUtils.writeLine(writer, Arrays.asList(ratedUser));
      }

      writer.flush();
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /*
   * Read ratings to DataModel
   */
  private void readRatings() {
    recNumber = lines.size();
    try {
//      pullRatings();
      this.model = new FileDataModel(new File(ratingsFilePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void hash() {
    for (String[] user : lines) {
      map.put(user[STUDENT_ID], lines.indexOf(user));
    }
  }

  public void recommend() {

    readData();
    hash();
    readRatings();

    try {
      UserSimilarity similarity = new PearsonCorrelationSimilarity(this.model);
      UserNeighborhood neighborhood = new ThresholdUserNeighborhood(similarityThreshold, similarity, this.model);
      UserBasedRecommender recommender = new GenericUserBasedRecommender(this.model, neighborhood, similarity);

      System.out.println("Top " + this.recNumber + " recommendations for user: " + this.userID);

      List<RecommendedItem> recommendations = recommender.recommend(this.userID, this.recNumber);
      for (RecommendedItem recommendation : recommendations) {
        System.out.println(recommendation);
        System.out.println("ID: " + Long.toString(recommendation.getItemID()));
        int index = map.get(Long.toString(recommendation.getItemID()));
        suitablePartners.add(lines.get(index));
      }

      System.out.println(suitablePartners.size());

    } catch (TasteException e) {
      e.printStackTrace();
    }

  }

}
