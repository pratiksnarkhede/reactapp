def runDockerContainer(String imageTag, String sshHost, String sshUser) {
    def dockerRun = "sudo docker run -p 8080:80 -d --name react-app pratik0078/nodeapp:${imageTag}"
    sshagent([sshHost]) {
        sh "ssh -o StrictHostKeyChecking=no ${sshUser}@${sshHost} ${dockerRun}"
    }
}
