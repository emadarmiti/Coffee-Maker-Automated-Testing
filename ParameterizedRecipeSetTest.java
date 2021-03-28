package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;


@RunWith(Parameterized.class)
public class ParameterizedRecipeSetTest {
	
    private Recipe recipe;
	private String actual_value;
	private double expected_value;
	 private Type type;
	
	public ParameterizedRecipeSetTest(Type type, String actual_value, double expected_value) {
		
		this.expected_value = expected_value;
		this.actual_value = actual_value;
		this.type = type;
		
		}
	
	enum Type {VALID, INVALID};
	@Parameters(name = "{index} -> type:{0} , {1},{2}")
	public static Collection<Object[]> dataset(){
		
		return Arrays.asList(new Object[][] {
			{Type.INVALID, "-2", 0},
			{Type.INVALID,"", 0}, 
			{Type.INVALID,"e", 0},
			{Type.VALID, "2", 2}, 
			{Type.VALID,"0", 0},
			{Type.INVALID,"0.5", 0}
		});
	}
	
	// test the SetAmtChocolate method
	@Test(expected = RecipeException.class)
	public void testSetAmtChocolateInvalid() throws RecipeException {
		
		Assume.assumeTrue(type == Type.INVALID);
		this.recipe = new Recipe();
		this.recipe.setAmtChocolate(actual_value);
		
		assertTrue( this.expected_value == this.recipe.getAmtChocolate());

	}
	
	// test the setAmtMilk method
	@Test(expected = RecipeException.class)
	public void testSetAmtMilkInvalid() throws RecipeException {
		
		Assume.assumeTrue(type == Type.INVALID);
		this.recipe = new Recipe();
		this.recipe.setAmtMilk(actual_value);
			
		assertTrue( this.expected_value == this.recipe.getAmtMilk());

	}
	
	// test the setAmtSugar method
	@Test(expected = RecipeException.class)
	public void testSetAmtSugarInvalid() throws RecipeException {
		
		Assume.assumeTrue(type == Type.INVALID);
		this.recipe = new Recipe();
		this.recipe.setAmtSugar(actual_value);
				
		assertTrue( this.expected_value == this.recipe.getAmtSugar());

	}
	
	// test the setPrice method
	@Test(expected = RecipeException.class)
	public void testSetPriceInvalid() throws RecipeException {
		
		Assume.assumeTrue(type == Type.INVALID);
		this.recipe = new Recipe();
		this.recipe.setPrice(actual_value);
					
		assertTrue( this.expected_value == this.recipe.getPrice());

	}

	
	// test the SetAmtChocolate method
	@Test
	public void testSetAmtChocolate() throws Exception   {
			
		Assume.assumeTrue(type == Type.VALID);
		this.recipe = new Recipe();
		this.recipe.setAmtChocolate(actual_value);
			
		assertTrue( this.expected_value == this.recipe.getAmtChocolate());

	}
		
	// test the setAmtMilk method
	@Test
	public void testSetAmtMilk() throws Exception {
			
		Assume.assumeTrue(type == Type.VALID);
		this.recipe = new Recipe();
		this.recipe.setAmtMilk(actual_value);
				
		assertTrue( this.expected_value == this.recipe.getAmtMilk());

	}
		
	// test the setAmtSugar method
	@Test
	public void testSetAmtSugar() throws Exception {
			
		Assume.assumeTrue(type == Type.VALID);
		this.recipe = new Recipe();
		this.recipe.setAmtSugar(actual_value);
					
		assertTrue( this.expected_value == this.recipe.getAmtSugar());

	}
		
	// test the setPrice method
	@Test
	public void testSetPrice() throws Exception  {
			
		Assume.assumeTrue(type == Type.VALID);
		this.recipe = new Recipe();
		this.recipe.setPrice(actual_value);
						
		assertTrue( this.expected_value == this.recipe.getPrice());

	}
	

	
	

}
