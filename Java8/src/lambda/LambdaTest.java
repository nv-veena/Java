package lambda;
/*
 * A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, 
 * but they do not need a name and they can be implemented right in the body of a method. parameter -> expression
 * To use more than one parameter, wrap them in parentheses: (parameter1, parameter2) -> expression
 * 
 * 
 * Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or 
 * statements such as if or for. In order to do more complex operations, a code block can be used with curly braces. 
 * If the lambda expression needs to return a value, then the code block should have a return statement.
 * (parameter1, parameter2) -> { code block }
 * 
 * 
 * 
 * Lambda expressions can be stored in variables if the variable's type is an interface which has only one method. 
 * The lambda expression should have the same number of parameters and the same return type as that method. Java 
 * has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) used by lists.
 */
import java.util.*;
import java.util.stream.Collectors;

import lambda.Book;
interface StringFunction{
	String run(String s);
}
public class LambdaTest {

	public static void main(String[] args) {
		
		List<String> names= Arrays.asList("Paul","Roger","Amy","Sean","Beckie");
		
		Collections.sort(names,(a,b)-> a.compareTo(b));
		
		System.out.println(names.toString());
		
		Book book1 = new Book("Harry Potter and Sorcerer stone","JK","Rowling",300);
		Book book2 = new Book("God of small things","Arundathi","Roy",500);
		Book book3 = new Book("Namesake","Jhumpa","Lahiri",800);
		
		List<Book> books = Arrays.asList(book1,book2,book3);
		int totalPages = books.stream()
						.collect(Collectors.summingInt(Book::getPages));
		System.out.println("Total pages of all books :" + totalPages);
		
		
		List<Book> duplicateBooks = Arrays.asList(book1,book3,book2,book1);
		System.out.println("List with duplicate books :" + duplicateBooks.toString());
		
		
		//Aggregate list of books by Authors
		List<String> bookAuthors = books.stream()
								   .map(Book::getAuthorLName)
								   .collect(Collectors.toList());
		System.out.println("List of books collected by Author name :" + bookAuthors);
		
		//Test Lamda expressions using Functional Interface
		StringFunction exclaim = (s) -> s + "!";
		StringFunction ask = (s) -> s + "?";
		
		printFormatted("Hello", exclaim);
		printFormatted("Hello", ask);

	}
	public static void printFormatted(String str,StringFunction format) {
		String result = format.run(str);
		System.out.println(result);
	}
}
