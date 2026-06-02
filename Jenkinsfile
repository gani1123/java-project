@Library('my-shared-library') _

pipeline {
    agent any
    environment {
        TF_VAR_region = 'us-east-1'
    }
    stages {
        stage('Checkout') {
            steps {
                gitCheckout('https://github.com/gani1123/java-project.git', 'main')
            }
        }
        stage('Build') {
            steps {
                mavenBuild()
            }
        }
        stage('Docker Build') {
            steps {
                dockerBuild("${ECR_REPO}:latest")
            }
        }

        stage('Push to ECR') {
            steps {
                dockerPush("${ECR_REPO}:latest")
            }
        }
    }
}
