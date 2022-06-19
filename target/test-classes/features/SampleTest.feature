@SampleTestAssesment

Feature: Validation Product Details

Scenario: Product search with different categories 
When a user makes a request to the URL
Then the user gets an OK response
And check the response exists with Name as "<name>"
And CanRelist as <canRelist> 
And Promotion Name as "<promotionName>" with Description should be as "<description>"
  
Examples:

   |name			|canRelist 	|promotionName	|description			  |
   |Carbon credits  |true		|Gallery		|Good position in category|  


   
   
