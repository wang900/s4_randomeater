node {
	stage ('SCM checkout'){
		git url: "git@github.com:wang900/s4_randomeater.git"
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
