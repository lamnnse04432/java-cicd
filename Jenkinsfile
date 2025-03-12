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
        stage('SSH server') {
            steps {
                sshagent(['ssh-remote']) {
                    sh 'ssh -o StrictHostKeyChecking=no -l root 34.143.249.48 touch test.txt'
                }
            }
        }
    }
}