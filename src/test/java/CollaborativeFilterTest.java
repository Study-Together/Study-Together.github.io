import org.junit.Test;

import java.io.File;
import java.io.IOException;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.junit.Assert;

public class CollaborativeFilterTest {

  private String ratingsFile = "data/ratings.csv";

  @Test
  public void readDataTest() {
    try {
      DataModel model = new FileDataModel(new File(ratingsFile));
    } catch (IOException e) {
      e.printStackTrace();
      Assert.fail();
    }
  }

}
