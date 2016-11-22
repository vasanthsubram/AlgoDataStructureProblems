package utils;

/**
 *
 * @author vsubramanian
 */
public class ObjectDumper  {
//
//	boolean hideNull=false;
//	IdentityHashMap alreadyVisited= new IdentityHashMap(1024);
//	
//	private Object dumbVal=new Object();
//
//    public ObjectDumper() {
//
//      
//    }
//
//	 private static final HashSet<Class<?>> WRAPPER_TYPES = getWrapperTypes();
//
//    public static boolean isWrapperType(Class<?> clazz){
//        return WRAPPER_TYPES.contains(clazz);
//    }
//
//    private static HashSet<Class<?>> getWrapperTypes()
//    {
//        HashSet<Class<?>> ret = new HashSet<Class<?>>();
//        ret.add(Boolean.class);
//        ret.add(Character.class);
//        ret.add(Byte.class);
//        ret.add(Short.class);
//        ret.add(Integer.class);
//        ret.add(Long.class);
//        ret.add(Float.class);
//        ret.add(Double.class);
//        ret.add(Void.class);
//		ret.add(Date.class);
//		ret.add(String.class);
//        return ret;
//    }
//
//	class VariableNameComparator implements Comparator<Field> {
//		@Override
//			public int compare(Field f1,Field f2) {
//				return f1.getName().compareTo(f2.getName());
//			}
//		}
//
//
//	private void getJobActionPerfomed(java.awt.event.ActionEvent evt) {
//
//		try {
//			alreadyVisited.clear();
//
////			String jobIdText = jobIdTextField.getText();
//                        List<Employee> list = new ArrayList<Employee>();
//                        list.add(new Employee("Name 1", 1, 1900, 1, 1));
//                        list.add(new Employee("Name 2", 2, 1900, 1, 1));
//                        list.add(new Employee("Name 3", 3, 1900, 1, 1));
//			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(list);
//			jobDetailsTree = new JTree(rootNode);
//			alreadyVisited.put(list,dumbVal);
//			displayObject(list,rootNode);
//			 treeScrollPane.setViewportView(jobDetailsTree);
//			 jobDetailsTree.expandRow(0);
//			 repaint();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	private void displayObject(Object obj, DefaultMutableTreeNode rootNode) throws Exception {
//		String nodeString = obj.getClass().getSimpleName() + " ->" + obj;
//		DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(nodeString);
//		rootNode.add(parentNode);
//
//		SortedSet<Field> fields = new TreeSet<Field>(new VariableNameComparator());
//		Class c = obj.getClass();
//
//		while (c != null) {
//			fields.addAll(Arrays.asList(c.getDeclaredFields()));
//			c = c.getSuperclass();
//		}
//
//		for (Field f : fields) {
//			f.setAccessible(true);
//			Object fieldValue = f.get(obj);
//
//			if (fieldValue == null || isWrapperType(fieldValue.getClass())) {
//				displayLeafNode(parentNode, f, fieldValue);
//				continue;
//			}
//			if (fieldValue instanceof Collection || fieldValue.getClass().isArray()) {
//				String listString = f.getName() + " ->" + fieldValue;
//				DefaultMutableTreeNode listNode = new DefaultMutableTreeNode(listString);
//				parentNode.add(listNode);
//
////				if (fieldValue instanceof Collection) {
////					for (Object o : (Collection) fieldValue) {
////						displayObject(o, listNode);
////					}
////					continue;
////				}
//				if (fieldValue.getClass().isArray()) {
//					for (Object o : Arrays.asList(fieldValue)) {
//						displayObject(o, listNode);
//					}
//					continue;
//				}
//
//			}
//			//fieldValue is an object
//			if(alreadyVisited.containsKey(fieldValue)){
//				displayLeafNode(parentNode, f, fieldValue);
//			}else{
//				alreadyVisited.put(fieldValue,dumbVal);
//				String listString = f.getName() + " ->" + fieldValue;
//				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(listString);
//				parentNode.add(newNode);
//				displayObject(fieldValue, newNode);
//			}
//		}
//	}
//
//	private void displayLeafNode(DefaultMutableTreeNode parentNode, Field f, Object obj) throws Exception {
//		String nodeString = f.getName() + " ->" + obj;
//		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(nodeString);
//		parentNode.add(childNode);
//	}
//
//    public static void main(String args[]) {
//       
//    }

}

