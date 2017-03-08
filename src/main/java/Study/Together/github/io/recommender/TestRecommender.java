package Study.Together.github.io.recommender;

public class TestRecommender {

  public static void main(String[] args) {

    String[] currentStudent = {"Nada Alghofaili", "CS", "CPP", "nalghofaili@gmail.com",
        "222222", "English", "CS599","2", "On", "Off", "evening", "morning", "evening", "morning", "none" };

    IntegratedRecommender ir = new IntegratedRecommender(currentStudent);
    ir.outputRecommendations();
  }

}
