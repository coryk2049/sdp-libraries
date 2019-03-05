def call() {
    stage("Building Jar"){
        node{
            unstash "workspace"
            sh "./gradlew build"
        }
    }
}
