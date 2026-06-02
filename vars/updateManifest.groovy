def call() {

    def repository =
        "${env.AWS_ACCOUNT_ID}.dkr.ecr.${env.AWS_REGION}.amazonaws.com/${env.APP_NAME}"

    sh """
        sed -i 's|IMAGE_PLACEHOLDER|${repository}:${env.BUILD_NUMBER}|g' Deployment.yaml
    """
}
