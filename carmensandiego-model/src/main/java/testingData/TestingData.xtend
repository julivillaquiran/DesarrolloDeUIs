package testingData

import villain.Villain
import model.GameSystem
import villain.Gender
import villain.Hobbie

class TestingData {
	def createGameSystem(){
		new GameSystem =>[
			addVillains(createVillain1("Villano 1"))
			addVillains(createVillain2("Nastrow Banks"))
			addVillains(createVillain3("Jhonny Q"))
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
	
	
	
}