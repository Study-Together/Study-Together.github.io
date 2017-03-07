package Study.Together.github.io.recommender;

public class TestRecommender {

  public static void main(String[] args) {

    int userID = 222222;
    int recNumber = 3;
    String filePath = "src/main/resources/static/data/ratings2.csv";

    CollaborativeFilter cf = new CollaborativeFilter(userID, recNumber);
    cf.recommend();

    String[] currentStudent = {"Nada Alghofaili", "CS", "CPP", "nalghofaili@gmail.com",
        "9493108775", "English", "CS599","2", "On", "Off", "evening", "morning", "evening", "morning", "none" };

    System.out.println();
    BasicRecommender br = new BasicRecommender();
    br.setCurrentStudent(currentStudent);
    br.recommend();

  }

}
