def buildJar() {
    echo "building the application......0"
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image......"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t muhab404/jenkins-demo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push muhab404/jenkins-demo:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application......'
} 

return this
