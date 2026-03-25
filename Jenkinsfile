@Library('my-shared-library') _

pipeline {
    stages {
        stage('Checkout') {
            steps {
                gitCheckout('https://github.com/yourrepo.git', 'main')
            }
        }
        stage('Build') {
            steps {
                mavenBuild()
            }
        }
        stage('Docker Build') {
            steps {
                dockerBuild('myapp:latest')
            }
        }
        stage('Push') {
            steps {
                dockerPush('myapp:latest')
            }
        }
    }
}
