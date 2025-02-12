package Structural_Design_Pattern.ProxyPattern;

import Structural_Design_Pattern.ProxyPattern.Model.EmployeeDo;
import Structural_Design_Pattern.ProxyPattern.RepositoryDao.EmployeeDao;
import Structural_Design_Pattern.ProxyPattern.RepositoryDao.Impl.EmployeeDaoProxyImpl;

public class ProxyPatternDesign {

    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = new EmployeeDaoProxyImpl();
            employeeDao.create("ADMIN", new EmployeeDo());
            System.out.println("operation successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
