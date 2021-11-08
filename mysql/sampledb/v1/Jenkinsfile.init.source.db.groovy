pipeline {
    agent any
    stages {
        stage('Init source db') {
            steps {
                sh 'mysql --version'
                sh 'echo $PATH'
            }
        }
    }
}