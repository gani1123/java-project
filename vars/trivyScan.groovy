def call(String imageName = '', String imageTag = '') {

    if (imageName && imageTag) {
        // Docker image scan
        sh """
        echo "Running Trivy Image Scan..."
        export TMPDIR=/opt/trivy-temp
        trivy image --severity HIGH,CRITICAL --exit-code 1 ${imageName}:${imageTag}
        """
    } else {
        // Filesystem scan
        sh """
        echo "Running Trivy FS Scan..."
        export TMPDIR=/opt/trivy-temp
        trivy fs --severity HIGH,CRITICAL --exit-code 1 .
        """
    }
}
