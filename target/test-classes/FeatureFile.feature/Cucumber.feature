Feature: Finding Hospitals
   @sanity @regression
  Scenario: Find the hospital in your city and print the details
    Given the user navigates to Practo site homepage
    When select the city and search speciality
    And Apply filters for Patient stories,Experiences,fees,availability and any one sorting
    Then display the five doctor details
    When Click on surgeries button and Store all the Surgeries in list and Display it

   @negative 
  Scenario: Fill the Invalid Email and Valid Data In form
    When Click on For corporate and select the Health and Wellness plan option
    When user fills all required fields
    And entering invalid email
    Then Validate demo button is disabled
   
   @positive
  Scenario: Fill the Valid Email and Valid Data In form
    When user enters valid email
    Then Validate demo button is enabled
    When user click the Demo button
    Then user is able to see the Thank You message and Validate it
