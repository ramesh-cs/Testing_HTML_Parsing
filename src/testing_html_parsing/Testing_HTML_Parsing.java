/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_html_parsing;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Testing_HTML_Parsing extends javax.swing.JFrame {

    public static void main(String[] args) {
        Testing_HTML_Parsing TH = new Testing_HTML_Parsing();
//        TH.GetNews();
        TH.GetScores();
        
    }
    
    public void GetScores(){
            try {

               String url = "http://www.planet-rugby.co.za/rugby-union-competitions/six-nations";
               
               //File input = new File("C:\\Users\\Raam\\Desktop\\Notepad++\\JavaScript\\test.html"); // To load and parse a file from local drive
               //Document doc = Jsoup.parse(input, "UTF-8", "") ; // For local Html file
//               Elements links = doc.select("a[href]"); // To pick by href tag in a webpgae
//               Elements media = doc.select("[src]"); // To pick by src tag used for linking images
//               Elements get_para = doc.select(".pr-wrap .pr-content .pr-cols-3col .col1 .pr-topstory p"); 
               //String m = para.text();
               //String o = ByClass.text();
//                JOptionPane.showMessageDialog(null, "Linksize: " + links.size());  
//                int n = JOptionPane.showConfirmDialog(null, "Continue??", "Question", JOptionPane.YES_NO_OPTION);
//                if(n==JOptionPane.YES_OPTION) {
//                    for(Element link : links){
//                    
//                    JOptionPane.showMessageDialog(null, "Link: " + link.attr("abs:href") + trim(link.text(), 35));
//                    } 
//                } else {
//                for(Element link : links){
//                    
//                    JOptionPane.showMessageDialog(null, "Link: " + link.attr("abs:href") + trim(link.text(), 35));
//                    break;
//                } }
//                
//                for(Element src : media){
//                    if(src.tagName().equals("img")){
//                    JOptionPane.showMessageDialog(null, "Image: "+ src.tagName() +"Link" +src.attr("abs:src") +  "Size: Width is " + src.attr("width")+ " and Height is "+ src.attr("height") + trim(src.attr("alt"), 30));
//                    } else {
//                    JOptionPane.showMessageDialog(null,"Image: "+ src.tagName()+ " "+ src.attr("abs:src"));
//                    }
//                    
//                }             
               //JOptionPane.showMessageDialog(null, o); 
               
          Document doc = Jsoup.connect(url). timeout(90000).get();
           Elements table = doc.select(".pr-wrap .pr-content .pr-cols-3col .col2 .pr-tabs #section-1 .pr-tabs-scroll .pr-tabs-style2"); 
           JOptionPane.showMessageDialog(null, table.text()); 
           SplitScorCard(table.text());
        } catch (IOException ex) {
            Logger.getLogger(Testing_HTML_Parsing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void GetNews(){
    try {

//               String url = "http://www.planet-rugby.co.za/tables/0,25806,3824,00.html#3824";
        String url = "http://www.planet-rugby.co.za/news/";
               Document doc = Jsoup.connect(url). timeout(90000).get();
//               Elements heading = doc.select("div.pr-wrap div.pr-content div.pr-cols-3col div.col1 h1"); 
//               JOptionPane.showMessageDialog(null, heading.text()); 
               Elements news1 = doc.select("div.pr-wrap div.pr-content div.pr-cols-3col div.col1 div.pr-box.news p"); 
               JOptionPane.showMessageDialog(null, news1.text()); 
               Split(news1.text());
    }
    catch(IOException ex){
    Logger.getLogger(Testing_HTML_Parsing.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    private void Split(String s){
        if(s.contains(".")){
        String[] parts = s.split("\\.");
        for (int i = 0; i<parts.length; i++){
        JOptionPane.showMessageDialog(null, parts[i]);
        }
        } else {
        JOptionPane.showMessageDialog(null, "String does not contain '.' to split..");
        }
    }
        private void SplitScorCard(String s){
//        String[] parts = s.split(" ",5);
            String[] parts = s.split("Table"); 
            String heading1 = parts[0]; // Main heading RBS Six Nations 
            String scores = parts[1].trim(); 
            String[] scoreTable = scores.split(" ",5); // Position(0), Team(1), P(2), Pts(3), & Rest of score card
            String scores1 = scoreTable[4]; // Rest of the score card
            String[] splitscores = scores1.split(" ");
            
        JOptionPane.showMessageDialog(null, scores1);
        
        }
}
