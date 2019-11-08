package main.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import main.entity.Employee;
import main.entity.Role;
import main.interfaces.IEmployeeService;

@Stateless


public class EmployeeService implements IEmployeeService {
	@PersistenceContext(unitName="hr-ejb")
	

	EntityManager em ; 
	@Override
	public void addEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		em.persist(Employee);
	}

	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Employee.class, id));
	}

	@Override
	public void updateEmployee(Employee Employee) {
		// TODO Auto-generated method stub
		Employee f = em.find(Employee.class, Employee.getId());
		f.setCin(Employee.getCin());
		f.setFirstName(Employee.getFirstName());
		f.setLastName(Employee.getLastName());
		f.setPassword(Employee.getPassword());
		f.setPhonenumber(Employee.getPhonenumber());
		f.setUsername(Employee.getUsername());
		f.setRole(Employee.getRole());
		
		
	}

	@Override
	public Employee findEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee f= em.find(Employee.class, id);
		return f;
	
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> f= em.createQuery("Select e from Employee e", Employee.class).getResultList();
		return f;
	}

	@Override
	public Employee EmployeeAuth(String user, String password) {
		System.out.println("d5al");
		TypedQuery<Employee> query =
				em.createQuery("SELECT u FROM Employee u WHERE u.Username=:user AND u.Password=:password ",
				Employee.class);
				query.setParameter("user", user);
				query.setParameter("password", password);
				Employee emp = null;
				try { emp = query.getSingleResult(); }
				catch (Exception e) { System.out.println("Erreur : " + e); }	
				System.out.println(user.toString());
				return emp;		
	}
	
	@Override
	public List<Employee> getlist(){
		TypedQuery<Employee> query=em.createQuery("Select e from Employee e",Employee.class);
		return query.getResultList();
		
	} 
	@Override
	public Long nbtopicpardomain(String dom) {
		TypedQuery<Long> query = em.createQuery("Select count(q) from Employee q where q.FirstName=: dom",Long.class);
		query.setParameter("dom",dom);
		return query.getSingleResult();
	}

	
	

}
