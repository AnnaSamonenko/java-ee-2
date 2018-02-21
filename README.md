#INSTALLATION
1) Download latest release of Chrome Driver from https://sites.google.com/a/chromium.org/chromedriver/.

2) Put the driver in defined directory. (For example, on the disk C in the folder "webdrivers").

3) Add Chrome Driver to the System Variables:
	* Open System Properties (write "edit the system environment variables" in the search field of Search Window) -> 
	* In the appeared window click on the "Environment Variables"  -> double click on "Path"(in the System Variables block) -> "New" -> put the path to the driver.(In this example, "C:\webdrivers").

4) Restart your PC.

#RUN TEST USING JUNIT 
1) Open Run\Debug Configurations.(by clicking on the "Edit Configuration" in the Toolbar)

2) Add New Configuratiion -> JUnit(by clicking on the icon of green plus).

3) In the appeared window:
	* Put name of runner
	* In the field "Class" define path to the TestSuite
	* In the VM options put: -ea -Denv.config="path_to_the_propery_file" -Dcucumber.options="--tags @tag_for_run_test" 
	
	For example, -ea -Denv.config="mat/dev.properties" -Dcucumber.options="--tags @as" 

#RUN TESTS USING MAVEN

1) Generate runners:

mvnw -f sd-storefront/pom.xml -B -P generate-runners,regression-hte5 generate-test-sources

2) Parallel run:

mvnw -f sd-storefront/pom.xml -B -P run-parallel,regression-hte5 -DforkCount=5 -Dwebdriver.remote.url=http://elabsel01.uk.aswatson.net:4444/wd/hub integration-test

3) Report generation:

mvnw -f sd-storefront/pom.xml serenity:aggregate

 

