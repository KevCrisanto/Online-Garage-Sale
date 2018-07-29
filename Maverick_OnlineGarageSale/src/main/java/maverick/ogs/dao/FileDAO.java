package maverick.ogs.dao;

import maverick.ogs.beans.File;

public interface FileDAO {
	public String insertFile(File file);
	public File getFileById(String Id);
	public Boolean updateFileById(String itemId, File newFile);
	public Boolean deleteFileById(String fileId);
	

}
