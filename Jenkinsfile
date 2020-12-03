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
            stage('SonarQube analysis') {
                withSonarQubeEnv('Sonar') { // You can override the credential to be used
                    sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
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
