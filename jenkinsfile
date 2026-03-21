pipeline {
    agent any

    tools {
        maven 'Maven'   // Make sure Maven is configured in Jenkins
        jdk 'Java'      // Make sure JDK is configured
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/gani1123/java-project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
