package Controllers;

import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;
import main.entity.Employee;
import main.interfaces.IEmployeeService;
import main.services.EmployeeService;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped

public class ChartView  {
	private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    @EJB
    IEmployeeService topicService = new EmployeeService();
 
    @PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
    	List<Employee>topics=topicService.getlist();
        pieModel1 = new PieChartModel();
         for(int i=0;i<topics.size();i++)
         { pieModel1.set(topics.get(i).getRole().toString(), topicService.nbtopicpardomain(topics.get(i).getRole().toString()));
        }
         
        pieModel1.setTitle("Simple");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
     
    private void createPieModel2() {
    	List<Employee>topics=topicService.getlist();
        pieModel2 = new PieChartModel();
         
        for(int i=0;i<topics.size();i++)
        { pieModel2.set(topics.get(i).getFirstName(), topicService.nbtopicpardomain(topics.get(i).getFirstName()));
       }
        pieModel2.setTitle("Personnalisé");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        pieModel2.setShadow(false);
    }
}