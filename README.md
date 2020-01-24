# Software Engineering homework

Build and Run

        gradle bootRun
        curl http://localhost:8080/?year=2019

Examples

        request: curl http://localhost:8080/?year=2017
        response: {"errorCode":200,"date":"13/09/17"}
        
        request: curl http://localhost:8080/?currentDate=10092017
        response: {"errorCode":200,"date":"4"}
        
        request: curl http://localhost:8080/?year=2018
        response: {"errorCode":200,"date":"13/09/18"}
        
        request: curl http://localhost:8080/?currentDate=01012018
        response {"errorCode":200,"date":"255"}

        request: curl http://localhost:8080/?yard=124
        response: {"errorCode":400,"date":"Не правильно введено название параметров"}
       
        request: curl http://localhost:8080?currentDate=010120  
        response: {"errorCode":400, "date":"Incorrect year!"}
        