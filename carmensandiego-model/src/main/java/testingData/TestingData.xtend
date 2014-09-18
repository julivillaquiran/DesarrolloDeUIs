package testingData

import villain.Villain
import model.GameSystem
import villain.Gender
import villain.Hobbie
import country.Country
import country.InterestPlace
import country.Places
import java.util.Random
import gameCase.Case

class TestingData {
	
	//Case newCase
	int index
	Random r1
	
	GameSystem gameSystem = new GameSystem
	def createGameSystem(){
		gameSystem =>[			
			addVillains(createVillain1("Villano 1"))
			addVillains(createVillain2("Nastrow Banks"))
			addVillains(createVillain3("Jhonny Q"))
			
			addCountries(createCountry1())
			addCountries(createCountry2())
			addCountries(createCountry3())
			addCountries(createCountry4())
			
			addCases(createCase1())
			addCases(createCase2())
		]
	}
	
	def createCase1() {
		r1 = new Random
		index = r1.nextInt(gameSystem.files.size)
		new Case(gameSystem.files.get(index))=>[
			caseName = "El Collar Real"
			description = "El Collar real ha sido robado"
			escapeRoute.add(gameSystem.worldMap.get(2))
			escapeRoute.add(gameSystem.worldMap.get(1))
			escapeRoute.add(gameSystem.worldMap.get(0)=>[places.get(2).isHere = true])
		]
	}
	
	def createCase2() {
		r1 = new Random
		index = r1.nextInt(gameSystem.files.size)
		new Case(gameSystem.files.get(index))=>[
			caseName = "El cetro del faraon"
			description = "El cetro del gan faraón ha sido robado"
			escapeRoute.add(gameSystem.worldMap.get(2))
			escapeRoute.add(gameSystem.worldMap.get(1))
			escapeRoute.add(gameSystem.worldMap.get(0))
			
		]
	}
	

	
	def createCountry1() {
		new Country =>[
			name = "Afganistan"
			characteristics.add("Hablan arabe")
			characteristics.add("Son Islamistas")
			places.add(new InterestPlace => [name = Places.Banco])	
			places.add(new InterestPlace => [name = Places.Embajada])	
			places.add(new InterestPlace => [name = Places.Club])
		]
	}
	
	def createCountry2() {
		new Country =>[
			name = "Inglaterra"
			characteristics.add("Hablan ingles")
			characteristics.add("Tienen Reina")
			places.add(new InterestPlace => [name = Places.Club])
			places.add(new InterestPlace => [name = Places.Embajada])
			places.add(new InterestPlace => [name = Places.Banco])
			connections.add(gameSystem.worldMap.get(0))
		]
	}
	
	def createCountry3() {
		new Country =>[
			name = "Canada"
			characteristics.add("Hablan ingles")
			characteristics.add("Hablan Frances")
			places.add(new InterestPlace => [name = Places.Biblioteca])
			places.add(new InterestPlace => [name = Places.Embajada])
			places.add(new InterestPlace => [name = Places.Club])
			connections.add(gameSystem.worldMap.get(0))
			connections.add(gameSystem.worldMap.get(1))
					
		]
	}
	
	def createCountry4() {
		new Country =>[
			name = "Japon"
			characteristics.add("Involucrados en WWII")
			characteristics.add("Origen de los Yakuza")
			places.add(new InterestPlace => [name = Places.Club])
			places.add(new InterestPlace => [name = Places.Embajada])
			places.add(new InterestPlace => [name = Places.Banco])
			connections.add(gameSystem.worldMap.get(0))
			connections.add(gameSystem.worldMap.get(1))
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