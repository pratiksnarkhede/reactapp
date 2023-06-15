def call(){
   sh "ssh -o StrictHostKeyChecking=no azureuser@20.102.62.140 ${dockerRun}"
}
def dockerRun(){
 "sudo docker run -p 8080:80 -d --name react-app pratik0078/nodeapp:$BUILD_NUMBER"
}
