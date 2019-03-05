def call() {

    node{
        sh "echo HelloWorld!"
    }

    return this
}