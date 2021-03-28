package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecipeTest {

    private static Recipe recipe;

    // create the recipe once before executing all tests
	@BeforeClass
    public static void setUp() throws RecipeException   {
		
        recipe = new Recipe();
        recipe.setAmtChocolate("2");
        recipe.setAmtCoffee("3");
        recipe.setAmtMilk("8");
        recipe.setAmtSugar("4");
        recipe.setName("first recipe");
        recipe.setPrice("20");
        
	}
	

	// test the GetAmtChocolate method
	@Test
	public void testGetAmtChocolate_1(){
		
		assertTrue(2 == recipe.getAmtChocolate());

	}
	
	
	// test the getAmtCoffee method
	@Test
	public void testGetAmtCoffee_2(){
			
		assertTrue(3 == recipe.getAmtCoffee());
	}

	
	// test the getAmtMilk method
	@Test
	public void testGetAmtMilk_3(){
			
		assertTrue(8 == recipe.getAmtMilk());
	}
	
	
	// test the getAmtSugar method
	@Test
	public void testGetAmtSugar_4(){
			
		assertTrue(4 == recipe.getAmtSugar());
	}
	

	
	// test the getPrice method
	@Test
	public void testGetPrice_5(){
			
		assertTrue(20 == recipe.getPrice());
	}
	
	// test the setName method
	@Test
	public void testsetNameNull_6()   {
				
		
		recipe.setName(null);
							
		assertTrue( "" == recipe.getName());
	
	}
	
	// test the setName method
	@Test
	public void testsetNameEmpty_7()   {
					
		recipe.setName("");
								
		assertTrue( "" == recipe.getName());
		
	}
	
	// test the setName and getName method
	@Test
	public void testsetName_8()  {
					
		recipe.setName("recipe test");
		

		assertTrue( "recipe test" == recipe.getName());
		
	}
	
	@Test
	public void testEqualsNull_9()  {
		
		Recipe recipe_null = null;

        assertFalse(recipe.equals(recipe_null));
    }
	
	@Test
	public void testEqualsFlase_10()  {
		
	  Recipe recipe2 = new Recipe();

        assertFalse(recipe.equals(recipe2));
    }
	
	@Test
	public void testEqualsDifNames_11()  {
		
		 Recipe recipe2 = recipe;
		recipe2.setName("second recipe");

        assertTrue(recipe.equals(recipe2));
    }
	
	@Test
	public void testEquals_12()  {
		
		 Recipe recipe2 = recipe;
        assertTrue(recipe.equals(recipe2));
    }
}