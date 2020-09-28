pipeline {
    agent any

    tools {
        maven '3.6.3'
    }

    options {
        timeout(time: 25, unit: 'MINUTES')
    }

    stages {
        stage('Continuos Integration') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
