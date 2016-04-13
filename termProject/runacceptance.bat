cd acceptance
javac -cp .;..\build\classes\main; ParserKeywords.java
java -cp .;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework ParserFeatureAcceptanceTest.txt
cd ..
pause