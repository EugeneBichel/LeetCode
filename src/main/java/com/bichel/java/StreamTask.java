package com.bichel.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class StreamTask {
    /*
int[] initial = {6, 3, -1, 2, 0, 10};
int[] target = {-1, 3, 10, 6, 2, 0};
     */

    public static void main(String[] args){
        int[] initial = {6, 3, -1, 2, 0, 10};
        //int[] target = {-1, 3, 10, 6, 2, 0};

        // num % 2 != 0
        // num % 2 == 0
        // 0

        //Future<Integer> futureTask = new Future

        Stream subArr1 = Arrays.stream(initial).filter(item -> item % 2 != 0 ).sorted().boxed();
        Stream subArr2 = Arrays.stream(initial)
                .filter(item -> item != 0 && item % 2 == 0 )
                .boxed().sorted(Comparator.reverseOrder());
        Stream<Integer> subArr3 = Arrays.stream(initial).filter(item -> item == 0 ).boxed();
        Stream<Integer> mergedFirst2 = Stream.concat(subArr1, subArr2);

        List<Integer> res =  Stream.concat(mergedFirst2, subArr3)
                .collect(Collectors.toList());

       // res.stream().

        res.forEach(item -> System.out.println(item));
    }
}

class StreamReductionDemo {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Dave", 23,20000));
        list.add(new Employee("Joe", 18,40000));
        list.add(new Employee("Ryan", 54,100000));
        list.add(new Employee("Iyan", 5,34000));
        list.add(new Employee("Ray", 63,54000));

        Optional<Integer> totalSalary = list.stream()
                .map(p -> p.getSalary())  //We are converting the Stream of Employees to Stream of salaries.
                .reduce((p,q) -> p + q);

        /*
        int totalSalary = list.stream()
                .mapToInt(p -> p.getSalary())
                .sum();
         */

        /*
        int totalSum = list.stream()
                .reduce(5, (partialSum, num) -> partialSum + num);
         */


        /*
        Optional<Integer> max = list.stream()
                .max(Comparator.naturalOrder());
         */

        /*
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("far");
        list.add("away");
        list.add("done");

        Map<String,Integer> nameMap = list.stream()
                .collect(Collectors.toMap(s -> s , s -> s.length(), (s1,s2) -> s1, HashMap::new));

        System.out.println(nameMap);
         */

        /*
        List<String> unmodifiableList = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

         */

        /*
        // Joining all the strings.
        String joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining());
        System.out.println(joinedString);

        // Joining all the strings with space in between.
        joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining(" "));
        System.out.println(joinedString);

        // Joining all the strings with space in between and a prefix and suffix.
        joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining(" " , "prefix","suffix"));
        System.out.println(joinedString);
         */

        /*
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));

        // The employees are grouped by country using the groupingBy() method.
        Map<String,List<Employee>> employeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry));

        System.out.println(employeeMap);
         */

        /*
        Map<String, Set<Employee>> employeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.toSet()));

         */

        /*
        // The employees are grouped by country and age by using the groupingBy() method twice.
        Map<String, Map<Integer,List<Employee>>> employeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, Collectors.groupingBy(Employee::getAge)));

         */

        /*
        ConcurrentMap<String,List<Employee>> employeeMap = employeeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getCountry));

        System.out.println(employeeMap);
         */

        /*
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));

        // Partitioning the list based on age.
        Map<Boolean, List<Employee>> employeeMap = employeeList.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));

        System.out.println(employeeMap);
    }
         */

        if(totalSalary.isPresent()){
            System.out.println("The total salary is " + totalSalary.get());
        }
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
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
