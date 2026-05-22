Feature: Login no sistema OrangeHRM

  Scenario: Login válido
    Given que o usuário está na tela de login
    When ele informa usuário válido e senha válida
    And clica no botão de login
    Then deve acessar o dashboard

  Scenario: Login inválido
    Given que o usuário está na tela de login
    When ele informa usuário válido e senha inválida
    And clica no botão de login
    Then deve ver mensagem de erro