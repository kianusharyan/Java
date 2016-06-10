/**
 * 
 */
package edu.wit.comp2070.aryank.inheritance;

/**
 * @author David M Rosenberg
 * @author Kianush Aryan
 */
public class Dog extends Pet
    {
    private boolean doesTricks ;

    /**
     * 
     */
    public Dog()
        {
        super() ;
        
        doesTricks = false ;
        }

    /**
     * @param initialName
     * @param initialAge
     * @param initialWeight
     * @throws ParameterOutOfRangeException
     */
    public Dog( String initialName, int initialAge, double initialWeight ) throws ParameterOutOfRangeException
        {
        this() ;
        
        setPet( initialName, initialAge, initialWeight );
        }


    /**
     * @param initialName
     * @param initialAge
     * @param initialWeight
     * @throws ParameterOutOfRangeException
     */
    public Dog( String initialName, int initialAge, double initialWeight, boolean initialDoesTricks ) throws ParameterOutOfRangeException
        {
        this() ;
        
        setPet( initialName, initialAge, initialWeight );
        
        doesTricks = initialDoesTricks ;
        }

    
    /* (non-Javadoc)
     * @see edu.wit.comp2070.rosenbergd.inheritance.Pet#speak()
     */
    @Override
    public String speak()
        {
        return "woof" ;
        }

    public void Fetch(String itemFetched){
    	System.out.println(this.getName()+" has fetched a" + itemFetched);
    }
    /**
     * @param args
     */
    public static void main( String[] args )
        {
        Pet fido;
        try
            {
            fido = new Dog( "Fido", 3, 5.7, true );
            System.out.println( fido.getName() + " says '" + fido.speak() + "'." );
            }
        catch ( ParameterOutOfRangeException e )
            {
            e.printStackTrace();
            }
        }

    }
