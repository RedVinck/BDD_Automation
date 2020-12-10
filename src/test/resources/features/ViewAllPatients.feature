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


#  Scenario: Er worden geen maaltijden getoond want er staan geen maaltijden op het menu
#    Given er geen maaltijden op het menu staan
#    When Wanneer Jan op het menu kijkt
#    Then krijgt Jan een melding dat er momenteel nog geen maaltijden op het menu  staan

