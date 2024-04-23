# ProjetoIntermedi-rioBackend
Repositorio criado para fins acadêmicos.

Projeto Backend

Este projeto é um backend desenvolvido em Java com o framework Spring Boot. Ele foi iniciado com o Spring Boot Initializer, uma ferramenta que simplifica a inicialização de projetos Spring Boot fornecendo modelos predefinidos e dependências configuradas. O presente projeto demonstra a construção de um backend intermediário para lidar com consultas de localização através de uma API externa.

Funcionamento
O projeto é dividido em quatro componentes principais:

1. ControllerLocalizacao
O ControllerLocalizacao é responsável por lidar com as requisições HTTP relacionadas à localização. Ele possui três endpoints principais:

/ajuda: Retorna informações de ajuda sobre o projeto, incluindo o nome do estudante e detalhes do projeto.
/consulta: Permite consultar a localização com base em um CEP fornecido. Quando um CEP é consultado, os dados brutos da API são salvos em uma lista para futura referência.
/salvar: Recebe dados da API e os envia para serem processados pelo serviço de localização. Após o processamento, os dados brutos e os dados formatados são salvos em um arquivo de texto.

2. ServiceLocalizacao
O ServiceLocalizacao é responsável por realizar consultas à API externa e processar os dados recebidos. Ele possui dois métodos principais:

consultarLocalizacao(cep): Realiza uma consulta à API externa usando o CEP fornecido e retorna os dados brutos da resposta.
processarDados(dados): Processa os dados recebidos da API, formatando-os em um formato legível e salvando-os juntamente com os dados brutos em um arquivo de texto.

3. ProjetoBackendApplication
A classe ProjetoBackendApplication é a classe principal que inicia a aplicação Spring Boot. Ela inicializa o contexto da aplicação e realiza uma consulta de exemplo à API de localização usando um CEP pré-definido.

4. Classe Localizacao
A classe Localizacao é responsável por representar os dados de localização recebidos da API externa.

Tecnologias Utilizadas.
Java.
Spring Boot.
Spring Web.
Jackson (para manipulação de JSON).
RestTemplate (para fazer requisições HTTP).

Instalação e Execução
Clone este repositório para sua máquina local.
Certifique-se de ter o Java e o Maven instalados em sua máquina.
Abra o projeto em sua IDE favorita.
Execute a classe ProjetoBackendApplication.
Após a inicialização do servidor, você pode acessar os endpoints fornecidos pelo ControllerLocalizacao em http://localhost:8080/localizacao. #ignorar este tópico, pois, devido a uma limitaçao da API apenas o endpoint ajuda esta funcionando. 

Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request para melhorar este projeto.

Autor
Angiel Leal.
