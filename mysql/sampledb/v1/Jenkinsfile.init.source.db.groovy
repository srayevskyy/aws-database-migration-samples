pipeline {
    agent any
    environment {
        MYSQL_ROOT_PASSWORD = credentials('MYSQL_ROOT_PASSWORD')
    }
    stages {
        stage('Init source db') {
            steps {
                dir('mysql/sampledb/v1') {
                    sh "pwd"
                    sh 'ls -al'
                    sh 'mysql -h ${MYSQL_SRC_HOST} -u root -p${MYSQL_ROOT_PASSWORD} < install-rds.sql'
                }
            }
        }
    }
}