def call(){
   sh "ssh -o StrictHostKeyChecking=no azureuser@20.102.62.140 ${dockerRun}"
}
