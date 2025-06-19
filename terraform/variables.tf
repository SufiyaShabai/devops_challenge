variable "aws_region" {}
variable "vpc_name" {}
variable "vpc_cidr" {}
variable "azs" {
  type = list(string)
}
variable "private_subnets" {
  type = list(string)
}
variable "public_subnets" {
  type = list(string)
}
variable "docker_image_url" {}
variable "project_name" {}
variable "environment" {}
