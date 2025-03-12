docker run -u root –rm -d -p 8080:8080 -p 50000:50000 –name jenkins -v $(which docker):/usr/bin/docker -v jenkins-data:/var/jenkins_home -v /var/run/docker.sock:/var/run/docker.sock jenkins/jenkins



docker run --name jenkins -u root -d -v jenkins_home:/var/jenkins_home -v $(which docker):/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock -p 8080:8080 -p 50000:50000 --restart=on-failure jenkins/jenkins:lts


docker run -u root -d --name jenkins -p 8080:8080 -p 50000:50000 -v /Users/macbook/work-space/project/jenkin:/var/jenkins_home -v $(which docker):/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock --restart=on-failure jenkins/jenkins:lts

docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v /Users/macbook/work-space/project/jenkin:/var/jenkins_home -v $(which docker):/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock --restart=on-failure jenkins/jenkins:lts

/Users/macbook/Library/Containers/com.docker.docker/Data/vms/0/data

sudo dseditgroup -o edit -a admin -t user daemon

sudo dscl . append /Groups/daemon GroupMembership admin
sudo dscl . append /Groups/daemon GroupMembership jenkins

dscl . -read /Groups/daemon GroupMembership


docker run -d --name jenkins -p 8080:8080 -p 50000:50000 -v /Users/macbook/work-space/project/jenkin:/var/jenkins_home -v $(which docker):/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock --restart=on-failure jenkins/jenkins:lts



docker run -d --prvileged --name jenkins -p 8080:8080 -p 50000:50000 -v /Users/macbook/work-space/project/jenkin:/var/jenkins_home -v $(which docker):/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock --restart=on-failure --group-add $(stat -c '%g' /var/run/docker.sock) jenkins/jenkins:lts


docker run -d \
--name jenkins \
-u root \
--privileged \
-p 8080:8080 \
-p 50000:50000 \
-v /Users/macbook/work-space/project/jenkin:/var/jenkins_home \
-v $(which docker):/usr/bin/docker \
-v /var/run/docker.sock:/var/run/docker.sock \
--restart=on-failure \
jenkins/jenkins:lts

cài thêm docker trong container
https://datmt.com/devops/how-to-add-docker-client-to-jenkins/