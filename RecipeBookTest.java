package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeBookTest {

	 private static RecipeBook recipeBook;
	 private static Recipe recipe1;
	 private static Recipe recipe2; 
	 
	// create the recipe once before executing all tests
		@BeforeClass
	    public static void setUp() throws Exception    {
			
			recipeBook = new RecipeBook();
			
			recipe1 = new Recipe();
			recipe1.setName("recipe1");
			recipe1.setAmtChocolate("1");
			recipe1.setAmtCoffee("2");
	        recipe1.setAmtMilk("1");
	        recipe1.setAmtSugar("4");
	        recipe1.setPrice("30");

	        recipe2 = new Recipe();
	        recipe2.setName("recipe2");
	        recipe2.setAmtChocolate("3");
	        recipe2.setAmtCoffee("3");
	        recipe2.setAmtMilk("4");
	        recipe2.setAmtSugar("5");
	        recipe2.setPrice("50");
	        
		}
		
		
		// add new recipe
		@Test
		public void testAddNewRecipe(){
			recipeBook = new RecipeBook();
			assertTrue(recipeBook.addRecipe(recipe1));

		}
		
		// add existed recipe
		@Test
		public void testAddExistRecipe(){
			recipeBook = new RecipeBook();
			recipeBook.addRecipe(recipe1);
			assertFalse(recipeBook.addRecipe(recipe1));

		}
		
		// add out of space recipe
		@Test
		public void testAddRecipeNoSpace(){
			
			recipeBook = new RecipeBook();
			recipeBook.addRecipe(recipe1);
			Recipe recipe3 = new Recipe();
			recipe3.setName("2");
			Recipe recipe4 = new Recipe();
			recipe4.setName("4");
			Recipe recipe5 = new Recipe();
			recipe5.setName("5");
			Recipe recipe6 = new Recipe();
			recipe6.setName("6");
			
			recipeBook.addRecipe(recipe3);
			recipeBook.addRecipe(recipe4);
			recipeBook.addRecipe(recipe5);
		

			assertFalse(recipeBook.addRecipe(recipe2));

		}
		
		
	   // delete existed recipe
		@Test
		public void testDeleteRecipe() {
			
			recipeBook = new RecipeBook();
			recipeBook.addRecipe(recipe1);
			assertTrue(recipeBook.deleteRecipe(0) == "recipe1");

			
		}
		
		// delete recipe from empty index
		@Test
		public void testDeleteRecipeEmptySpace() {
					
			recipeBook = new RecipeBook();
			assertTrue(recipeBook.deleteRecipe(0) == null);

					
		}
		
		// fill the array and delete on recipe then try to add another one
		@Test
		public void testDeleteRecipeFull() {
							
			recipeBook = new RecipeBook();
			
			recipeBook.addRecipe(recipe1);
			Recipe recipe3 = new Recipe();
			recipe3.setName("2");
			Recipe recipe4 = new Recipe();
			recipe4.setName("4");
			Recipe recipe5 = new Recipe();
			recipe5.setName("5");
			Recipe recipe6 = new Recipe();
			recipe6.setName("6");
			
			recipeBook.addRecipe(recipe3);
			recipeBook.addRecipe(recipe4);
			recipeBook.addRecipe(recipe5);
			
			
			recipeBook.deleteRecipe(0);
			
			assertTrue(recipeBook.addRecipe(recipe1));
						
		}
		
		// edit recipe
		@Test
		public void testEditRecipe() {
									
			recipeBook = new RecipeBook();
					
			recipeBook.addRecipe(recipe1);
					
			assertTrue(recipeBook.editRecipe(0, recipe2) == "recipe1");
			
			assertTrue(recipeBook.getRecipes()[0].getName() == "recipe2");
		}
		
		// edit recipe on empty space
		@Test
		public void testEditRecipeEmpty() {
									
			recipeBook = new RecipeBook();
					
			assertTrue(recipeBook.editRecipe(0, recipe2) == null);
								
		}
					
	

}
