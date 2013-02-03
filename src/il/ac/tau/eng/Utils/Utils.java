package il.ac.tau.eng.Utils;

public class Utils {
	
	public static String createCsvLine(String line)
	{
		StringBuilder csvLineSb = new StringBuilder("");
		try {
			line = line.replaceAll("\n", ",");
			line = line.replaceAll("\t", "");
			String splitArray[] = line.split(",");
			
			for (int i = 0; i < splitArray.length ; i++) {
				String twoWord[] = splitArray[i].trim().split("=");
				csvLineSb.append(twoWord[1]);
				csvLineSb.append(", ");
			}
		} catch (Exception e){
			
		}
		
		return csvLineSb.toString();
	}
	
	public static String getTimeDiff(long start, long end) {
        long milliseconds = end - start;
		int seconds = (int) (milliseconds / 1000) % 60 ;
		int minutes = (int) ((milliseconds / (1000*60)) % 60);

		return (minutes < 10 ? ("0"+minutes) : minutes) + ":" + (seconds < 10 ? ("0"+seconds) : seconds);
	}

}
