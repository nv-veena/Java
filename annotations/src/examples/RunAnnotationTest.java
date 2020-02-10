package examples;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import examples.CustomAnnotation1;
import examples.CustomAnnotation;

public class RunAnnotationTest {

	public static void main(String[] args) {
		System.out.println("Testing...");
		int passed = 0, failed = 0, count = 0, ignore = 0;
		Class<TestAnnotationUsage> obj=TestAnnotationUsage.class;
		
		if(obj.isAnnotationPresent(CustomAnnotation1.class)) {
			
			Annotation annotationObj=obj.getAnnotation(CustomAnnotation.class);
			
			CustomAnnotation customAnnotation = (CustomAnnotation)annotationObj;
			
			System.out.println("Priority :" + customAnnotation.priority());
			System.out.println("Priority :" + customAnnotation.createdBy());
			System.out.println("Priority :" + customAnnotation.lastModified());
		}
		for(Method method:obj.getDeclaredMethods()) {
			if(method.isAnnotationPresent(CustomAnnotation1.class)) {
				Annotation annotation=method.getAnnotation(CustomAnnotation1.class);
				CustomAnnotation1 customAnnotation1 = (CustomAnnotation1)annotation;
				
				if(customAnnotation1.enabled()) {
					// if enabled = true (default)
					if (customAnnotation1.enabled()) {

					  try {
						method.invoke(obj.newInstance());
						System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
						passed++;
					  } catch (Throwable ex) {
						System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
						failed++;
					  }

					} else {
						System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
						ignore++;
					}
				}
				
			}
		}
		System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);	
	}

}
