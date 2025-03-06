pipeline {
    agent any
    stages {
        stage('Clone stage') {
            steps {
                git 'https://github.com/lamnnse04432/java-cicd.git'
            }
        }
        stage('Build stage') {
            steps {
                withDockerRegistry(credentialsId: 'docker-hub',url: 'https://index.docker.io/v1/') {
                    sh 'docker build -t lamnn1996/app-cicd:1.0.0 .'
                    sh 'docker push lamnn1996/app-cicd:1.0.0'
                    // some block
                }
            }
        }
    }
}