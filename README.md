# projeto-orange-selenium
    Projeto de automação de testes para o sistema OrangeHRM Demo, utilizando Java, Selenium WebDriver, Cucumber e JUnit, com aplicação das boas práticas de automação de testes como Page Object Model (POM).

# Visão Geral
    Este projeto tem como objetivo automatizar cenários críticos do sistema OrangeHRM, garantindo:
        - Validação de funcionalidades essenciais
        - Reutilização de código
        - Facilidade de manutenção
        - Padronização da automação

    Os testes cobrem fluxos de login e funcionalidades do módulo administrativo, assegurando a qualidade do sistema.

# Sistema Testado
    🔗 https://opensource-demo.orangehrmlive.com/
    O OrangeHRM é um sistema de gestão de recursos humanos que permite:
        - Gestão de usuários
        - Cadastro de funcionários
        - Controle de permissões
        - Administração de módulos


# Funcionalidades Automatizadas
    - Login
        ✔ Login com credenciais válidas
        ✔ Login com credenciais inválidas
        ✔ Validação da mensagem de erro ("Invalid credentials")
        ✔ Validação de acesso ao Dashboard

    - Módulo Admin (Search Users)
        ✔ Acesso ao menu Admin
        ✔ Validação do carregamento da tela
        ✔ Busca de usuário por Username
        ✔ Execução do botão Search
        ✔ Verificação dos resultados na tabela
        ✔ Validação do usuário retornado


# Estrutura do Projeto
    projeto-orange-selenium/
    ├── pom.xml
    ├── README.md
    ├── src/
    │   ├── test/
    │   │   ├── java/
    │   │   │   ├── pages/         # Page Objects
    │   │   │   ├── steps/         # Step Definitions (Cucumber)
    │   │   │   ├── hooks/         # Setup e teardown
    │   │   │   ├── runners/       # Runner Cucumber
    │   │   │   └── tests/         # Testes JUnit
    │   │   └── resources/
    │   │       ├── features/      # Arquivos .feature
    │   │       └── setup.properties # Configuração
    ├── target/
    │   └── ...


# Principais Tecnologias
    Java 21
    Selenium WebDriver
    Cucumber (BDD)
    JUnit 5
    Maven
    Gherkin


# Requisitos

    Java JDK 11 ou superior
    Maven 3.6+
    Navegador Chrome instalado


# Instalação

    Clone o repositório:
        git clone <URL_DO_REPOSITORIO>

    Acesse o projeto:
        cd projeto-orange-selenium

    Instale as dependências:
        mvn clean install

# Execução dos Testes
    Executar todos os testes
        mvn test

    Executar via IntelliJ
        Clique com botão direito em:
            - LoginTest
            - Runner Cucumber
        Selecione Run



    Executar cenários específicos (Cucumber)
        mvn test -Dcucumber.filter.tags="@login"

# Configuração
    Arquivo localizado em:
        src/test/resources/setup.properties

    Exemplo:
        base.url=https://opensource-demo.orangehrmlive.com/
        base.user=Admin
        base.password=admin123


# Fluxo de Automação

    Criação do cenário .feature
    Implementação dos Steps
    Criação dos Page Objects
    Execução via Runner ou JUnit
    Validação dos resultados


# Exemplos de Cenários
    Localização:
        src/test/resources/features

    Exemplo:
        Scenario: Login válido
        Given que o usuário está na tela de login
        When ele informa usuário válido e senha válida
        Then deve acessar o dashboard

# Boas Práticas Aplicadas

✔ Page Object Model (POM)
✔ Separação por camadas (Pages, Steps, Hooks)
✔ Uso de WebDriverWait
✔ Externalização de dados (setup.properties)
✔ Testes reutilizáveis e independentes


# Dicas de Manutenção

Organizar features por funcionalidade
Reutilizar métodos nas páginas
Evitar duplicação de código
Centralizar configurações
Atualizar locators quando necessário