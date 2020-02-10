package src.examples;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)	//on Class Level
public @interface CustomAnnotation {
	public enum Priority{
		LOW,MEDIUM,HIGH;
	}
	Priority priority() default Priority.MEDIUM;
	
	String createdBy() default "jinxed";
	
	String lastModified() default "02/28/2020";
	
}
