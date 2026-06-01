pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/sdetposition/SR_SDET_TDD.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test -Dbrowser=chrome'
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'

            archiveArtifacts artifacts: 'test-output/**, target/surefire-reports/**', allowEmptyArchive: true

            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'TestNG Report'
            ])
        }
    }
}