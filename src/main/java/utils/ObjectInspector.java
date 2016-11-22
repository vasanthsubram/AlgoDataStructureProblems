package utils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.lang.reflect.Field;
import java.util.*;

/**
 *
 * @author vsubramanian
 */
public class ObjectInspector extends javax.swing.JFrame {

	boolean hideNull=false;
	IdentityHashMap alreadyVisited= new IdentityHashMap(1024);
	private Object dumbVal=new Object();
    /** Creates new form ObjectInspector */
    public ObjectInspector() {

        initComponents();
    }

	 private static final HashSet<Class<?>> WRAPPER_TYPES = getWrapperTypes();

    public static boolean isWrapperType(Class<?> clazz){
        return WRAPPER_TYPES.contains(clazz);
    }

    private static HashSet<Class<?>> getWrapperTypes()
    {
        HashSet<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
		ret.add(Date.class);
		ret.add(String.class);
        return ret;
    }

	class VariableNameComparator implements Comparator<Field> {
		@Override
			public int compare(Field f1,Field f2) {
				return f1.getName().compareTo(f2.getName());
			}
		}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jobIdTextField = new javax.swing.JTextField();
        getJobButton = new javax.swing.JButton();
        treeScrollPane = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobDetailsTree = new JTree();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setName("txtJobId"); // NOI18N

        jobIdTextField.setName("jobIdTextField"); // NOI18N
        jobIdTextField.setBounds(120, 30, 120, 20);
        desktopPane.add(jobIdTextField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getJobButton.setLabel("Get Job");
        getJobButton.setName("getJobButton"); // NOI18N
        getJobButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getJobActionPerfomed(evt);
            }
        });
        getJobButton.setBounds(260, 30, 120, 23);
        desktopPane.add(getJobButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        treeScrollPane.setName("treeScrollPane"); // NOI18N

        jScrollPane1.setName("jobDetailsTree"); // NOI18N

        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("root");
        jobDetailsTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jobDetailsTree.setName("jobDetailsTree"); // NOI18N
        jobDetailsTree.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                jobDetailsTreeTreeExpanded(evt);
            }
        });
        jScrollPane1.setViewportView(jobDetailsTree);

        treeScrollPane.setViewportView(jScrollPane1);

        treeScrollPane.setBounds(40, 70, 850, 560);
        desktopPane.add(treeScrollPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Enter Job Id");
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setBounds(50, 30, 80, 14);
        desktopPane.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fileMenu.setText("File");

        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Save As ...");
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setText("Help");

        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

	private void getJobActionPerfomed(java.awt.event.ActionEvent evt) {

		try {
			alreadyVisited.clear();

//			String jobIdText = jobIdTextField.getText();
                        List<Employee> list = new ArrayList<Employee>();
                        list.add(new Employee("Name 1", 1, 1900, 1, 1));
                        list.add(new Employee("Name 2", 2, 1900, 1, 1));
                        list.add(new Employee("Name 3", 3, 1900, 1, 1));
			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(list);
			jobDetailsTree = new JTree(rootNode);
			alreadyVisited.put(list,dumbVal);
			displayObject(list,rootNode);
			 treeScrollPane.setViewportView(jobDetailsTree);
			 jobDetailsTree.expandRow(0);
			 repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jobDetailsTreeTreeExpanded(javax.swing.event.TreeExpansionEvent evt) {
		System.out.println("tree expanded");
	}

	private void displayObject(Object obj, DefaultMutableTreeNode rootNode) throws Exception {
		String nodeString = obj.getClass().getSimpleName() + " ->" + obj;
		DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(nodeString);
		rootNode.add(parentNode);

		SortedSet<Field> fields = new TreeSet<Field>(new VariableNameComparator());
		Class c = obj.getClass();

		while (c != null) {
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
			c = c.getSuperclass();
		}

		for (Field f : fields) {
			f.setAccessible(true);
			Object fieldValue = f.get(obj);

			if (fieldValue == null || isWrapperType(fieldValue.getClass())) {
				displayLeafNode(parentNode, f, fieldValue);
				continue;
			}
			if (fieldValue instanceof Collection || fieldValue.getClass().isArray()) {
				String listString = f.getName() + " ->" + fieldValue;
				DefaultMutableTreeNode listNode = new DefaultMutableTreeNode(listString);
				parentNode.add(listNode);

				if (fieldValue instanceof Collection) {
					for (Object o : (Collection) fieldValue) {
						displayObject(o, listNode);
					}
					continue;
				}
				if (fieldValue.getClass().isArray()) {
					for (Object o : Arrays.asList(fieldValue)) {
						displayObject(o, listNode);
					}
					continue;
				}

			}
			//fieldValue is an object
			if(alreadyVisited.containsKey(fieldValue)){
				displayLeafNode(parentNode, f, fieldValue);
			}else{
				alreadyVisited.put(fieldValue,dumbVal);
				String listString = f.getName() + " ->" + fieldValue;
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(listString);
				parentNode.add(newNode);
				displayObject(fieldValue, newNode);
			}
		}
	}

	private void displayLeafNode(DefaultMutableTreeNode parentNode, Field f, Object obj) throws Exception {
		String nodeString = f.getName() + " ->" + obj;
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(nodeString);
		parentNode.add(childNode);
	}

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
            public void run() {
                new ObjectInspector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton getJobButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private JTree jobDetailsTree;
    private javax.swing.JTextField jobIdTextField;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration

}
