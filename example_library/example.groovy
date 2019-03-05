def call() {
    stage("Example"){
        node{
            sh "echo Example!"
        }
    }
    return this
}