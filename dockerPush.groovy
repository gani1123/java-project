def call(imageName) {

    sh '''
        aws ecr get-login-password --region us-east-1 | \
        docker login --username AWS --password-stdin \
        962800862954.dkr.ecr.us-east-1.amazonaws.com
    '''

    sh "docker push ${imageName}"
}
