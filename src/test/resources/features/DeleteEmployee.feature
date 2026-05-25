Feature: Deletar usuário no sistema OrangeHRM

  Scenario: Deletar usuario
    Given que estou logado e na tela de funcionarios
    When busco pelo "funcionario"
    And deleto o funcionario
    Then o funcionario deve ser removido com sucesso