/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ggear
 */
package p4_package;

public class CellDataClass implements Comparable<CellDataClass>
   {
    /**
     * data storage
     */
    int dataVal;
    
    /**
     * cell location, x position
     */
    int xPos;
    
    /**
     * cell location, y position
     */
    int yPos;
    
    /**
     * Default constructor
     */
    public CellDataClass()
       {
        dataVal = 0;
        
        xPos = 0;
        
        yPos = 0;
       }
    
    /**
     * Initialization constructor
     * 
     * @param setDataValue integer value to be loaded into cell
     * 
     * @param setXPos integer x position of cell
     * 
     * @param setYPos integer y position of cell
     */
    public CellDataClass( int setDataValue, int setXPos, int setYPos )
       {
        dataVal = setDataValue;
        
        xPos = setXPos;
        
        yPos = setYPos;
       }
    
    /**
     * Copy constructor
     * 
     * @param copied IntDataClass object to be copied into THIS object
     */    
    public CellDataClass( CellDataClass copied)
       {
        dataVal = copied.dataVal;
        
        xPos = copied.xPos;
        
        yPos = copied.yPos;
       }
    
    /**
     * Setter method to update data in object
     * 
     * @param newValue integer value to be set in object
     * 
     * @param newXPos integer x position value to be set in object
     * 
     * @param newYPos integer y position value to be set in object
     */
    public void setCellData( int newValue, int newXPos, int newYPos )
       {
        dataVal = newValue;
        
        xPos = newXPos;
        
        yPos = newYPos;
       }
    
    /**
     * Getter method to retrieve data from object
     * 
     * @return integer value retrieved from object
     */
    public CellDataClass getCellData()
       {
        return this;
       }
    
    /**
     * Overrides toString method
     *
     * @return String output of integer data value
     */
    @Override
    public String toString()
       {
        return "(" + String.valueOf( xPos ) + ", "
                     + String.valueOf( yPos ) + "): "
                     + String.valueOf( dataVal );
       }
    
    /**
     * Method required of class extending Comparable;
     * used by generic classes for management
     */
    public int compareTo( CellDataClass other )
       {
        int difference = dataVal - other.dataVal;
        
        if( difference != 0 )
           {
            return difference;
           }
        
        difference = xPos - other.xPos;
        
        if( difference != 0 )
           {
            return difference;
           }
        
        return yPos - other.yPos;
       }
}
