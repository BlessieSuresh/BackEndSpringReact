#!/usr/bin/env groovy

node {
    
    stage('checkout') {
        checkout scm
    }

    stage('Build') {
      if (isUnix()) {
         sh "'${MAVEN_HOME}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${MAVEN_HOME}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   
   stage('Unit Test') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   stage('Integration Test') {
     if (isUnix()) {
        sh "'${MAVEN_HOME}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
     } else {
        bat(/"${MAVEN_HOME}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
     }
   }
   stage('Sonar') {
      if (isUnix()) {
         sh "'${MAVEN_HOME}/bin/mvn' sonar:sonar"
      } else {
         bat(/"${MAVEN_HOME}\bin\mvn" sonar:sonar/)
      }
   }
   
}
