pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/gani1123/java-project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

    }  // ✅ THIS WAS MISSING

    post {
        success {
            echo 'Build completed successfully ✅'
        }
        failure {
            echo 'Build failed ❌'
        }
    }

    
}
