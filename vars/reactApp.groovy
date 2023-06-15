def scm(){
  stage('SCM Checkout'){
    script {
         git 'https://github.com/pratiksnarkhede/reactapp.git'
  }
  }
}
def build(){
 stage('Build docker image') {
     script {
           
       sh 'docker build -t pratik0078/nodeapp:$BUILD_NUMBER .'
     }
        }
  }
def login(){
    stage('Login to DockerHub') {
        script {
           
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        } 
        }
  }
def pushimage(){
    stage('Push image') {
        script {
           
                sh 'docker push pratik0078/nodeapp:$BUILD_NUMBER'
        }
        }
  }
  
def deploy() {
    stage('Run Container on Dev Server') {
            script {
                def dockerRun = "sudo docker run -p 8080:80 -d --name react-app pratik0078/nodeapp:$BUILD_NUMBER"
                sshagent(['docker-server']) {
                    sh "ssh -o StrictHostKeyChecking=no azureuser@20.102.62.140 ${dockerRun}"
                
            }
        }
    }
}
 

            
