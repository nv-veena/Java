package streams.examples;
import java.util.Arrays;
/* This class provides sample examples for Java8 features 
 * 
 */
import java.util.stream.*;
import java.util.*;
class Employee{
	int employeeId;
	String employeeName;
	int salary;
	public Employee(int id,String name,int salary) {
		this.employeeId=id;this.employeeName=name;this.salary=salary;
	}
}

public class StreamsExamples {

	public static void main(String[] args) {
		
		//		Filter Array of Names by certain alphabet and then sort lexicographically and display	
		String[] names= {"Alex","Bob","Anke","Phil","Aristro","Azzy","Amy","Sara","Williams","carrie"};
		Arrays.stream(names)
		      .filter(s -> s.startsWith("A"))
		      .sorted()
		      .forEach(System.out::println);
		
		System.out.println("====================================");
		
//		Filter Array of Names by certain alphabet and then print first element if present	
		String[] namesOfPeople= {"Alex","Bob","Anke","Phil","Aristro","Azzy","Amy","Sara","Williams","carrie"};
		Arrays.stream(names)
		      .filter(s -> s.startsWith("A"))
		      .findFirst()
		      .ifPresent(System.out::println);
		
		System.out.println("====================================");
		
		//Take squares of numbers and print them
		Arrays.stream(new int[] {2,3,4,5,6})
		      .map(x -> x*x)
		      .forEach(System.out::println);
			
		System.out.println("====================================");
		
		//For a List of Employees, filter and sort them and finally display the Employee names
		 List<Employee> staff = Arrays.asList(
				 new Employee(10,"Paul Antonio",70000),
				 new Employee(30,"Gary Williams",71000),
				 new Employee(15,"Emma Stone",70000),
				 new Employee(21,"Laura Stevenson",80000),
				 new Employee(45,"Manny Johnson",73000)
	        );
		 
		 staff.stream()
		 	   .filter( s -> s.employeeId<=30)
		 	   .map(x -> x.employeeName)
		 	   .forEach(System.out::println);
		 
		 System.out.println("====================================");
		 
		 
		//For a List of Employees, filter and sort using custom comparator  and finally display the Employee names
		 List<Employee> staffs = Arrays.asList(
				 new Employee(10,"Paul Antonio",70000),
				 new Employee(30,"Gary Williams",71000),
				 new Employee(15,"Emma Stone",70000),
				 new Employee(21,"Laura Stevenson",79000),
				 new Employee(45,"Manny Johnson",73000),
				 new Employee(55,"Kiara Mattis",69000)
	        );
		 
		 Comparator<Employee> employeeComp=new Comparator<Employee>(){
			
					public int compare(Employee a,Employee b) {
						return a.salary - b.salary;
					}
		 };
		
		 staffs.stream()
		 	   .sorted(employeeComp)
		 	   .map(x -> x.employeeName)
		 	   .forEach(System.out::println);

	}
	
}
