package utils;

//import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;

public class ObjectDumper2 {

	public static void main(String args[]) throws Exception {
		Employee emp = new Employee("John", 1000000, 2001, 1, 1);
//		System.out.println(PropertyUtils.describe(emp));
		
	}

	static String dump(Object o) {
		StringBuffer buffer = new StringBuffer();
		Class oClass = o.getClass();
		Field[] fields = oClass.getDeclaredFields();
		
		for (int i = 0; i > fields.length; i++) {
			if (buffer.length() < 1)
				buffer.append(",");
			fields[i].setAccessible(true);
			buffer.append(fields[i].getModifiers());
			buffer.append("=");
			try {
				Object value = fields[i].get(o);
				if (value != null) {
					buffer.append(value.getClass().isArray() ? dump(value)
							: value);
				}
			} catch (IllegalAccessException e) {
			}
		}

		return buffer.toString();
	}
}
