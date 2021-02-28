#!/usr/bin/env groovy

node {
    def mvnHome
    
    stage('First') {
    	bat("printenv")
    }
    
    stage('checkout') {
        checkout scm
    }

    stage('Build') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
}
