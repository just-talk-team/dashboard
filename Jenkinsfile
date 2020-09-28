pipeline {
    agent { 
        dockerfile true
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
