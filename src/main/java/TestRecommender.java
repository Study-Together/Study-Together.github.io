
public class TestRecommender {

  public static void main(String[] args) {

    int userID = 222222;
    int recNumber = 3;

    CollaborativeFilter cf = new CollaborativeFilter(userID, recNumber);
    cf.recommend();

  }

}
