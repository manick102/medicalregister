pipeline {
    agent any

    environment {
        // Define global variables (optional)
        MAVEN_HOME = '/usr/share/maven' // Adjust if needed
    }

    tools {
        maven 'Maven 3.8.1' // Make sure it's configured in Jenkins
        jdk 'Java 17'       // Set your JDK version in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        // Optional: Deployment stage
        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo 'Deploying the application...'
                // Example: Copy to remote server or run Docker command
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}