pipeline {
    agent any
    stages {
        stage("checkout"){
            steps{
            cleanWs()
               checkout scmGit(branches: [[name:'${Branch_Name}']],
               userRemoteConfigs: [[url:'${Git_url}']])
            }
        }
        stage("maven"){
            steps{
                sh "mvn clean"
                sh "mvn install"
            }
        }
        stage("build"){
            steps{
                sh "docker build -t ${Image_Name} ."
                // sh "sudo docker tag ${Image_Name}:${Image_version} purushothshanmugam/spring-application"
                // sh " sudo docker push purushothshanmugam/spring-application:latest"
            }
        }
        stage("Push To ECR"){
            steps{
                sh "aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws/e4a0x4z6"
                sh "docker tag ${Image_Name}:${Image_version} public.ecr.aws/e4a0x4z6/testing-02:${Image_version}"
                sh "docker push public.ecr.aws/e4a0x4z6/testing-02:${Image_version}"
            }
        }
        stage("deployment") {
            steps{
                 
                  sh "kubectl apply -f deployment/"
                //   sh "sed -i 's|image:.*|image: purushothshanmugam/spring-application:version-01|g' deployment.yml"
                //   sh "kubectl apply -f deployment.yml"
                //   sh "kubectl apply -f service.yml"
            }
          
        }
    }
}