# MARS REPORT #

Sprint-boot web application that shows the latest weather report from Mars.

It consumes a live NASA API which returns a list of daily weather reports received from the Curiosity rover currently on the surface of Mars.

Using this data, the application generates it's own JSON report API (/api/mars/report) and this under-pins a simple JavaScript AJAX UI which displays the data in HTML.

The application is built and run using Maven.

### Get setup:

1. Clone the project
2. Install Maven if required
3. Run the application with: mvn spring-boot:run
4. To see the report API navigate to http://localhost:8080/api/mars/report
5. To see the report UI navigate to http://localhost:8080/index.html 

### Your tasks:

1. Update the application so that it is possible to see the weather report for a specific date rather than just the latest date.
Hint: 
Use a request parameter to accept the required date. eg. http://localhost:8080/index.html?earth_date=2016-01-04

2. Update the application to show, below the weather report on the UI, all the images the Curiosity rover has taken on the specified date. 
Use live NASA imaging API (https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=yyyy-MM-dd&api_key=AOY1JmnKuMubwVpC2PpP0xtCwf4UaQLLZkG9PpB6) to get the list of images from the Mars rover on a specified date.
Hint:
Update the application's JSON report API to include links to the images.
Update the UI to show the images.