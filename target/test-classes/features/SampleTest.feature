@SampleTestAssesment

Feature: Validation Product Details

Scenario:Product search with different categories 
When user make a request to the URL
Then the user get an OK response
And check the response exists with Name as "<name>"
And CanRelist as <CanRelist> 
And Promotion Name as "<PromotionName>" with Description should be as "<promotion>"
  
Examples:

   |name			|CanRelist 	|PromotionName	|promotion				 |
   |Carbon credits  |true		|Gallery		|Good position in category|  


   
   
