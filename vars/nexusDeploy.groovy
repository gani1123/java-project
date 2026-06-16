def call() {
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
        sh """
            cat > settings.xml <<'EOF'
            <settings>
              <servers>
                <server>
                  <id>nexus</id>
                  <username>${NEXUS_USERNAME}</username>
                  <password>${NEXUS_PASSWORD}</password>
                </server>
              </servers>
            </settings>
            EOF

            mvn deploy -DskipTests \
                -DaltDeploymentRepository=nexus::default::${env.NEXUS_REPO_URL} \
                --settings settings.xml
        """
    }
}
