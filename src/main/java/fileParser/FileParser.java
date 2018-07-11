package fileParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileParser {

	private File logFile=null;
	private File queryFile=null;
	long startTime = 0;
	long endTime = 0; 
	
	public FileParser() {
		init();
	}
	
	void init(){
		try {
			File logDirectory = new File(FilePathConstants.logFilePath);
			if(logDirectory.exists() == false){
				throw new Exception("Log Directory Missing");
			}
			logFile = new File(FilePathConstants.logFilePath + FilePathConstants.LOG_FILE);

			File opDirectory = new File(FilePathConstants.oPathAftrParsing);
			if(opDirectory.exists() == false){
				opDirectory.mkdir();
			}
			queryFile = new File(FilePathConstants.oPathAftrParsing + FilePathConstants.OUTPUT_FILE);
			queryFile.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void parseFile(){
		startTime = new Date().getTime(); 
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			String sCurrentLine;
			StringBuffer strBfr;
			br = new BufferedReader(new FileReader(logFile.getAbsoluteFile()));
			char[] chArr = null;
			int queryIdStartIndex = 0;
			String queryIdStartStr = "Query ID ::";
			int queryIdEndIndex = 0;
			String queryIdEndStr = "::";
			
			bw = new BufferedWriter(new FileWriter(queryFile));
			String queryStringStartExp = "-->";
			int queryStringStartIndex = 0;
			String queryStringEndExp = "F550512";
			StringBuilder queryString = null;
			
			/*while ((sCurrentLine = br.readLine()) != null) {
					strBfr = new StringBuffer(sCurrentLine);
					queryIdStartIndex = strBfr.indexOf(queryIdStartStr);
					queryIdEndIndex = strBfr.indexOf(queryIdEndStr, queryIdStartIndex + 12);
					if(queryIdStartIndex != -1 && queryIdEndIndex != -1){
						chArr = new char[queryIdEndIndex - queryIdStartIndex];
						strBfr.getChars(queryIdStartIndex, queryIdEndIndex, chArr, 0);
						System.out.println(chArr);
						bw.write(chArr);bw.newLine();
					}
					
					//writing to QueryFile//
					
			}*/
			
			while ((sCurrentLine = br.readLine()) != null) {
				queryIdStartIndex = sCurrentLine.indexOf(queryIdStartStr);
				queryIdEndIndex = sCurrentLine.indexOf(queryIdEndStr, queryIdStartIndex + 12);
				if(queryIdStartIndex != -1 && queryIdEndIndex != -1){
					chArr = new char[queryIdEndIndex - queryIdStartIndex];
					sCurrentLine.getChars(queryIdStartIndex, queryIdEndIndex, chArr, 0);
										
					//writing to QueryFile//
					bw.write(chArr);bw.newLine();
					
					//writing query string//
					queryString = new StringBuilder();
					while((sCurrentLine = br.readLine()) != null){
						if(sCurrentLine.contains(queryStringStartExp)){
							queryStringStartIndex = sCurrentLine.indexOf(queryStringStartExp) + 3;
							queryString.append(sCurrentLine.subSequence(queryStringStartIndex, sCurrentLine.length()));
							break;
						}
					}
					while((sCurrentLine = br.readLine()) != null){
						if(!sCurrentLine.contains(queryStringEndExp)){
							queryString.append(sCurrentLine);
						}else{
							break;
						}
					}
					bw.write("Query String :");
					bw.write(queryString.toString());bw.newLine();
				}
				
		}
			endTime = new Date().getTime();
			System.out.println("Total time taken : "+ (endTime - startTime) );
		} catch (IOException excp) {
			excp.printStackTrace();
		} finally {
			try {
				if (bw != null)bw.close();
				if (br != null)br.close();
			} catch (IOException excp) {
				excp.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileParser parser = new FileParser();
		parser.parseFile();
	}

}
