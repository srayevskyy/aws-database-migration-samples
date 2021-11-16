pipeline {
    agent any
    stages {
        stage('Init source db') {
            steps {
                dir('mysql/sampledb/v1') {
                    sh 'mysql -v -h ${MYSQL_SRC_HOST} -u root -p${MYSQL_ROOT_PASSWORD} < install-rds.sql'
                }
            }
        }
    }
}