lsof -t -i :8080 | while read line
do
	kill -9 $line
done

java -jar target/DropWizard-Getting-Started-0.0.1-SNAPSHOT.jar server hello-world.yml
