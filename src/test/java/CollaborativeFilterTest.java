import org.junit.Test;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.junit.Assert;

public class CollaborativeFilterTest {

  private String filePath = "src/main/resources/static/data/ratings.csv";

  @Test
  public void readDataTest() {
    try {
      DataModel model = new FileDataModel(new File(filePath));
    } catch (IOException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }

}
