pipeline {
    agent any
    
    stages {
            stage('Compile') {
                steps {
                    sh './mvnw clean compile -e'
                }
            }
            
            stage('Test Code') {
                steps {
                    sh './mvnw clean test -e'
                }
            }
            stage('Jar') {
                steps {
                    sh './mvnw clean package -e'
                }
            }
            stage('SonarQube analysis') {
                steps {
                    withSonarQubeEnv('Sonar') { // You can override the credential to be used
                        sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                    }
                }
            }
            stage('Run Jar') {
                steps {
                    sh 'nohup bash mvnw.cmd spring-boot:run &'
                }
            }
    }
}
