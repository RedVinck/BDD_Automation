Feature: View all meals

  As a caretaker
  I want to get the list of all patients
  In order to consult the data of a certain patient

	#Personas
	# Jan - Klant

  Scenario: Alle maaltijden worden getoond
    Given dat er maaltijden op het menu staan
    When Wanneer Jan op het menu kijkt
    Then Dan worden alle maaltijden getoond die op het menu staan


#  Hier moeten de stories


  Scenario: Er worden geen maaltijden getoond want er staan geen maaltijden op het menu
    Given er geen maaltijden op het menu staan
    When Wanneer Jan op het menu kijkt
    Then krijgt Jan een melding dat er momenteel nog geen maaltijden op het menu  staan

  Rule: Informatie over allergieën en al dan niet vegetarisch moet getoond worden
    Scenario: Jan krijgt extra informatie bij een maaltijd
      Given dat er maaltijden zijn waar extra informatie bij hoort
      When Wanneer Jan op het menu kijkt
      Then zou Jan het menu te zien moeten krijgen met bij elke maaltijd extra informatie over wat deze bevat.

  Rule: De prijs moet altijd getoond worden
    Scenario: De prijs wordt bij de maaltijd getoond
      Given dat er maaltijden op het menu staan
      When Wanneer Jan op het menu kijkt
      Then ziet “Jan” bij elke maaltijd de prijs van de maaltijd

  Rule: Maaltijden worden gegroepeerd per categorie

    Scenario:  Jan bekijkt het overzicht
      Given er maaltijden van verschillende categorieën op het menu staan
      When Wanneer Jan op het menu kijkt
      Then ziet “Jan” dat de maaltijden per categorie gegroepeerd staan