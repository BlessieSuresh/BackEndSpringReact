#!/usr/bin/env groovy

node {
    
    stage('First') {
    	bat('set')
    }
    
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
}
