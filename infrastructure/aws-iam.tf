data "aws_iam_policy_document" "ms_ponto" {
  statement {
    effect = "Allow"
    actions = [
      "dynamodb:DescribeTable",
      "dynamodb:GetItem",
      "dynamodb:PutItem",
      "dynamodb:Query",
      "dynamodb:Scan", # Bad design. Scan is slow and lead to high costs.
      "dynamodb:UpdateItem",
    ]
    resources = [
      aws_dynamodb_table.pontos.arn,
      "${aws_dynamodb_table.pontos.arn}/*"
    ]
  }
}
