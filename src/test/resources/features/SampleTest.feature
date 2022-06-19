@SampleTestAssesment

Feature: Validation Product Details

Scenario:Product search with different categories 
When user make a request to the URL to retrieve product details
Then the user get an OK response
#And product exists with valid data combination as Name "<name>" and CanRelist <CanRelist> and Promotion Name "<PromotionName>" and Description "<promotion>"
  And check the response exists with Name as "<name>"
  And CanRelist as <CanRelist> 
  And Promotion Name as "<PromotionName>" and Description should be as "<promotion>"
  
Examples:

   |name			|CanRelist 	|PromotionName	|promotion				 |
   |Carbon credits  |true		|Gallery		|Good position in category|  


   
   
