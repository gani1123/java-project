☕ Java Web App — CI/CD Pipeline on AWS EKS


Java Maven web application with a complete 10-stage Jenkins CI/CD pipeline —
built with Jenkins Shared Libraries, DevSecOps scanning, AWS ECR, and Kubernetes deployment.




🏗️ Architecture

GitHub → Jenkins → Maven Build → SonarQube → Nexus → Trivy FS Scan → 
Docker Build → Trivy Image Scan → ECR Push → K8s Manifest Update → EKS Deploy


📁 Repository Structure

java-project/
├── src/main/
│   ├── java/com/example/game/   # Java GameServlet source code
│   └── webapp/                  # Web application (2048 Game UI)
├── vars/                        # Jenkins Shared Library functions
│   ├── gitCheckout.groovy       # Git checkout
│   ├── mavenBuild.groovy        # Maven WAR build
│   ├── dockerBuild.groovy       # Docker image build (AWS ECR)
│   └── dockerPush.groovy        # Push image to ECR
├── Deployment.yaml              # Kubernetes deployment manifest
├── Dockerfile                   # Container image definition
├── Jenkinsfile                  # 10-stage CI/CD pipeline
└── pom.xml                      # Maven project config


⚙️ CI/CD Pipeline — 10 Stages

groovy@Library('my-shared-library') _

pipeline {
  stages {
    stage('Checkout')           // Pull code from GitHub
    stage('Build')              // Maven WAR build
    stage('SonarQube Analysis') // Code quality gate
    stage('Nexus Deploy')       // Upload artifact to Nexus
    stage('Trivy FS Scan')      // Filesystem vulnerability scan
    stage('Docker Build')       // Build container image
    stage('Trivy Image Scan')   // Container image vulnerability scan
    stage('Push To ECR')        // Push to AWS ECR registry
    stage('Update Manifest')    // Update Kubernetes deployment manifest
    stage('Deploy To EKS')      // Deploy to AWS EKS cluster
  }
}

Pipeline Features:


⏱️ Timestamps on every stage
🔒 AWS credentials via Jenkins credential store
🔍 Dual Trivy scanning — filesystem AND container image
🧹 Workspace cleanup after every run (cleanWs())
📦 Artifact versioned by Jenkins build number



🔐 DevSecOps — Dual Security Scanning

Most pipelines scan only the container image. This pipeline scans twice:

ScanStageWhat It ChecksTrivy FS ScanBefore Docker buildSource code + dependencies (CVEs in pom.xml)Trivy Image ScanAfter Docker buildOS packages + libraries in container image


If either scan detects CRITICAL vulnerabilities — pipeline fails before ECR push.




☸️ Kubernetes Deployment

bash# Verify deployment
kubectl get pods
kubectl get svc
kubectl get deployment

Deployment Strategy: Rolling update — zero downtime

Manifest: Deployment.yaml — image tag auto-updated by pipeline on every build


🧰 Tech Stack

LayerToolLanguageJavaBuildMavenCode QualitySonarQubeArtifact StoreNexus RepositorySecurityTrivy (FS + Image)ContainerizationDockerRegistryAWS ECROrchestrationKubernetes (AWS EKS)CI/CDJenkins + Shared Library


🚀 How to Run Locally

bash# Clone the repo
git clone https://github.com/gani1123/java-project.git
cd java-project

# Build with Maven
mvn clean package

# Build Docker image
docker build -t java-app .

# Run locally
docker run -p 8080:8080 java-app


👨‍💻 Author

Ganesh Nalli — AWS DevOps Engineer

🔗 LinkedIn • GitHub

📧 ganeshnalli.devops@gmail.com
