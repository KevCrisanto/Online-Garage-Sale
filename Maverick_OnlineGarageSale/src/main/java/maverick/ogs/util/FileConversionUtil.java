package maverick.ogs.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileConversionUtil {
	public static byte[] fileToBlob(String filePath) {
		byte[] fileContent = null;
		
		try {
			File file = new File(filePath);
			fileContent = FileUtils.readFileToByteArray(file);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}

}
