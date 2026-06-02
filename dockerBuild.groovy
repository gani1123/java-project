def call() {

    def repository =
        "${env.AWS_ACCOUNT_ID}.dkr.ecr.${env.AWS_REGION}.amazonaws.com/${env.APP_NAME}"

    sh """
        docker build \
        -t ${repository}:${env.IMAGE_TAG} \
        -t ${repository}:latest .
    """
}
