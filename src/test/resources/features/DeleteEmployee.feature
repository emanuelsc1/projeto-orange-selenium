Feature: Deletar usuário no sistema OrangeHRM

  @login
  Scenario: Deletar usuario
    Given que estou logado e na tela de funcionarios
    When acesso a tabela com a lista de funcionarios
    And deleto o funcionario
    Then o funcionario deve ser removido com sucesso