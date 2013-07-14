
import java.sql.*;
import javax.swing.*;

import java.awt.Frame;
import java.io.FileOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

import javax.swing.text.StyledEditorKit;
import org.netbeans.validation.api.AbstractValidator;
import org.netbeans.validation.api.ui.swing.ValidationPanel;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.Validator;
import org.netbeans.validation.api.AbstractValidator;
import org.netbeans.validation.api.ValidatorUtils;
import org.netbeans.validation.api.*;
import org.netbeans.validation.*;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.swing.SwingValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel.*;
public class Validation_test {
    public static void main(String[] args) {

JPanel inner = new JPanel();

JLabel lbl = new JLabel("Enter a URL");

JTextField f = new JTextField();

f.setColumns(40);

//Setting the component name is important - it is used in

//error messages

f.setName("URL");

inner.add(lbl);

inner.add(f);

//Create a ValidationPanel - this is a panel that will show

//any problem with the input at the bottom with an icon

ValidationPanel panel = new ValidationPanel();

panel.setInnerComponent(inner);

 ValidationGroup group = panel.getValidationGroup();
//SwingValidationGroup group =  SwingValidationGroup.create();
//This is all we do to validate the URL:

group.add(f, StringValidators.REQUIRE_NON_EMPTY_STRING,

StringValidators.NO_WHITESPACE,

StringValidators.URL_MUST_BE_VALID);

//Convenience method to show a simple dialog

if (panel.showOkCancelDialog("URL")) {

System.out.println("User clicked OK.  URL is " + f.getText());

System.exit(0);

} else {

System.err.println("User clicked cancel.");

System.exit(1);

}

}
}
