import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        //Initiating numPoint to 0 which will count number of points
        int numPoints = 0;
        // read points from the Shape s
        for (Point p : s.getPoints()) {        
           numPoints++;         
        }                   
        // return the numPoints to display
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        double avgLength = 0;
        int numPoints = getNumPoints(s);
        double totalPerimeter = getPerimeter(s);        
        avgLength = totalPerimeter / numPoints;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double largeSide = 0;
        double currSide = 0;
        double prevSide = 0;
                
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {

            currSide = prevPt.distance(currPt);
            
            if (currSide > prevSide ) {
                  largeSide = currSide;
                 } else
                 {
                  largeSide = prevSide;
            }
                prevSide = currSide;
        }                
        
        return largeSide; 
    }
    

    public double getLargestX(Shape s) {
        double largestX=0;
        double currX = 0;
        double prevX = 0;
        
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {

            currX = currPt.getX();
            
            if (currX > prevX ) {
                  largestX = currX;
                 } else
                 {
                  largestX = prevX;
            }
                prevX = currX;
        }                
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;
        double prevShapePermieter = 0.0;
        double currShapePermieter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currShapePermieter = getPerimeter(s);
            if (currShapePermieter > prevShapePermieter ) {
                largestPerimeter =  currShapePermieter;
               } else {
                largestPerimeter = prevShapePermieter;
            }
            prevShapePermieter = currShapePermieter;        
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        
        String fileName = null;
        
        double largestPerimeter = 0.0;
        double prevShapePermieter = 0.0;
        double currShapePermieter = 0.0;
               
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currShapePermieter = getPerimeter(s);
            if (currShapePermieter > prevShapePermieter ) {
                fileName = f.getName();
               } else {
                fileName = f.getName();
            }
            prevShapePermieter = currShapePermieter;        
        }
        
        return fileName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int numPoints = getNumPoints(s);
        System.out.println("no of Ponts in shape : " + numPoints);
        
        double avgLength = getAverageLength(s);
        System.out.println("avg Length : " + avgLength);
        
        double largeSide = getLargestSide(s);
        System.out.println("Large side is : " + largeSide);
        
        double largestX = getLargestX(s);
        System.out.println("Largest X is : " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter : " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("Filename with Larest Perimeter : " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
