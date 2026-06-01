def call(String imageName) {

    def region = "us-east-1"
    def accountId = "962800862954"
    def repo = "${accountId}.dkr.ecr.${region}.amazonaws.com/myapp"

    sh """
        echo "Logging into AWS ECR..."
        aws ecr get-login-password --region ${region} \
        | docker login --username AWS --password-stdin ${accountId}.dkr.ecr.${region}.amazonaws.com

        echo "Tagging image..."
        docker tag ${imageName} ${repo}:latest

        echo "Pushing image to ECR..."
        docker push ${repo}:latest
    """
}

