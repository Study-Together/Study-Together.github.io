package Study.Together.github.io.recommender;

public class IntegratedRecommender {

  private BasicRecommender basicRec;
  private CollaborativeFilter collabFilter;

  public IntegratedRecommender() {
    basicRec = new BasicRecommender();
    collabFilter = new CollaborativeFilter();
  }

}
