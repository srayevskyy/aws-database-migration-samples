pipeline {
    agent any
    stages {
        stage('Init source db') {
            steps {
                sh 'mysql --version'
                sh 'echo MYSQL_SRC_HOST=${MYSQL_SRC_HOST}'
            }
        }
    }
}