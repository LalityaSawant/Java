
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.URLResource;

public class Part4 {
  public String getYoutubeString() {
      String ytString = "No youtube.com found";
      URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
      for (String s : ur.words()) {
          int ytInd = s.toLowerCase().indexOf("youtube.com") ;          
            if ( ytInd != -1 ) {
                int firstInd = s.indexOf("\"");
                int scndInd = s.indexOf("\"",ytInd +1);
                    if (firstInd != -1 || scndInd !=-1) {
                         ytString = s.substring(firstInd,scndInd);
                         return ytString;
                    }
            }     
      } 
     return ytString;  
  }
  
  public void testGetYoutubeUrl() {
      Part4 p4 = new Part4();
      String result = p4.getYoutubeString();
      System.out.println(result);
  } 
} 
