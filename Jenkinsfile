pipeline {
    agent any
    environment {
            // Đặt biến môi trường cho thông tin server
            DOCKER_IMAGE = 'lamnn1996/app-cicd:1.0.0' // Tên image và tag
            DEPLOY_PATH = '/path/to/deploy' // Đường dẫn trên server remote
            DOCKER_REGISTRY = 'your_docker_registry' // Địa chỉ Docker Registry
    }
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
                                          sh """
                                            docker pull ${DOCKER_IMAGE} # Kéo image từ Docker Registry
                                            docker stop ${DOCKER_IMAGE} || true # Dừng container cũ nếu có
                                            docker rm ${DOCKER_IMAGE} || true # Xóa container cũ nếu có
                                            docker run -d --name ${DOCKER_IMAGE} -p 8080:8080 ${DOCKER_IMAGE} # Chạy container mới
                                            """
                }
            }
        }
            post {
                success {
                    echo 'Deployment successful!'
                }
                failure {
                    echo 'Deployment failed!'
                }
            }
    }
}