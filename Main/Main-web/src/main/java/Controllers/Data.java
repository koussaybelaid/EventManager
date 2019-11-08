package Controllers;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import main.entity.Role;

@ManagedBean(name ="dataff")
@ApplicationScoped
public class Data implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 85873L;
	
	public Role[] getRole() {
		return Role.values();
	}

}
