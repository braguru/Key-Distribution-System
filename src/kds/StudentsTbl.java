package kds;

import java.sql.Date;

public class StudentsTbl {
	
	String name;
	String birth;
	String student_id;
	String department;
	int level;
	String email;
	String phone_number;
	String block;
	String room;
	
	public StudentsTbl(String name, String dOB, String student_id, String department, int level, String email,
			String phone_number, String block, String room) {
		super();
		this.name = name;
		this.birth = dOB;
		this.student_id = student_id;
		this.department = department;
		this.level = level;
		this.email = email;
		this.phone_number = phone_number;
		this.block = block;
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	
	



}
