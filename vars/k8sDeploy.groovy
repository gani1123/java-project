def call() {

    sh '''
        kubectl apply -f Deployment.yaml
    '''

    sh '''
        kubectl rollout status deployment/web-app
    '''
}
