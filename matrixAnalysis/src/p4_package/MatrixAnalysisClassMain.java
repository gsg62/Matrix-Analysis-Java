/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4_package;

/**
 * Driver class for recursive backtracking search solution
 * 
 * @author MichaelL
 *
 */
public class MatrixAnalysisClassMain
   {
    /**
     * Driver main method
     * 
     * @param args String command line arguments, not used
     */
    public static void main(String[] args)
       {
        boolean showOperations = true;
       
        MatrixAnalysisClass mac = new MatrixAnalysisClass( showOperations );

        mac.uploadData( "DataSet_4.txt" );
       
        mac.dumpArray();
       
        //CellDataClass TestData = new CellDataClass(4, 1, 0); 
        //System.out.print(TestData.toString());
         //System.out.println(TestData.toString());
        // all data sets work with 1139, 1000, & 711
        mac.findSum( 711 );
        
        /*
        String status = "Location Failed";
        mac.displayStatus(1, status, TestData, 102);
        mac.displayStatus(2, status, TestData, 103);

        status = "Valid Location Found";
        mac.displayStatus(3, status, TestData, 101);
        status = "Found At";
        mac.displayStatus(4, status, TestData, 101);
*/
       }

   }