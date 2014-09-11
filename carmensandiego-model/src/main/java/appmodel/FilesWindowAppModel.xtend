package appmodel

import org.uqbar.commons.utils.Observable
import model.Villain
import model.GameSystem
import model.Hobbie

@Observable
class FilesWindowAppModel {
	@Property
	GameSystem gameSystem
	
	@Property
	Villain selectedVillain
	
	@Property
	Hobbie selectedHobbie
	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem

	}
	
	
	
}