package Study.Together.github.io.recommender;

import java.util.ArrayList;
import java.util.List;

public class BasicRecommender extends Recommender {

  private String[] currentStudent;

  public BasicRecommender() {
    super();
  }

  public BasicRecommender(String[] currentStudent) {
    super();
    this.currentStudent = currentStudent;
  }

  public void setCurrentStudent(String[] currentStudent) {
    this.currentStudent = currentStudent;
  }

  public void recommend() {

    readData();

    String[][] array = new String[lines.size()][0];
    lines.toArray(array);

    for (int i = 0; i < lines.size(); i++) {
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

          String[] temp = lines.get(i);
          for (int j = 0; j < temp.length; ++j) {
            if (j != 0) {
              temp[j] = temp[j].replaceAll(" ", "");
            }
          }
        }

      }
    }

//    outputData();
    System.out.println("Done writing from Basic Recommender");
  }

}