package lambda.part1;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class LambaExample1 {
	
	public static final String DIR = "C:/Workspaces3/OCAJP/src/lambda";
	
	public static void main(String[] args) {
		File dir = new File(DIR);
		File[] javaFiles = dir.listFiles((file) -> file.getName().endsWith(".java"));
		List<File> listOfFiles = Arrays.asList(javaFiles);
		listOfFiles.forEach(file -> System.out.println(file.getName()));
	}
}
