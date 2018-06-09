package test.lrx;

import java.lang.reflect.Field;
import java.util.Arrays;

public class TestInjection {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Ant ant = new Ant();
		Field fs[] = ant.getClass().getDeclaredFields();
		System.out.println(fs.length);
		for (int i = 0; i < fs.length; i++) {
			System.out.println(i+"\n");
			
			Field f = fs[i];
			f.setAccessible(true);
			if (f.getDeclaredAnnotations().length > 0) {
				System.out.println(f.getAnnotations()[0].annotationType());
			}
			//if (f.getDeclaredAnnotations().length >0 && "MyInject".equals(f.getDeclaredAnnotations()[0])) {
				f.set(ant, "hello inject!");
			//}
		}
		
		System.out.println(ant);

	}
	
}
