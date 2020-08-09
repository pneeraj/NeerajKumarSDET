Feature: SanityTC

Scenario Outline: Google Place smoke Test case from API
          Given prepared basURI and properties  
          When i add place in google  
          And i get place in google 
          And "updateLocation" place in google       
          And i delete place in google
          And i get place in google 
          When i add place in google
          
Examples:

|updateLocation|
|India|
|Rachi|   
|Delhi|
|Delhi|


Scenario: Parse the complexAPI from API
        When get desire value 
        And get the price
        
        