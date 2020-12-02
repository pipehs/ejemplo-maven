pipeline {
    agent any
    
    stages {
            stage('Compile') {
                steps {
                    dir('/home/felipe/Documentos/Diplomado USACH/fork-ejemplo-maven'){
                        sh './mvnw clean compile -e'
                    }
                }
            }
            
            stage('Test Code') {
                steps {
                    dir('/home/felipe/Documentos/Diplomado USACH/fork-ejemplo-maven'){
                        sh './mvnw clean test -e'
                    }
                }
            }
            stage('Jar') {
                steps {
                    dir('/home/felipe/Documentos/Diplomado USACH/fork-ejemplo-maven'){
                        sh './mvnw clean package -e'
                    }
                }
            }
            stage('Run Jar') {
                steps {
                    dir('/home/felipe/Documentos/Diplomado USACH/fork-ejemplo-maven'){
                        sh './mvnw spring-boot:run'
                    }
                }
            }
    }
}
