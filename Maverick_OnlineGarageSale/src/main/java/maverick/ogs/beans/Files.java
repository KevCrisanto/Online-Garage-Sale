package maverick.ogs.beans;

import java.sql.SQLException;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.sql.rowset.serial.SerialException;

@Entity
public class Files {
	@Id
	@Column(name = "file_id")
	private String fileId;
	
	@Column(name = "filekey")
	private String filekey;
	
	public Files() {
		super();
		this.fileId = UUID.randomUUID().toString();
	}
	
	public Files(String filekey) {
		this.fileId = UUID.randomUUID().toString();
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
