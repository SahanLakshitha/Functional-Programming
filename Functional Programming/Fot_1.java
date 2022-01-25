import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fot_1 {
	public static void main(String args[]) {
		readAndWrite();
	}
		
	public static void readAndWrite() {
		
		// file reading
		List<FootBallRankings> table = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DTC\\eclipse-workspace\\Task 5 ex3\\Task5-6CS002--main\\FB Ranks.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        table.add(new FootBallRankings(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]),
		        		Integer.parseInt(values[4]),Integer.parseInt(values[5]),Double.parseDouble(values[6])));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table.forEach(x -> System.out.println(x));
		
		// file writing
		try {
		      FileWriter writer = new FileWriter("Fot_1.txt");
		      table.forEach(x -> {
				try {
					writer.write(x + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		      writer.close();
		      System.out.println("Fot_1.txt created.");
		    } catch (IOException e) {
		      System.out.println("Exception.");
		      e.printStackTrace();
		    }
		
		
	}

}
