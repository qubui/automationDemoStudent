pipeline {
    agent any

    environment {
        // You can modify the path according to your setup
        SELENIUM_TEST_DIR = 'path/to/your/selenium/tests' // Path to your Selenium test project
        HTML_REPORT_DIR = ' test-output/testng-results.html' // TestNG result report location
        EMAIL_RECIPIENTS = 'nguyenquy1409@gmail.com' // Add your email here
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout your repository with Selenium tests
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    // Run Selenium tests using TestNG
                       "mvn test -DsuiteXmlFile=testng.xml" // Adjust if you have a specific test suite
                }
            }
        }

        stage('Archive Test Results') {
            steps {
                // Archive the TestNG report
                junit '**/test-output/testng-results.xml' // Path to your TestNG XML results
            }
        }

        stage('Email Report') {
            steps {
                script {
                    // Send email with the HTML report attached
                    emailext(
                        subject: "Test Results - ${currentBuild.fullDisplayName}",
                        body: "Please find the attached test report for the executed Selenium TestNG tests.",
                        to: "${EMAIL_RECIPIENTS}",
                        attachLog: true,
                        attachmentsPattern: HTML_REPORT_DIR
                    )
                }
            }
        }
    }

    // Schedule the pipeline (use cron-like syntax)
    triggers {
        cron('H 2 * * 1') // Example: every Monday at 2:00 AM
    }

    post {
        always {
            cleanWs() // Clean workspace after the build is done
        }
        success {
            echo 'Tests ran successfully!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}