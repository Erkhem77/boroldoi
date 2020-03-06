package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

public class DataClient {
	public static void main(String[] args) throws FileNotFoundException{
		Filter filter = new Filter();
		
		String directory = File.separator + "C:"+
				File.separator +"Users" +
				File.separator +"owner"+
				File.separator +"Documents"+
				File.separator +"CSC_143"+
				File.separator +"W20"+
				File.separator +"workspace";
		
		String directory1 = File.separator + "C:"+
				File.separator +"Users" +
				File.separator +"owner"+
				File.separator +"Documents"+
				File.separator +"CSC_143"+
				File.separator +"W20"+
				File.separator +"workspace"+
				File.separator + "People(1).txt";
		filter.read(directory1);
		filter.filterEmployeeSalary(directory);
		filter.filterEmployeeService(directory);
		filter.filterVisitorAge(directory);
		filter.generateGalaLists(directory);
	}

}