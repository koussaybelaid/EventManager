package Controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import main.entity.Employee;

import main.entity.Role;

import main.interfaces.IEmployeeService;

import main.services.EmployeeService;

@SuppressWarnings("deprecation")
@ManagedBean(eager = true )
@SessionScoped
public class EmployeeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String Username;
	String Password;
	Role role;
	String FirstName;
	String LastName;
	Long Cin;
	Long phonenumber;


	// private List<Employee> Emplyees;
	private Integer UserId;
	public List<Employee> employees;

	@EJB
	IEmployeeService comp = new EmployeeService();

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

	

	public IEmployeeService getComp() {
		return comp;
	}

	public void setComp(IEmployeeService comp) {
		this.comp = comp;
	}

	public String addEmployee() {
		Employee e = new Employee(Username, Password, role, FirstName, LastName, Cin, phonenumber);
		comp.addEmployee(e);
		return "/Employee/UsersIndex?faces-redirect=true";
	}

	public List<Employee> getEmployees() {
		employees = comp.findAllEmployees();
		return employees;
	}

	public String removeEmployee(int id) {
		comp.removeEmployee(id);
		return "/Employee/UsersIndex?faces-redirect=true";
	}

	public String displayUsers(Employee e) {
		this.setUserId(e.getId());
		this.setFirstName(e.getFirstName());
        this.setLastName(e.getLastName());
        this.setUsername(e.getUsername());
        this.setCin(e.getCin());
        this.setPhonenumber(e.getPhonenumber());
        this.setPassword(e.getPassword());
        this.setRole(e.getRole());
        return "/Employee/Welcome?faces-redirect=true";
        
	}
	
	public String updateUser(int id) {
		Employee e = comp.findEmployeeById(UserId);
		e.setCin(Cin);
		e.setFirstName(FirstName);
		e.setLastName(LastName);
		e.setPassword(Password);
		e.setPhonenumber(phonenumber);
		e.setUsername(Username);
		e.setRole(role);
		comp.updateEmployee(e);
		return "/Employee/UsersIndex?faces-redirect=true";
	}
	
	public String returnaction () {
		System.out.println("d5aaaal");
		 return "/Employee/Welcome?faces-redirect=true";
				
	}
}
