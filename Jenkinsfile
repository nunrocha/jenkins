pipeline{

    agent any

    parameters{
        booleanParam(name: 'executeTests', defaultValue: true, description:'this is a test')
    }

    stages{

        stage("build"){
            steps{
                echo "building the application.."
                echo "building version ${NEW_VERSION}"
            }
        }

        stage("test"){
            when{
                expression{
                    (env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'main') && params.executeTests == true
                }
            }    
            steps{
                echo "testing the application.."
            }
        }

        stage("deploys"){

            steps{
                echo "deploying the application.."
                withCredentials([
                    usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PWD)
                ]]{
                        sh "${USER}, ${PWD}"
                }
                echo "deploying with ${SERVER_CREDENTIALS}"
            }
        }
    }
}