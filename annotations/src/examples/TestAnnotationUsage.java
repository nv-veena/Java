package examples;

import examples.CustomAnnotation.*;
import examples.CustomAnnotation1;


@CustomAnnotation(
	priority = Priority.HIGH,
	createdBy = "v"	
)
public class TestAnnotationUsage {
	@CustomAnnotation1
	void testA() {
		if(true)
			throw new RuntimeException("TestA");
	}
	
	@CustomAnnotation1(enabled=false)
	void testB() {
		if(false)
			throw new RuntimeException("testB");
	}
}
