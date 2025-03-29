package Java_base_hw5;

import java.util.*;
import java.util.stream.Collectors;

public class Stream_API {
    public static void main(String[] args) {
        List<Project> emp1projects = new ArrayList<>();
        Project emp1project1 = new Project("projectA", 12);
        Project emp1project2 = new Project("projectB", 6);
        emp1projects.add(emp1project1);
        emp1projects.add(emp1project2);
        Employee emp1 = new Employee("Ivan", 28, emp1projects, 55_000);

        List<Project> emp2projects = new ArrayList<>();
        Project emp2project1 = new Project("projectC", 4);
        Project emp2project2 = new Project("projectD", 8);
        emp2projects.add(emp2project1);
        emp2projects.add(emp2project2);
        Employee emp2 = new Employee("Mariya", 37, emp2projects, 80_000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);

        Map<String, Double> filteredList =  employeeList.stream()
                .filter(emp -> emp.getAge() >= 30 && emp.getAge() <= 50 && emp.getSalary() > 60_000)
                .flatMap(emp -> emp.getProjects().stream())
                .filter(proj -> proj.getDuration() > 6)
                .sorted(Comparator.comparingInt(Project::getDuration).reversed())
                .collect(Collectors.groupingBy(proj -> proj.getName().toUpperCase(), Collectors.averagingInt(Project::getDuration)));
        System.out.println(filteredList);
    }

}
