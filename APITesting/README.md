
## Fynd Automation Task

#Pre-requiste
1. JDK
2. Maven 
3. TestNG
4. GitBash

# Steps for setup
1. Load: https://github.com/gitmgupta/FyndResp
2. Download the project (zip file) 
3. Import the project -> General -> Existing project into workspace 
	-> Browser to \FyndResp-master\FyndResp-master\APITesting
4. Wait untill all the dependencies get downloaded to local repository 
5. Ensure that Installed JRE is pointing to JDK
    
	-> Window -> Preferences -> Java -> Installed JREs -> Pointing to JDK rather than JRE.

6. Ensure that TestNG is added under Libraries
    
	-> Right click on project -> Build path -> Configure Build path -> Libraries tabs
    
# Run via TestNG
Right click on testng.xml under project -> Run As -> TestNG Suite

# Run via Maven
Right click on project -> Maven clean 
Right click on project -> Maven Test

# Run via command prompt
Running via command prompt ensure M2_HOME is configured under Enviornment Variable
Open CMD
Navigate to project directory
Run following commands
1. mvn clean
2. mvn test

# For TestNG report
After running the testng suite, refresh the project and refer test-output folder

# For maven report 
After running the test refer to target-> surefire-reports