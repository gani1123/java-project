@Library('my-shared-library') _

pipeline {

    agent any

    environment {
        AWS_ACCOUNT_ID = credentials('aws-account-id')
        AWS_REGION     = 'us-east-1'

        APP_NAME       = 'myapp'
        SONAR_HOST_URL = 'http://ec2-32-193-251-152.compute-1.amazonaws.com:9000'
        NEXUS_REPO_URL = 'http://ec2-32-193-251-152.compute-1.amazonaws.com:8081/repository/maven-releases/'
        IMAGE_TAG      = "${BUILD_NUMBER}"
        REPOSITORY     = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/myapp"
    }

    options {
        timestamps()
    }

    stages {

        // ✅ Checkout
        stage('Checkout') {
            steps {
                gitCheckout(
                    'https://github.com/gani1123/java-project.git',
                    'main'
                )
            }
        }

        // ✅ Build (Maven)
        stage('Build') {
            steps {
                mavenBuild()
            }
        }

        // ✅ SonarQube analysis
        stage('SonarQube Analysis') {
            steps {
                sonarQubeAnalysis()
            }
        }

        // ✅ Nexus deploy
        stage('Nexus Deploy') {
            steps {
                nexusDeploy()
            }
        }

        // ✅ Trivy FS Scan (code + dependencies)
        stage('Trivy FS Scan') {
            steps {
                trivyScan()
            }
        }

        // ✅ Docker Build
        stage('Docker Build') {
            steps {
                dockerBuild()
            }
        }

        // ✅ Trivy Image Scan (container security)
        stage('Trivy Image Scan') {
            steps {
                trivyScan(
                    "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${APP_NAME}",
                    "${IMAGE_TAG}"
                )
            }
        }

        // ✅ Push image to ECR
        stage('Push To ECR') {
            steps {
                dockerPush()
            }
        }

        // ✅ Update Kubernetes manifest
        stage('Update Manifest') {
            steps {
                updateManifest()
            }
        }

        // ✅ Deploy to EKS
        stage('Deploy To EKS') {
            steps {
                k8sDeploy()
            }
        }
    }

    post {

        success {
            echo "✅ Deployment Successful"
        }

        failure {
            echo "❌ Deployment Failed (Check Trivy or Build logs)"
        }

        always {
            cleanWs()
        }
    }
}
