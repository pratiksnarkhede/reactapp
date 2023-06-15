def call() {
    stage('Run Container on Dev Server') {
            script {
                def dockerRun = "sudo docker run -p 8080:80 -d --name react-app pratik0078/nodeapp:$BUILD_NUMBER"
                sshagent(['docker-server']) {
                    sh "ssh -o StrictHostKeyChecking=no azureuser@20.102.62.140 ${dockerRun}"
                
            }
        }
    }
}
