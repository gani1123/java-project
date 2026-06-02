withCredentials([[
    $class: 'AmazonWebServicesCredentialsBinding',
    credentialsId: 'AWS-cred'
]]) {

    sh """
        aws ecr get-login-password --region ${env.AWS_REGION} | \
        docker login --username AWS --password-stdin \
        ${env.AWS_ACCOUNT_ID}.dkr.ecr.${env.AWS_REGION}.amazonaws.com

        docker push ${repository}:${env.IMAGE_TAG}
        docker push ${repository}:latest
    """
}
