def gv

pipeline{

    agent any

    environment{
        NEW_VERSION = '1.3.0'
    }

    parameters{
        booleanParam(name: 'executeTests', defaultValue: true, description:'this is a test')
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'VERSIONS available')
    }

    stages{

        stage("init"){
            steps{
                script{
                    gv = load "scripts.groovy"
                }    
            }
        }

        stage("build"){
            steps{
                script{
                    gv.buildApp()
                }
            }
        }

        stage("test"){
            when{
                expression{
                    (env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'main') && params.executeTests == true
                }
            }    
            steps{
                script{
                    gv.testApp()
                }
            }
        }

        stage("deploys"){

            steps{
                script{
                    gv.deployApp()   
                }
            }
        }
    }
}