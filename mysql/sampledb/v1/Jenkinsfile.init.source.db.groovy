pipeline {
    agent any
    environment {
        MYSQL_USER = "iam_admin"
    }    
    stages {
        stage('Init source db') {
            steps {
                dir('mysql/sampledb/v1') {
                    sh '''
                    set -x
                    wget --no-clobber --directory-prefix=${HOME} https://s3.amazonaws.com/rds-downloads/rds-ca-2019-root.pem
                    export MYSQL_TOKEN="$(aws rds generate-db-auth-token --hostname $MYSQL_DST_HOST --port 3306 --region us-west-2 --username ${MYSQL_USER})"
                    echo ${MYSQL_TOKEN}
                    mysql -v -h ${MYSQL_SRC_HOST} -u ${MYSQL_USER} -p${MYSQL_TOKEN} < install-rds.sql
                    '''
                }
            }
        }
    }
}