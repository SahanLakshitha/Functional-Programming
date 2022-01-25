import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Fot_3 {

	public static void main(String[] args) {
		readAndWrite();
	}

	public static void readAndWrite() {
		List<FootBallRankings> table = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\DTC\\\\eclipse-workspace\\\\Task 5 ex3\\\\Task5-6CS002--main\\\\FB Ranks.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        table.add(new FootBallRankings(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]),
		        		Integer.parseInt(values[4]),Integer.parseInt(values[5]),Double.parseDouble(values[6])));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}	

		OptionalInt min = table.stream().mapToInt(FootBallRankings::getPoints).min();
	    if (min.isPresent()) {
	      System.out.printf("\nLowest number of points is %d\n", min.getAsInt());
	    } else {
	      System.out.println("min failed");
	    }
	    			    
    	try {
		      FileWriter writer = new FileWriter("Fot_3.txt");
		      writer.write("Lowest number of points is " + min.getAsInt() + "\n");
		      writer.close();
		      System.out.println("Fot_3.txt created.");
		    } catch (IOException e) {
		      System.out.println("Exception.");
		      e.printStackTrace();
		    }
	}
	
}
