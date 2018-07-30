package maverick.ogs.beans;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.sql.rowset.serial.SerialException;

public class File {
	@Id
	@Column(name = "file_id")
	private String fileId;
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private String itemId;
	
	@Column(name = "filekey")
	private String filekey;
	
	public File() {
		super();
		this.fileId = UUID.randomUUID().toString();
	}
	
	public File(String itemId, String filekey) {
		this.fileId = UUID.randomUUID().toString();
		this.itemId = itemId;
		this.filekey = filekey;
	}
	
//	public File(String itemId, byte[] file) {
//		try {
//			this.fileId = UUID.randomUUID().toString();
//			this.itemId = itemId;
//			this.file = new javax.sql.rowset.serial.SerialBlob(file);
//		} catch (SerialException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the filekey
	 */
	public String getFilekey() {
		return filekey;
	}

	/**
	 * @param filekey the filekey to set
	 */
	public void setFilekey(String filekey) {
		this.filekey = filekey;
	}


	
	
}
