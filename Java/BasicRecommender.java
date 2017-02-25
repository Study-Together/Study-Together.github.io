import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicRecommender {

    private static ArrayList<String[]> dataArr;
    public static void readData() throws IOException{
        BufferedReader dataBR = new BufferedReader(new FileReader("/Users/nada/Desktop/mydata.csv"));
        String line = "";
        dataArr = new ArrayList<String[]>();

        while ((line = dataBR.readLine()) != null) {
            String[] user = new String[6];
            String[] value = line.split(",", 9);

            int n = Math.min(value.length, user.length);

            for (int i = 0; i < n; i++) {

                user[i] = value[i];
            }
            dataArr.add(user);
        }
        dataBR.close();
    }

    public static void main(String[] args) throws IOException{
        List<String[]> lines = new ArrayList<String[]>();
        BufferedReader dataBR = new BufferedReader(new FileReader("/Users/nada/Desktop/mydata.csv"));
        String thisLine = "";

        while ((thisLine = dataBR.readLine()) != null) {
            lines.add(thisLine.split(","));
        }

        String[][] array = new String[lines.size()][0];
        lines.toArray(array);
        String[] currentStudent = {"101", "Nada Alghofaili", "CS", "nalghofaili@gmail.com",
                "949", "CS599", "2", "On", "Off",
                "evening", "morning", "evening", "morning", "none" };

        for (int i = 0; i < lines.size(); i++) {
            List<String[]> suitablePartners = new ArrayList<String[]>();
            List<String> suitableDays = new ArrayList<String>();

            if(array[i][0] != currentStudent[0]){
                //System.out.println("not same id");
                if(array[i][5].replaceAll("\\s+","").equals(currentStudent[5])){
                    //System.out.println("same class");
                    if(array[i][7].replaceAll("\\s+","").equals(currentStudent[7]) ||
                            array[i][8].replaceAll("\\s+","").equals(currentStudent[8])){
                        //System.out.println("possible locations");
                        for (int j = 9; j < 14; j++) {
                            if(array[i][j].replaceAll("\\s+","").equals(currentStudent[j])){
                                //System.out.println(currentStudent[j]);
                                suitableDays.add(currentStudent[j]);
                            }
                        }
                    }
                }
                if(!suitableDays.isEmpty()){
                    suitablePartners.add(lines.get(i));
                    System.out.println(array[i][1] + " and " + currentStudent[1] + " can study together");
                }
            }
        }
    }
}