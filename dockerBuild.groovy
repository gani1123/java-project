def call(imageName) {
    sh "docker build -t ${imageName} ."
}
