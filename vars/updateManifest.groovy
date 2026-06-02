def call() {

    def image = "${env.AWS_ACCOUNT_ID}.dkr.ecr.${env.AWS_REGION}.amazonaws.com/${env.APP_NAME}:${env.IMAGE_TAG}"

    sh """
        sed -i 's|IMAGE_PLACEHOLDER|${image}|g' Deployment.yaml
    """
}
