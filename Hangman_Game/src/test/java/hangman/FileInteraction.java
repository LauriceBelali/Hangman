package hangman;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FileInteraction {
	
	private String file;

	public FileInteraction(String str) {
		this.file = str;
	}

	public String getRandomString() throws IOException {
		int rnd = new Random().nextInt(getAllStrings().length);
		return getAllStrings()[rnd];
		
	}
	
	public String[] getAllStrings() throws IOException {
		String row = "";
		String[] data = null;
		BufferedReader csvReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream(this.file)));
		while ((row = csvReader.readLine()) != null) {
			data = row.split(",");
		}
		csvReader.close();
		return data;
	}
}
