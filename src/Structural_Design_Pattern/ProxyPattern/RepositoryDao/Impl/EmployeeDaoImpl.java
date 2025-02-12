package Structural_Design_Pattern.ProxyPattern.RepositoryDao.Impl;

import Structural_Design_Pattern.ProxyPattern.Model.EmployeeDo;
import Structural_Design_Pattern.ProxyPattern.RepositoryDao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDo employeeDo) throws Exception {
        System.out.println("create new using actual impl");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("delete new using actual impl");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        System.out.println("fetch data from actual impl");
        return new EmployeeDo();

    }
}
