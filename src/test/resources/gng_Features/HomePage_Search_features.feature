Feature: Test Search Feature of on GNG home page

  Scenario:Search feature validation with offer search
    Given User is on home page
    When User search product with shorter keyword like "Tom"
    When User search same short product "Tom" on offer page
    Then Both Search results should match
