package main.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;



@Entity(name="Employee")
 
public class Employee implements Serializable {
	/**
	 *  
	 */
	private static final long serialVersionUID = 3879079015656042767L;
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	@Column(name="U_ID")
	int id;
	@Column(name="U_NAME")
	String  Username;
	@Column(name="U_PASSSWORD")
	String Password;

	@Column(name="U_Role")
	@Enumerated(EnumType.STRING)
	Role role;
	@Column(name="U_FirstName")
	String FirstName; 
	@Column(name="U_LastName")
	String LastName; 
	@Column(name="U_Cin")
	Long Cin;
	@Column(name="U_PhoneNumber")
	Long phonenumber;

	
	public Employee(String username, String password, Role role, String firstName, String lastName, Long cin,
			Long phonenumber) {
		super();
		this.Username=username;
		this.Password=password;
		this.role=role;
		this.FirstName=firstName;
		this.LastName=lastName;
		this.Cin=cin;
		this.phonenumber=phonenumber;
		
		// TODO Auto-generated constructor stub
	}
	public Employee() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Long getCin() {
		return Cin;
	}
	public void setCin(Long cin) {
		Cin = cin;
	}
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	} 
	

}
