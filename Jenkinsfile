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
                    withSonarQubeEnv('Sonar') {
                        sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                    }
                }
            }
            stage('uploadNexus') {
                steps {
                    nexusPublisher nexusInstanceId: 'nexus-andres', 
                    nexusRepositoryId: 'test-repo', 
                    packages: [[$class: 'MavenPackage', 
                        mavenAssetList: [[classifier: '', 
                            extension: 'jar', 
                            filePath: '/home/felipe/Documentos/Diplomado USACH/fork-ejemplo-maven/DevOpsUsach2020-0.0.1.jar']], 
                            mavenCoordinate: [
                                artifactId: 'DevOpsUsach2020', 
                                groupId: 'com.devopsusach2020', 
                                packaging: 'jar', 
                                version: '0.0.1'
                            ]
                        ]
                    ]
                }
            }
    }
}
