pipeline {
    agent { label 'linux' } // run on your agent

    environment {
        TF_VAR_region = 'ap-south-1'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/gani1123/terraform.git'
            }
        }

        stage('Terraform Init') {
            steps {
                sh 'terraform init'
            }
        }

        stage('Terraform Plan') {
            steps {
                sh 'terraform plan -out=tfplan'
            }
        }

        
    }
}
