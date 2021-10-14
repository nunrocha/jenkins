def buildApp(){
    echo "building the application.."
    sh 'docker build -t dockerrochatest/app-test:latest .'
}

def loginPushApp(){
    echo 'loging into docker hub....'
    sh "docker login -u ${USER} -p ${PWD}"
    echo 'pushing image to docker hub...'
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