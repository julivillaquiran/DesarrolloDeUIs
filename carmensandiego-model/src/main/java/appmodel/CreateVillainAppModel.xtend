package appmodel

import org.uqbar.commons.utils.Observable
import java.util.Arrays
import villain.Villain
import model.GameSystem
import villain.Gender
import villain.Hobbie

@Observable
class CreateVillainAppModel {
	@Property
	Villain villain
	@Property
	Villain selectedVillain
	
	@Property
	Hobbie newHobbie
	@Property
	Hobbie takenHobbie
	
	@Property
	String newSign
	@Property
	String takenSign
	
	@Property
	GameSystem gameSystem
	
	@Property
	boolean edit
	
	new(GameSystem gameSystem, Villain selectedVillain, boolean edit){
		this.gameSystem = gameSystem
		this.edit = edit
		if(edit)
			villain = selectedVillain
		else
			villain = new Villain
	}
	
	def addVillain(){
		if(!gameSystem.villains.contains(villain) && (villain!=null))
			gameSystem.addVillains(villain)
	}
	
	def addHobbie(){
		villain.addHobbies(newHobbie)
	}
	
	def takeHobbie(){
		villain.takeHobbies(takenHobbie)
	}	
	
	def addSign(){
		if(!villain.signs.contains(newSign) && (newSign!=null))
			villain.addSigns(newSign)
	}
	
	def takeSign(){
		villain.takeSigns(takenSign)
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