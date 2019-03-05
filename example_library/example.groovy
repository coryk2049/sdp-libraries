def call() {


    stage("Example"){
        node{
            sh "echo HelloWorld!"
        }
    }

    return this
}