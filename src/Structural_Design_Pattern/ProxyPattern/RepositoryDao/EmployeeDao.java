package Structural_Design_Pattern.ProxyPattern.RepositoryDao;

import Structural_Design_Pattern.ProxyPattern.Model.EmployeeDo;

public interface EmployeeDao {
    void create(String client, EmployeeDo employeeDo) throws Exception;
    void delete(String client, int employeeId) throws Exception;
    EmployeeDo get(String client, int employeeId) throws Exception;
}
