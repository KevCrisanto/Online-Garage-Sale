package maverick.ogs.beans;

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
	@JoinColumn(name="item_file")
	private Item fileItem;
	
	@Column(name = "filekey")
	private String filekey;
	
	public File() {
		super();
		this.fileId = UUID.randomUUID().toString();
	}
	
	public File(Item fileItem, String filekey) {
		this.fileId = UUID.randomUUID().toString();
		this.fileItem = fileItem;
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



	/**
	 * @return the fileItem
	 */
	public Item getFileItem() {
		return fileItem;
	}

	/**
	 * @param fileItem the fileItem to set
	 */
	public void setFileItem(Item fileItem) {
		this.fileItem = fileItem;
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
