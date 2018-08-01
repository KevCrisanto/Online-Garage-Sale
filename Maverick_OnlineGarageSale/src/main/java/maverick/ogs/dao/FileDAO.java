package maverick.ogs.dao;

import maverick.ogs.beans.Files;

public interface FileDAO {
	public String insertFile(Files file);
	public Files getFileById(String Id);
	public Boolean updateFileById(String itemId, Files newFile);
	public Boolean deleteFileById(String fileId);
	

}
