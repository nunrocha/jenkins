def buildApp(){
    echo "building the application.."
    sh 'docker build -t dockerrochatest/app-test:latest .'
}

def loginPushApp(){
    echo "loging into docker hub...."
    sh "echo ${DOCKERHUB_CREDENTIALS_PSW} | docker login -u ${DOCKERHUB_CREDENTIALS_USR} --password-stdin'
    echo "pushing image to docker hub..."
    sh 'docker push dockerrochatest/app-test:latest'
}

def testApp(){
    echo "testing the application.."
}

def deployApp(){
    echo "deploying the application.."
    echo "deploying version ${params.VERSION}"
}

return this