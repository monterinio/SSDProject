package pl.pwr.miki.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report_detail")
public class ReportDetailModel {
	@Id
	@Column(name = "hash_value")
	private long hashValue;

	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "file")
	private byte[] file;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getHashValue() {
		return hashValue;
	}
	public void setHashValue(long hashValue) {
		this.hashValue = hashValue;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
}
