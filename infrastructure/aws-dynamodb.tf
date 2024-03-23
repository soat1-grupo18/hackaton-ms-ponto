resource "aws_dynamodb_table" "pontos" {
  name         = "Pontos"
  billing_mode = "PAY_PER_REQUEST"
  hash_key     = "id"

  attribute {
    name = "id"
    type = "S"
  }
}