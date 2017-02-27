package Study.Together.github.io.recommender;

public class TestRecommender {

  public static void main(String[] args) {

    int userID = 222222;
    int recNumber = 3;
    String filePath = "src/main/resources/static/data/ratings.csv";

    CollaborativeFilter cf = new CollaborativeFilter(userID, recNumber, filePath);
    cf.recommend();

  }

}
