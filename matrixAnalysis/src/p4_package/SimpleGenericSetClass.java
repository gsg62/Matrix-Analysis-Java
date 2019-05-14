/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4_package;

/**
 * Class for managing sets of GenericData that extends Comparable
 * 
 * @author MichaelL
 *
 */
public class SimpleGenericSetClass<GenericData extends Comparable<GenericData>>
   {
    /**
     * constant with default array capacity
     */
    public static final int DEFAULT_ARRAY_CAPACITY = 10;
   
    /**
     * integer array for data
     */
    private Object[] genericSetArray;
   
    /**
     * capacity of array
     */
    private int arrayCapacity;
   
    /**
     * number of values in array
     */
    private int arraySize;
   
    /**
     * Default constructor
     * <p>
     * Initializes set array
     */
    public SimpleGenericSetClass()
       {
        genericSetArray = new Object[ DEFAULT_ARRAY_CAPACITY ];
       
        arrayCapacity = DEFAULT_ARRAY_CAPACITY;
       
        arraySize = 0;
       }

    /**
     * Initialization constructor
     * <p>
     * Allows specification of set array capacity
     * <p>
     * Initializes set array
     * 
     * @param initialCapacity integer that specifies array capacity
     */
    public SimpleGenericSetClass( int initialCapacity )
       {
        genericSetArray = new Object[ initialCapacity ];
       
        arrayCapacity = initialCapacity;
       
        arraySize = 0;
       }

    /**
     * Copy constructor
     * <p>
     * Duplicates copied set class
     * <p>
     * Also responsible for correct initialization/update 
     * of set class array
     * 
     * @param copied SetClass object to be copied
     */
    public SimpleGenericSetClass( SimpleGenericSetClass<GenericData> copied)
       {
        int index;
       
        genericSetArray = new Object[ copied.arraySize  ];

        arrayCapacity = copied.arrayCapacity;
               
        arraySize = copied.arraySize;
       
        for( index = 0; index < arraySize; index++ )
           {
            genericSetArray[ index ] = copied.genericSetArray[ index ];
           }
       }

    /**
     * Adds generic element to end of set
     * <p>
     * increases capacity using checkForResize if array is full
     * 
     * @param item integer value to be added to set
     */
    public void addItem( GenericData item )
       {
        checkForResize();
       
        if( !hasItem( item ) )
           {
            genericSetArray[ arraySize ] = (Object)item;
       
            arraySize++;
           }
       }

    /**
     * Removes element if it is found in set
     *
     * @param valToRemove integer value to be removed
     * 
     * @return boolean result of operation success
     */
    @SuppressWarnings( "unchecked" )
    public boolean removeItem( GenericData valToRemove )
       {
        int index;
        boolean found = false;
        GenericData arrayElement;
        
        for( index = 0; index < arraySize; index++ )
           {
            arrayElement = (GenericData)genericSetArray[ index ];
            
            if( valToRemove.compareTo( arrayElement ) == 0 )
               {
                removeAtIndex( index );
               
                found = true;
               }
           }
       
        return found;
       }
   
    /**
     * Removes value at given index;
     * moves all succeeding data down in array
     * 
     * @param indexToRemove integer index of element value to remove
     * 
     * @return GenericData value removed from set
     */
    @SuppressWarnings( "unchecked" )
    private GenericData removeAtIndex( int indexToRemove )
       {
        GenericData returnValue = null;
        int index;
       
        if( indexToRemove >= 0 && indexToRemove < arraySize )
           {
            returnValue = (GenericData)genericSetArray[ indexToRemove ];
            
            arraySize--;
       
            for( index = indexToRemove; index < arraySize; index++ )
               {
                genericSetArray[ index ] = genericSetArray[ index + 1 ];
               }
           }
        
        return returnValue;
       }
    
    /**
     * Removes last element from set, returns value
     * 
     * @return GenericData item removed
     */
    @SuppressWarnings( "unchecked" ) 
    public GenericData removeLastItem()
       {
        arraySize--;
        
        return (GenericData)genericSetArray[ arraySize ];
       }
    
    /**
     * Tests to indicate if integer value is one
     * of the set elements
     * 
     * @param testElement integer element to be found in set
     * 
     * @return boolean result of test
     */
    @SuppressWarnings( "unchecked" )    
    public boolean hasItem( GenericData testElement )
       {
        int index;
        GenericData arrayElement;
        
        for( index = 0; index < arraySize; index++ )
           {
            arrayElement = (GenericData)genericSetArray[ index ];
            
            if( testElement.compareTo( arrayElement ) == 0 )
               {
                return true;
               }
           }
       
        return false;
       }
   
    /**
     * Local function tests for resize of the set array
     * <p>
     * If array needs to be resized, array capacity is doubled;
     * otherwise, no change
     * 
     * @return boolean report that resize was conducted
     */
    private boolean checkForResize()
       {
        int index;
        Object[] tempArray;
       
        if( arraySize == arrayCapacity )
           {
            arrayCapacity *= 2;
           
            tempArray = new Object[ arrayCapacity ];
           
            for( index = 0; index < arraySize; index++ )
               {
                tempArray[ index] = genericSetArray[ index ];
               }
           
            genericSetArray = tempArray;
           
            return true;
           }
       
        return false;
       }
   
    /**
     * Provides list of set array elements
     * as comma-delimited string
     * <p>
     * Overrides Object toString
     * 
     * @return String holding object from array
     */
    @Override
    public String toString()
       {
        int index;
        String outString = "";
      
        for( index = 0; index < arraySize; index++ )
           {
            if( index > 0 )
               {
                outString += ", ";
               }
          
            outString += genericSetArray[ index ].toString();
           }
      
        return outString;        
       }

   }