Feature: Adding ad to memo as a favorite

Scenario: Go to any category search for an ad open it scroll down to Add to favourites
Given Open chrome browser and navigate to reklama.bb.lv web page
When Go to Dzivokli category
When Search for an ad
When Open an ad
When Scroll down to "Add to favourites" and click "Add to favourites"
When Open "Memo" section
Then Check added ad