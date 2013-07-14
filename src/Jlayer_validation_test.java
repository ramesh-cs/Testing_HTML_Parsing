import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
public class Jlayer_validation_test {
    
    private static JComponent createContent()
{
LayerUI<JFormattedTextField> layerUI = new ValidationLayerUI();

JLabel lblName = new JLabel("Number:");
JFormattedTextField txtName = new JFormattedTextField(new Long(25));
txtName.setColumns(16); 
txtName.setFocusLostBehavior(JFormattedTextField.PERSIST); 
txtName.setValue(25); 
JPanel panel1 = new JPanel();
panel1.setLayout(new GridLayout(2,1));
panel1.add(lblName);
panel1.add(new JLayer<JFormattedTextField>(txtName, layerUI));

JLabel dateLabel = new JLabel("Date:"); 
panel1.add(dateLabel); 
DateFormat dateFormat = DateFormat.getDateInstance(); 
JFormattedTextField dateField = new JFormattedTextField(dateFormat); 
dateField.setColumns(16); 
dateField.setFocusLostBehavior(JFormattedTextField.PERSIST); 
dateField.setValue(new java.util.Date()); 

panel1.add(dateLabel); 
panel1.add(new JLayer<JFormattedTextField>(dateField, layerUI)); 
return panel1;
}
    
    public static void createUI() {

JFrame f = new JFrame ("FieldValidator");
JComponent content = createContent();
f.add (content); f.pack();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLocationRelativeTo (null);
f.setVisible (true);
}
    public static void main(String[] args) 
{ 
javax.swing.SwingUtilities.invokeLater(new Runnable() 
{ public void run() { 
createUI(); 
} }); 
}
}