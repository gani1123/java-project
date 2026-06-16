def call() {
    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
        sh """
            mvn sonar:sonar \
                -Dsonar.host.url=${env.SONAR_HOST_URL} \
                -Dsonar.login=${SONAR_TOKEN}
        """
    }
}
