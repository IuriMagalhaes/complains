# complains
Microsserviço para receber e trafegar os dados de reclamações de pós venda de um e-commerce. 


# Evidência

Foi gravada uma evidência da interação do ms-complain com a aws
1. Request do postman para o ms-complains para gerar uma nova reclamação
2. ms-complains salva a reclamação no dynamodb
3. Nota fiscal enviada como evidência é salva em um bucket S3
4. Reclamação é enviada para o SQS para futuramente ser consumida pelo ms-attendence e realizar o atendimento da reclamação

### Link da evidência: https://youtu.be/bS-nU0wC2k0
[![VideoEvidencia](https://img.youtube.com/vi/bS-nU0wC2k0/0.jpg)](https://youtu.be/bS-nU0wC2k0 "Video do funcionamento")
