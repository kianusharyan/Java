/*
* Comp 2070-01/02
* Lab 6
* Due: 4/10/2016
* Kianush Aryan
*/

package edu.wit.comp2070.aryank.inheritance;


/**
 * @author David M Rosenberg
 *
 */
public abstract class Pet implements Comparable< Pet >
    {
    private String name;            // non-null, non-empty
    private int    age;             // in years
    private double weight;          // in pounds

    
    /**
     * baseline initializations
     */
    public Pet()
        {
        name = "unnamed";
        age = 0;
        weight = 0.0;
        }

    
    /**
     * 
     * @param initialName any non-null text, excluding the empty string
     * @param initialAge any non-negative number of years
     * @param initialWeight any non-negative number of pounds
     * @throws ParameterOutOfRangeException
     */
    public Pet( String initialName, int initialAge, double initialWeight ) throws ParameterOutOfRangeException
        {
        this();        // make sure the instance is in a meaningful initial state

        setPet( initialName, initialAge, initialWeight );
        }

    
    /**
     * 
     * @param newName any non-null text, excluding the empty string
     * @param newAge any non-negative number of years
     * @param newWeight any non-negative number of pounds
     * @throws ParameterOutOfRangeException
     */
    public void setPet( String newName, int newAge, double newWeight ) throws ParameterOutOfRangeException
        {
        if ( isValidName( newName ) && isValidAge( newAge ) && isValidWeight( newWeight ) )
            // redundant tests but prevent any changes to the object if any parameter is invalid
            {
            setName( newName );
            setAge( newAge );
            setWeight( newWeight );
            }
        }

    
    /**
     * 
     * @return
     */
    public int getAge()
        {
        return age;
        }

    
    /**
     * 
     * @return
     */
    public String getName()
        {
        return name;
        }

    
    /**
     * 
     * @return
     */
    public double getWeight()
        {
        return weight;
        }

    
    /**
     * 
     * @param newAge any non-negative number of years
     * @throws ParameterOutOfRangeException
     */
    public void setAge( int newAge ) throws ParameterOutOfRangeException
        {
        if ( isValidAge( newAge ) )
            {
            age = newAge;
            }
        }

    
    /**
     * 
     * @param newName any non-null text, excluding the empty string
     * @throws ParameterOutOfRangeException
     */
    public void setName( String newName ) throws ParameterOutOfRangeException
        {
        if ( isValidName( newName ) )
            {
            name = newName.trim() ;
            }
        }

    
    /**
     * 
     * @param newWeight any non-negative number of pounds
     * @throws ParameterOutOfRangeException
     */
    public void setWeight( double newWeight ) throws ParameterOutOfRangeException
        {
        if ( isValidWeight( newWeight ) )
            {
            weight = newWeight;
            }
        }

    
    /**
     * 
     * @return
     */
    public abstract String speak() ;
    
    
    /**
     * 
     * @param otherPet
     * @return
     */
    @Override
    public int compareTo( Pet otherPet )
        {
        if ( this.equals( otherPet ))
            {
        	System.out.println("equal");
            return 0 ;
            }
        else
            {
        	System.out.println("not equal");

            return this.age - otherPet.age ;
            }
        }

    
    /**
     * 
     */
    @Override
    public boolean equals( Object other )
        {
        Pet otherPet = (Pet) other ;
        return this.name.equals( otherPet.name ) ;
        }
    
    
    /**
     * 
     */
    @Override
    public String toString()
        {
        return "Pet '" + name + "' is " + age + " year" + ( age == 1 ? "" : "s" ) + 
                    " old and weighs " + weight + " pound" + ( weight == 1.0 ? "" : "s" ) + "." ;
        }
    
    
    /**
     * 
     * @param anAge
     * @return
     * @throws ParameterOutOfRangeException
     */
    private static boolean isValidAge( int anAge ) throws ParameterOutOfRangeException
        {
        if ( anAge >= 0 )
            {
            return true;
            }
        else
            {
            throw new ParameterOutOfRangeException( "Negative age specified: " + anAge );
            }
        }

    
    /**
     * 
     * @param aName
     * @return
     * @throws ParameterOutOfRangeException
     */
    private static boolean isValidName( String aName ) throws ParameterOutOfRangeException
        {
        if ( ( aName != null ) &&
             ( aName.trim().length() > 0 ) )
            {
            return true;
            }
        else
            {
            throw new ParameterOutOfRangeException ( "No name provided" );
            }
        }

    /**
     * 
     * @param aWeight
     * @return
     * @throws ParameterOutOfRangeException
     */
    private static boolean isValidWeight( double aWeight ) throws ParameterOutOfRangeException
        {
        if ( aWeight >= 0 )
            {
            return true;
            }
        else
            {
            throw new ParameterOutOfRangeException( "Negative weight specified: " + aWeight );
            }
        }

    
    
    
    /**
     * @param args
     */
    public static void main( String[] args )
        {
        // test isValidAge()
        System.out.println( "Testing isValidAge():" ) ;
        try 
            {
            if( isValidAge( 0 ))
                {
                System.out.println( "isValidAge( 0 ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidAge( 0 ) caused exception: " + e.getMessage() ) ;
            }

        try
            {
            if ( isValidAge( 10 ) )
                {
                System.out.println( "isValidAge( 10 ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidAge( 10 ) caused exception: " + e.getMessage() );
            }

        try 
            {
            if( isValidAge( -10 ))
                {
                System.out.println( "isValidAge( -10 ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidAge( -10 ) caused exception: " + e.getMessage() ) ;
            }

        // test isValidName()
        System.out.println();
        System.out.println( "Testing isValidName():" ) ;
        try 
            {
            if( isValidName( "Fido" ))
                {
                System.out.println( "isValidName( \"Fido\" ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidName( \"Fido\" ) caused exception: " + e.getMessage() ) ;
            }

        try
            {
            if ( isValidName( "" ) )
                {
                System.out.println( "isValidName( \"\" ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidName( \"\" ) caused exception: " + e.getMessage() );
            }

        try 
            {
            if( isValidName( null ))
                {
                System.out.println( "isValidName( null ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidName( null ) caused exception: " + e.getMessage() ) ;
            }


        // test isValidWeight()
        System.out.println();
        System.out.println( "Testing isValidWeight():" ) ;
        try 
            {
            if( isValidWeight( 0.0 ))
                {
                System.out.println( "isValidWeight( 0.0 ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidWeight( 0.0 ) caused exception: " + e.getMessage() ) ;
            }

        try
            {
            if ( isValidWeight( 15.3 ) )
                {
                System.out.println( "isValidWeight( 15.3 ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidWeight( 15.3 ) caused exception: " + e.getMessage() );
            }

        try 
            {
            if( isValidWeight( -6.7 ))
                {
                System.out.println( "isValidWeight( -6.7 ) is true" );
                }
            }
        catch( ParameterOutOfRangeException e)
            {
            System.out.println( "isValidWeight( -6.7 ) caused exception: " + e.getMessage() ) ;
            }


        }


    }
