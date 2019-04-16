package com.zfg.test.javatest;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zfg on 2019/4/15
 * java8 lambda 表达式
 */
public class LambdaTest {

    @SuppressLint("NewApi")
    public static void main(String[] strings) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 26, 6000),
                new Employee("李四", 28, 5000),
                new Employee("王五", 21, 5500),
                new Employee("赵六", 21, 3500)
        );
        filterEmploy(employees, new FilterEmployeeByAge());
        System.out.println();
        filterEmploy(employees, new FilterEmployeeBySalary());
        System.out.println();
//        可以直接传  使用lambda表达式
        filterEmploy(employees, employee -> employee.getSalary() > 4000);
        System.out.println("____");
//这句话最简洁  使用流  Stream-API
        employees.stream().filter(employee -> employee.getSalary() > 4000).forEach(System.out::println);

        System.out.println("____");
//        按年龄从小到大排列，年龄相同按照姓名排名
        Collections.sort(employees, (o1, o2) -> {
                    if (o1.getAge() == o2.getAge()) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
        employees.forEach(System.out::println);
    }

    public static List<Employee> filterEmploy(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee e : list) {
            if (mp.test(e)) {
                employeeList.add(e);
                System.out.println(e.toString());
            }
        }
        return employeeList;
    }

    public static class Employee {
        private String name;
        private int age;
        private double salary;

        public Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static class FilterEmployeeByAge implements MyPredicate<Employee> {
        @Override
        public boolean test(Employee employee) {
            return employee.getAge() > 25;
        }
    }

    public static class FilterEmployeeBySalary implements MyPredicate<Employee> {

        @Override
        public boolean test(Employee employee) {
            return employee.getSalary() > 4000;
        }
    }

    public interface MyPredicate<T> {
        public boolean test(T t);
    }
}