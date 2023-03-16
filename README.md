# How to run

- Use docker 
- run `docker build -t enfore_tharkana:v1 .`
- run `docker run -p 9000:9000 enfore_tharkana:v1` 
- use Postman or any rest client 
    - access GET - http://localhost:9000/api/all/stats
    - it will take few mini to load the excel file for initial time
- 

--- 

### TODO

- Write Unit test 
- Write API endpoint test
- Add logger 
- Work on rest of the Bonus points
- Add swagger https://index.scala-lang.org/iheartradio/play-swagger