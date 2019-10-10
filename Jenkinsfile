#!groovy

node('gravitas') {
    try {
        stage('Checkout') {
            echo 'configure started'
            git branch: '${BRANCH_NAME}', credentialsId:'cf073bce-cf6e-4f5a-aa95-9cde7f812f00', url: 'https://gitlab.com/{outlab info.git}'
            echo 'configure done'
        }

        stage('Code Quality') {
                if (isUnix()) {
                    sh 'mvn sonar:sonar -Dsonar.host.url=http://10.8.0.146:9000'
                } else {
                    bat 'mvn sonar:sonar -Dsonar.host.url=http://10.8.0.146:9000'
                }
        }
        /*stage('JUnit tests') {
            if (isUnix()) {
                echo 'its an unix enviranment'
                sh "${tool 'M3'}/bin/mvn test"
                junit '**\\target\\surefire-reports\\*.xml'
            }else {
                echo 'its an windows environment'
                bat "${tool 'M3'}/bin/mvn test"
                junit '**\\target\\surefire-reports\\*.xml'
            }
        }*/

        stage('Build') {
            if (isUnix()) {
                echo 'its an unix enviranment'
                def mvn_version = 'M3'
                withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
                    sh "mvn clean package"
                    //sh "${tool 'M3'}/bin/mvn  clean install -Dtest=none -Dit.test=none -DfailIfNoTests=false"
                }
                //sh "${tool 'M3'}/bin/mvn  clean install -Dtest=none -Dit.test=none -DfailIfNoTests=false"
                //sh "${tool 'M3'}/bin/mvn install"
            }else {
                echo 'its an windows environment'
                bat "${tool 'M3'}/bin/mvn install"
            }
        }

        stage('deployment') {
            if (isUnix()) {
                /*sh 'sudo -S true'*/
                sh 'sudo docker-compose build'
                sh 'sudo docker-compose up -d'
            } else {
                bat 'sudo docker-compose build'
                bat 'sudo docker-compose up -d'
            }
        }
    }
    finally{
        stage('Shutingdown Container') {
            if (isUnix()) {
                //sh 'sudo docker-compose down'
            } else {
                //bat 'sudo docker-compose down'
            }

        }

    }
}

