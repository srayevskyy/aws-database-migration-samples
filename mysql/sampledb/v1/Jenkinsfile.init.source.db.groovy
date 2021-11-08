pipeline {
    agent any
    environment {
        MYSQL_ROOT_PASSWORD = credentials('MYSQL_ROOT_PASSWORD')
    }
    stages {
        stage('Init source db') {
            steps {
                sh 'mysql --version'
                sh 'pwd'
                sh 'ls -al'
                sh 'echo MYSQL_SRC_HOST=${MYSQL_SRC_HOST}'
                sh 'echo MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}'
                sh 'mysql -h ${MYSQL_SRC_HOST} -u root -p${MYSQL_ROOT_PASSWORD} -P3306 -e "SELECT 1+1"'
                dir('mysql/sampledb/v1') {
                    sh "pwd"
                    sh 'ls -al'
                }
                sh 'mysql -h ${MYSQL_SRC_HOST} -u root -p${MYSQL_ROOT_PASSWORD} -P3306 -e "SELECT 1+1"'
            }
        }
    }
}