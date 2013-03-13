package za.multichoice.astar.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import za.multichoice.astar.common.MapBuilder;
import za.multichoice.astar.common.Obstacle;
import za.multichoice.astar.common.ObstacleRegistry;


public class FileMap extends MapBuilder
{
	private Map<Integer, String> lines = null;
	private String filepath;
	public FileMap(String filepath) {

		setFilepath(filepath);
		super.init();
	}

	@Override
	public void afterInit() {

		super.afterInit();
	}

	@Override
	public void beforeInit() {

		lines = readFile(getFilepath());

	}

	@Override
	public void buildMap() {

		Set<Integer> keySet = lines.keySet();
		for (Integer key : keySet) {
			String line = lines.get(key);
			converLineToObstacles(line, key);
		}
	}

	private void converLineToObstacles(String line, int x) {

		for (int y = 0; y < line.length(); y++) {
			Obstacle obstacle = ObstacleRegistry.getInstance(String.valueOf(line.charAt(y)));
			addObstacleToMap(x, y, obstacle);
		}
	}

	public Map<Integer, String> readFile(String filePath) {

		int counter = 0;
		File file = new File(filePath);
		BufferedReader br = null;
		FileReader fr = null;
		Map<Integer, String> lines = new TreeMap<Integer, String>();

		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";

			while ((line = br.readLine()) != null) {

				lines.put(counter, line);
				if (getWidth() == 0) {
					setWidth(line.length());
				}
				counter++;
			}

			setHeight(counter);
		} catch (FileNotFoundException e) {
			System.err.println("File [" + filePath + "] not found: " + e);
			System.exit(0);
		} catch (IOException ioe) {
			System.err.println("Exception while reading file [" + filePath + "]  " + ioe);
			System.exit(0);
		} finally {
			// close the streams using close method
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ioe) {
				System.err.println("Error while closing stream: " + ioe);
				System.exit(0);
			}
		}
		return lines;
	}

	public String getFilepath() {

		return filepath;
	}

	public void setFilepath(String filepath) {

		this.filepath = filepath;
	}
}
