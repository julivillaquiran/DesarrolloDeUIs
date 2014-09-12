package appmodel

import org.uqbar.commons.utils.Observable
import villain.Villain
import model.GameSystem

@Observable
class GameSystemAppModel {
	
	@Property
	Villain villain

	@Property
	GameSystem gameSystem
	
	@Property
	FilesWindowAppModel filesWindowAppModel
	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem
	}
	
}