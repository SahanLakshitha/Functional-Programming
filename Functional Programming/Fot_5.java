import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fot_5 {
	public static void main(String args[]) {
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

		System.out.println("\nSorted by comparator in FootBallRankings class ");
	    table.stream().sorted().forEach(System.out::println);

	    System.out.println();
	    System.out.println("Sorted lambda ");
	    table.stream()
	         .sorted((c1, c2) -> 
	            ((Double) c1.getAVG()).compareTo(c2.getAVG()))
	         .forEach(System.out::println);

	    try {
		      FileWriter writer = new FileWriter("Fot_5.txt");
		      writer.write("Sorted \n");
		      table.stream().sorted()
		        .forEach(str -> {
		        	try {
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      
		      writer.write("\nSorted \n");
		      table.stream().sorted((c1, c2) -> 
	            ((Double) c1.getAVG()).compareTo(c2.getAVG()))
		        .forEach(str -> {
		        	try {
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      writer.close();
		      System.out.println("Fot_5.txt created.");
		    } catch (IOException e) {
		      System.out.println("Exception.");
		      e.printStackTrace();
		    }
	}

}
