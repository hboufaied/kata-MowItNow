Feature: Mower Movement

  Scenario Outline: Should move mower to final position when execute command list
    Given the initial position <InitialPosition> and <GardenLimit>
    And with the following <Commands>
    When I move the mower with the following instructions
    Then the final position is <FinalPosition>
    Examples:
      | InitialPosition | GardenLimit | Commands     | FinalPosition |
      | 1 2 "N"         | 5 5         | "GAGAGAGAA"  | 1 3 "N"       |
      | 3 3 "E"         | 5 5         | "AADAADADDA" | 5 1 "E"       |