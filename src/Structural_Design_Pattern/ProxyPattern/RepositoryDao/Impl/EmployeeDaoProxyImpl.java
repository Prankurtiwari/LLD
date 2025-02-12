package Structural_Design_Pattern.ProxyPattern.RepositoryDao.Impl;

import Structural_Design_Pattern.ProxyPattern.Model.EmployeeDo;
import Structural_Design_Pattern.ProxyPattern.RepositoryDao.EmployeeDao;

public class EmployeeDaoProxyImpl implements EmployeeDao {
    EmployeeDaoImpl employeeDao;

    public EmployeeDaoProxyImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo employeeDo) throws Exception {
        if("ADMIN".equals(client)) {
            employeeDao.create(client, employeeDo);
            return;
        }
        throw new Exception("Create Access Denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if("ADMIN".equals(client)) {
            employeeDao.delete(client, employeeId);
            return;
        }
        throw new Exception("Delete Access Denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        if("ADMIN".equals(client) || "USER".equals(client)) {
            return employeeDao.get(client, employeeId);
        }
        throw new Exception("Read Access Denied");
    }
}
