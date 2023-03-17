package skp;


public class LogTable {
	String room;
	String name;
	String date;
	String status;
	
	public LogTable(String room, String name, String date, String status) {
		super();
		this.room = room;
		this.name = name;
		this.date = date;
		this.status = status;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

