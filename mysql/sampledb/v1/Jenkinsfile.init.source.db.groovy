pipeline {
    agent any
    environment {
        MYSQL_ROOT_PASSWORD = credentials('MYSQL_ROOT_PASSWORD')
    }
    stages {
        stage('Init source db') {
            steps {
                sh 'mysql --version'
                sh 'echo MYSQL_SRC_HOST=${MYSQL_SRC_HOST}'
                sh 'echo MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}'
            }
        }
    }
}