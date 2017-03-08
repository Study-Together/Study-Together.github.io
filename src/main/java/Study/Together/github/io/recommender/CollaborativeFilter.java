package Study.Together.github.io.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class CollaborativeFilter {

  /**
   * CSV must have the following format:
   * userID,itemID,rating
   */
  private String ratingsFilePath = "src/main/resources/static/data/ratings.csv"; // temporary sample ratings

  private int userID;
  private int recNumber;

  private double similarityThreshold = 0.1;
  private DataModel model;

  public CollaborativeFilter() {
    super();
  }

  public CollaborativeFilter(int userID, int recNumber) {
    this.userID = userID;
    this.recNumber = recNumber;
  }

  /**
   * Pull relevant data from profiles.csv to ratings.csv
   */
  private void readRatings() {
    try {
      this.model = new FileDataModel(new File(ratingsFilePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void recommend() {

    readRatings();

    try {
      UserSimilarity similarity = new PearsonCorrelationSimilarity(this.model);
      UserNeighborhood neighborhood = new ThresholdUserNeighborhood(similarityThreshold, similarity, this.model);
      UserBasedRecommender recommender = new GenericUserBasedRecommender(this.model, neighborhood, similarity);

      System.out.println("Top " + this.recNumber + " recommendations for user: " + this.userID);

      List<RecommendedItem> recommendations = recommender.recommend(this.userID, this.recNumber);
      for (RecommendedItem recommendation : recommendations) {
        System.out.println(recommendation);
      }

    } catch (TasteException e) {
      e.printStackTrace();
    }
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public int getRecNumber() {
    return recNumber;
  }

  public void setRecNumber(int recNumber) {
    this.recNumber = recNumber;
  }

}
