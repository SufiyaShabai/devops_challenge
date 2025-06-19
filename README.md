# DevOps Challenge – Time Service Application

This project is a DevOps coding challenge submission. It includes:
- A simple Java Spring Boot microservice
- A secure, production-grade multi-stage Dockerfile
- Terraform configuration to deploy the application on AWS ECS using Fargate behind an Application Load Balancer (ALB)

## 🗂 Project Structure
├── app/ # Spring Boot application and Dockerfile
├── terraform/ # Terraform files for AWS deployment
├── .gitignore
├── .gitattributes
├── README.md
├── mvnw, mvnw.cmd # Maven wrapper scripts
└── .mvn/wrapper/ # Maven wrapper binaries

## Application Overview
I have created a simple microservice using java springboot and maven as build tool.
The microservice returns the current server ip,time in JSON format once / URL path is accessed:
The main logic syntax is presesnt in "controller" package inside the app.

## Prerequisites
Before proceeding, ensure you have the following installed:
Docker
AWS CLI
Terraform
Git

## Docker Instructions
- Build the Docker Image
Navigate to the app/ directory:
cd app
docker build -t sufiyashabai/simple-time-service .
-Run the Container
docker run -p 8080:8080 sufiyashabai/simple-time-service
-Test the Endpoint
Open in browser or use curl:
curl http://localhost:8080/

## DockerHub Image
The image has been published to Docker Hub and is available publicly:
Image Link: https://hub.docker.com/r/sufiyashabai/simple-time-service

##  Deploy to AWS with Terraform
Steps to Deploy
-Set your AWS credentials securely using environment variables:
export AWS_ACCESS_KEY_ID=your_access_key
export AWS_SECRET_ACCESS_KEY=your_secret_key
export AWS_DEFAULT_REGION=your_region

-Navigate to terraform folder
cd terraform

-AWS Authentication Setup
Before running terraform apply, ensure you're authenticated to your AWS account. The recommended way to do this is:
Configure AWS CLI
Run the following command and provide your IAM user credentials:
aws configure
You will be prompted to enter:
AWS Access Key ID
AWS Secret Access Key
Default region name (e.g., us-east-1)
Default output format (press Enter to keep as json

- Initialize Terraform
terraform init
terraform plan
terraform apply

-Once terraform apply completes, it will print the DNS of the Application Load Balancer:
Test in browser using 
curl http://your-alb-dns-name.amazonaws.com/
