node {
	stage ('SCM checkout'){
		git url: "https://git.fhict.nl/I410315/fun4-randomeater"
		}
	stage ('Build'){
    	dir("randomeater") {
	   sh "mvn clean install"
       }
       	dir("randomeater/target") {
	   sh "java -jar randomeater-0.0.1-SNAPSHOT.jar"
       }
		}
}
