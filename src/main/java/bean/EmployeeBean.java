package bean;

import dao.MtEmployeeDAO;
import model.MtEmployee;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EmployeeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private List<MtEmployee> employees;

    @PostConstruct
    public void init() {
        try {
            MtEmployeeDAO dao = new MtEmployeeDAO();
            employees = dao.getAllEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MtEmployee> getEmployees() {
        return employees;
    }
}
