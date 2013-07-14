/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raam
 */
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import testing_html_parsing.Testing_HTML_Parsing;

public class Test1 {
 public static void main(String[] args) {    
        try {

                           
               File input = new File("C:\\Users\\Raam\\Desktop\\Notepad++\\JavaScript\\test.html"); // To load and parse a file from local drive
                Document doc = Jsoup.parse(input, "UTF-8", "") ; // For local Html file
//               Elements links = doc.select("a[href]"); // To pick by href tag in a webpgae
//               Elements media = doc.select("[src]"); // To pick by src tag used for linking images
               
              // Elements ele = doc.select("div.col1.pr-box"); 
               Elements title = doc.getElementsByTag("title");
              // Elements para = doc.getElementsByTag("p");
               
//               String n = title.text();
//               String m = para.text();
//               String o = ByClass.text();
               Elements para_in_Div  = doc.select("div:eq(2) p:eq(1)");
               String s = para_in_Div.text();
                //JOptionPane.showMessageDialog(null, s); 
                
                Elements table = doc.select("#orange p:eq(1)");
                String d = table.text();
               JOptionPane.showMessageDialog(null, d); 
                
                Element tab = doc.select("table tr:eq(1) td:eq(1)").first();
                JOptionPane.showMessageDialog(null, tab.text()); 
        } catch (IOException ex) {
            Logger.getLogger(Testing_HTML_Parsing.class.getName()).log(Level.SEVERE, null, ex);
        } }
       
}
