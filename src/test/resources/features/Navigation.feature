Feature: Navegacao entre paginas no OrangeHRM

  @login
  Scenario: Navegar do dashboard para Performance
    Given que estou na pagina inicial
    When clico no botao "Performance"
    Then devo estar na pagina "Performance"
    And a url da pagina deve conter "/performance/"

  @login
  Scenario: Navegar do dashboard para Admin
    Given que estou na pagina inicial
    When clico no botao "Admin"
    Then devo estar na pagina "Admin"
    And a url da pagina deve conter "/admin/"

