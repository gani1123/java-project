def call() {

    withCredentials([[
        $class: 'AmazonWebServicesCredentialsBinding',
        credentialsId: 'AWS-cred'
    ]]) {

        sh '''
            aws eks update-kubeconfig \
            --region us-east-1 \
            --name dev-eks

            kubectl apply -f Deployment.yaml

            kubectl rollout status deployment/web-app --timeout=300s
        '''
    }
}
