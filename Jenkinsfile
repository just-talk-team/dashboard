pipeline {
    agent { 
        docker { 
            image 'maven:3.3.3' 
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
