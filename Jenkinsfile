pipeline {
    agent any

    tools {
        maven '3.6.3',
        jdk 'jdk1.8.0_221'
    }

    options {
        timeout(time: 10, unit: 'MINUTES')
    }

    stages {
        stage('Continuos Integration') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
