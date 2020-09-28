pipeline {
    agent { 
        docker { 
            image 'maven:3.6-adoptopenjdk-8' 
        } 
    }

    options {
        timeout(time: 15, unit: 'MINUTES')
    }

    stages {
        stage('Continuos Integration') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
