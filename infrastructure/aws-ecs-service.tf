module "name" {
  source = "github.com/soat1-grupo18/hackathon-ecs-service-terraform-module"

  app_name              = "ms-ponto"
  app_docker_image      = "ms-ponto"
  app_docker_port       = 8080
  app_health_check_path = "/actuator/health"
  ecs_cluster_name      = "fiap-ecs-cluster"
}