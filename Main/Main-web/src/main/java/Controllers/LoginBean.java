package Controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceHandler;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.entity.Employee;
import main.interfaces.IEmployeeService;
import main.services.EmployeeService;

@javax.faces.bean.ManagedBean
@SessionScoped
public class LoginBean implements Serializable ,Filter{
	




	public void setEmployeeservice(IEmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}
	private String username;	
    private String password;
    private Employee emp;
	
    public String getUsername() {
    	System.out.println(username);
		return username;
	}

	public void setUsername(String user) {
		System.out.println(user);
		this.username = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public IEmployeeService getEmployeeservice() {
		return employeeservice;
	}
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8213090999527726096L;
@EJB
IEmployeeService employeeservice = new EmployeeService();

public String doLogin() {
	System.out.println(username);
	
	    emp = employeeservice.EmployeeAuth(username, password);
       FacesContext context = FacesContext.getCurrentInstance();

       if (emp == null) {
           context.addMessage(null, new FacesMessage("Unknown login, try again"));
           username = null;
           password = null;
           return null;
       } else {
           context.getExternalContext().getSessionMap().put("user", emp);
           return "Employee/UsersIndex?faces-redirect=true";
       }
	


}

public String logout() {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "login?faces-redirect=true";
}


@Override
public void init(FilterConfig filterConfig) throws ServletException {
	// TODO Auto-generated method stub
	
}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
	 HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    HttpSession session = request.getSession(false);
	    String loginURI = request.getContextPath() + "/login.xhtml";

	    boolean loggedIn = session != null && session.getAttribute("user") != null;
	    boolean loginRequest = request.getRequestURI().equals(loginURI);
	    boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

	    if (loggedIn || loginRequest || resourceRequest) {
	        chain.doFilter(request, response);
	    } else {
	        response.sendRedirect(loginURI);
	    }
	
}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

}
