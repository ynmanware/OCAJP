package lambda.part1;

import java.io.File;
import java.io.FileFilter;

public class Example1 {

	public static final String DIR = "C:/Workspaces3/OCAJP/src/lambda";

	public static void main(String[] args) {
		File dir = new File(DIR);

		JavaFileFilter fileFilter = new JavaFileFilter();
		File[] javaFiles = dir.listFiles(fileFilter);

		for (File file : javaFiles) {	
			System.out.println("File Name: " + file.getName());
		}
	}
}

class JavaFileFilter implements FileFilter {
	public boolean accept(File file) {
		return file.getName().endsWith(".java");
	}
}