package kds;

public class StaffTable {
	String name;
	String birth;
	String staff_id;
	String email;
	String phone_number;
	String Gender;
	
	public StaffTable(String name,String gender, String birth, String staff_id, String phone_number, String email) {
		super();
		this.name = name;
		this.Gender = gender;
		this.birth = birth;
		this.staff_id = staff_id;
		this.phone_number = phone_number;
		this.email = email;
		
	
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

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
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

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}
	
	
}
