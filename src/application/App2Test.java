package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class App2Test {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    System.out.println("===== Test 1: department insert =====");
    Department newdepartment = new Department(null, "Music");
    departmentDao.insert(newdepartment);
    System.out.println("Inserted! new id = " + newdepartment.getId());

    System.out.println("===== Test 2: department update =====");
    Department dep = departmentDao.findById(1);
    dep.setName("Food");
    departmentDao.update(dep);
    System.out.println("Update completed");

    System.out.println("===== Test 3: department findById =====");
    Department dep2 = departmentDao.findById(3);
    System.out.println(dep2);

    System.out.println("===== Test 4: department findAll =====");
    List<Department> list = departmentDao.findAll();
    for (Department de : list) {
      System.out.println(de);
    }
    
    System.out.println("===== Test 5: department delete =====");
    System.out.println("Enter id for delete test: ");
    int id = sc.nextInt();
    departmentDao.deleteById(id);
    System.out.println("Delete completed");

    sc.close();
  }
}
