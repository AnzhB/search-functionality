    Feature: Search


      Scenario: First search result
        Given main page is opened
        When click search icon
        Then verify search panel appears
        When type "testing" into search field
        Then verify 1st search result

      @run
      Scenario: Empty search results
        Given main page is opened
        When click search icon
        Then verify search panel appears
        When type randomly generated query into search field
        Then verify there ara no search results


