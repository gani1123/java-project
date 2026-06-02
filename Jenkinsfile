@Library('my-shared-library') _

pipeline {

    agent any

    environment {

        AWS_ACCOUNT_ID = credentials('aws-account-id')
        AWS_REGION     = 'us-east-1'

        APP_NAME       = 'myapp'

        IMAGE_TAG      = "${BUILD_NUMBER}"
    }

    options {
        timestamps()
    }

    stages {

        stage('Checkout') {
            steps {
                gitCheckout(
                    'https://github.com/gani1123/java-project.git',
                    'main'
                )
            }
        }

        stage('Build') {
            steps {
                mavenBuild()
            }
        }

        stage('Docker Build') {
            steps {
                dockerBuild()
            }
        }

        stage('Push To ECR') {
            steps {
                dockerPush()
            }
        }

        stage('Update Manifest') {
            steps {
                updateManifest()
            }
        }

        stage('Deploy To EKS') {
            steps {
                k8sDeploy()
            }
        }
    }

    post {

        success {
            echo "Deployment Successful"
        }

        failure {
            echo "Deployment Failed"
        }

        always {
            cleanWs()
        }
    }
}
