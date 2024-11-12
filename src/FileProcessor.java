import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor{

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList = new ArrayList<>();
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		
		this.fileName = fileName;
		this.stringLength = stringLength;
			
	}//end empty-argument constructor
	
	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	public void processFile() {
		
		try
		{
			if(!(fileName == "BadString.txt" || fileName == "GoodString.txt" || fileName == "StringName.txt")) {throw new FileNotFoundException();}
			input = new Scanner(fileName);
			while(input.hasNextLine()) 
			{
				String s = input.nextLine();
				if(s.length() > stringLength) 
				{
					throw new StringTooLongException();
				}else {stringList.add(s);}
			} 
			
			
		}catch(FileNotFoundException e) 
		{
			System.out.println(e);
		}
		catch(StringTooLongException ex) 
		{
			System.out.println(ex);
		}
	}//end processFile
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStringLength() {
		return stringLength;
	}

	public void setStringLength(int stringLength) {
		this.stringLength = stringLength;
		if(stringLength < 5) {stringLength = 5;}
	}

}//end class
