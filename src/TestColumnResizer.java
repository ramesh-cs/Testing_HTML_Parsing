import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestColumnResizer {
 final static Object[][] TABLE_DATA = {
   { new Integer(1), "Nirav Raval", "http://www.niravjavadeveloper.blogspot.com/" },
   { new Integer(2), "Java Web", "http://www.java2s.com/" },
   { new Integer(3), "Java 2d Effects","http://www.daniweb.com/" },
   { new Integer(4), "Java Swing", "http://www.onjava.com/"},  
   { new Integer(5), "QTJ book", "http://www.oreilly.com/catalog/" } } ;

 final static String[] COLUMN_NAMES = { "Count", "Name", "URL" };

 public static void main(String[] args) {

  DefaultTableModel mod = new DefaultTableModel(TABLE_DATA, COLUMN_NAMES);
  JTable table = new JTable(mod);

  JScrollPane pane = new JScrollPane(table,
    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

  JFrame frame = new JFrame("JTable Column Widths");
  frame.setSize(500, 400);
  frame.getContentPane().add(pane);

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  
  //Waiting For 3 Seconds and then adjust the width of Columns....
  // You can delete this try...catch block if you wish to.
  try {
   Thread.sleep(3000);
  } catch (Exception e) {
   e.printStackTrace();
  }

  // setting of columns widths done here
  final JTable fTable = table;
  SwingUtilities.invokeLater(new Runnable() {

   public void run() {
    ColumnResizer.adjustColumnPreferredWidths(fTable);
    fTable.revalidate();
   }
  });
 }
}
