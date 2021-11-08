pipeline {
    agent any
    stages {
        stage('Init source db') {
            steps {
                sh 'mysql --version'
            }
        }
    }
}