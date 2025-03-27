pipeline {
    agent any
    environment {
            // Đặt biến môi trường cho thông tin server
            DOCKER_IMAGE = 'lamnn1996/app-cicd:1.0.0' // Tên image và tag
            REMOTE_SERVER = 'root@34.172.226.205' // Đường dẫn trên server remote
            DOCKER_CONTAINER = 'app-cicd-service' // Địa chỉ Docker Registry
            SONAR_SCANNER_HOME = 'SonarQScanner'
            SONAR_PROJECT_KEY = 'project-cicd'
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
        stage('SonarQ stage') {
            steps {
                withCredentials([string(credentialsId: 'sonarq-id',variable: 'SONAR_TOKEN')]) {
                    withSonarQubeEnv('SonarQ') {
                                          sh """
                                             ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                                            -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                                            -Dsonar.sources=. \
                                            -Dsonar.host.url=http://34.28.1.150:9001 \
                                            -Dsonar.login=${SONAR_TOKEN}
                                             """
                }
                }
            }
        }
        // stage('SSH server') {
        //     steps {
        //         sshagent(['ssh-remote']) {
        //                                   sh """
        //                                     ssh ${REMOTE_SERVER} "docker pull ${DOCKER_IMAGE} || true"
        //                                     ssh ${REMOTE_SERVER} "docker stop ${DOCKER_CONTAINER} || true"
        //                                     ssh ${REMOTE_SERVER} "docker rm ${DOCKER_CONTAINER} || true"
        //                                     ssh ${REMOTE_SERVER} "docker run -d --name ${DOCKER_CONTAINER} -p 8081:8080 ${DOCKER_IMAGE} || true"
        //                                      """
        //         }
        //     }
        // }
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