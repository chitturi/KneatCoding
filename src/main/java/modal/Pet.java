package modal;

import java.util.List;

public class Pet {
   
	private long id;
	private String name;
	private List<String> photoUrls = null;
	private List<Tag> tags = null;
	private String status;

	public Long getId() {
	return id;
	}

	public void setId(long id) {
	this.id = id;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public List<String> getPhotoUrls() {
	return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
	this.photoUrls = photoUrls;
	}

	public List<Tag> getTags() {
	return tags;
	}

	public void setTags(List<Tag> tags) {
	this.tags = tags;
	}

	public String getStatus() {
	return status;
	}

	public void setStatus(String status) {
	this.status = status;
	}
}
