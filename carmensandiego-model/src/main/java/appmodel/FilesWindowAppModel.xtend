package appmodel

import org.uqbar.commons.utils.Observable
import villain.Villain
import model.GameSystem
import villain.Hobbie

@Observable
class FilesWindowAppModel {
	@Property
	GameSystem gameSystem
	
	@Property
	Villain selectedVillain
	
	@Property
	Hobbie selectedHobbie
	
	@Property
	String selectedSign
	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem

	}
	
	
	
}