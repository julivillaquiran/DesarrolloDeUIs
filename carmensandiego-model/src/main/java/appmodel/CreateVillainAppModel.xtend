package appmodel

import org.uqbar.commons.utils.Observable
import java.util.Arrays
import model.Villain
import model.GameSystem
import model.Gender
import model.Hobbie

@Observable
class CreateVillainAppModel {
	@Property
	Villain villain
	

	@Property
	GameSystem gameSystem
	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem
		
		villain = new Villain
	}
	
	def addVillain(){
		gameSystem.addVillains(villain)
	}
	
	def getGender(){
		Arrays.asList(Gender.values)
	}
	
	def getHobbies(){
		Arrays.asList(Hobbie.values)
	}
	
	def getSigns(){
		villain.signs
	}
	
	def getFiles(){
		gameSystem.files
	}
	
}