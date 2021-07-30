package Response;

public class ResponsePojo {

	private String kind;
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHtmlLink() {
		return htmlLink;
	}
	public void setHtmlLink(String htmlLink) {
		this.htmlLink = htmlLink;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	public Organizer getOrganizer() {
		return organizer;
	}
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	public Start getStart() {
		return start;
	}
	public void setStart(Start start) {
		this.start = start;
	}
	public End getEnd() {
		return end;
	}
	public void setEnd(End end) {
		this.end = end;
	}
	public String getiCalUID() {
		return iCalUID;
	}
	public void setiCalUID(String iCalUID) {
		this.iCalUID = iCalUID;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Reminders getReminders() {
		return reminders;
	}
	public void setReminders(Reminders reminders) {
		this.reminders = reminders;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	private String etag;
	private String id;
	private String status;
	private String htmlLink;
	private String created;
	private String updated;
	private String summary;
	private Creator creator;
private Organizer organizer;
private String  description;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
private Start start;
private End end;
private String iCalUID;
private Integer sequence;
private Reminders reminders;
private String eventType;



}
