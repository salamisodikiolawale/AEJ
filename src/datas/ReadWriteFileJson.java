package datas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

	public interface ReadWriteFileJson{
	


	public default JSONArray readerFileJson(String fileName) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(fileName+".json");
		Object objet = jsonParser.parse(reader);
	    JSONArray liste_plantes = (JSONArray) objet;
		return liste_plantes;
	}

	public default void writeFileJson(String fileName, JSONArray liste) throws IOException, ParseException, FileNotFoundException {
		FileWriter file = new FileWriter(fileName+".json");
	    file.write(liste.toJSONString());
	    file.flush();
	    file.close();
	}
}