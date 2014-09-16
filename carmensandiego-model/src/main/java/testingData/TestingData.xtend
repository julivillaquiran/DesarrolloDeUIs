package testingData

import villain.Villain
import model.GameSystem
import villain.Gender
import villain.Hobbie
import country.Country
import country.InterestPlace
import country.Places
import appmodel.GameSystemAppModel

class TestingData {
	
	GameSystem gameSystem = new GameSystem
	def createGameSystem(){
		gameSystem =>[			
			addVillains(createVillain1("Villano 1"))
			addVillains(createVillain2("Nastrow Banks"))
			addVillains(createVillain3("Jhonny Q"))
			
			addCountries(createCountry1())
			addCountries(createCountry2())
		]
	}
	

	
	def createCountry1() {
		new Country =>[
			name = "Afganistan"
			characteristics.add("Hablan arabe")
			characteristics.add("Son Islamistas")
			places.add(new InterestPlace => [name = Places.Banco])			
		]
	}
	
	def createCountry2() {
		new Country =>[
			name = "Inglaterra"
			characteristics.add("Hablan ingles")
			characteristics.add("Tienen Reina")
			places.add(new InterestPlace => [name = Places.Club])
			places.add(new InterestPlace => [name = Places.Embajada])			
		]
	}
	
	def createVillain1(String villainName){
		new Villain =>[
			name = villainName
			sex = Gender.Femenino
			hobbies.add(Hobbie.Beber)
			hobbies.add(Hobbie.Fumar)	
			signs.add("Alta")
			signs.add("Morena")
		]
	}
	def createVillain2(String villainName){
		new Villain =>[
			name = villainName
			sex = Gender.Masculino
			hobbies.add(Hobbie.Golf)
			hobbies.add(Hobbie.Fumar)
			signs.add("Chaparro")
			signs.add("Sueco")
		]
	}
	def createVillain3(String villainName){
		new Villain =>[
			name = villainName
			sex = Gender.Masculino
			hobbies.add(Hobbie.Golf)
			hobbies.add(Hobbie.Programar)
			signs.add("Likes Bling")
			signs.add("Heavy Gun")
		]
	}
	
	def saveData(GameSystem model){
		gameSystem.worldMap = model.worldMap
		gameSystem.files = model.files
		gameSystem.cases = model.cases
	}
	
	
	
}