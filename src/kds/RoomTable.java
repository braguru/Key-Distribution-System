package kds;

public class RoomTable {
	String room_type;
	String block;
	String number_of_occupants;
	String room_number;
	
	
	public RoomTable(String room_type, String block, String number_of_occupants, String room_number) {
		super();
		this.room_type = room_type;
		this.block = block;
		this.number_of_occupants = number_of_occupants;
		this.room_number = room_number;
	}


	public String getRoom_type() {
		return room_type;
	}


	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}


	public String getBlock() {
		return block;
	}


	public void setBlock(String block) {
		this.block = block;
	}


	public String getNumber_of_occupants() {
		return number_of_occupants;
	}


	public void setNumber_of_ocupants(String number_of_occupants) {
		this.number_of_occupants = number_of_occupants;
	}


	public String getRoom_number() {
		return room_number;
	}


	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}
	
	
	
}

