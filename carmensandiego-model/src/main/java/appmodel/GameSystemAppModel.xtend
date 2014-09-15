package appmodel

import org.uqbar.commons.utils.Observable
import model.GameSystem

@Observable
class GameSystemAppModel {

	@Property
	GameSystem gameSystem
	
	@Property
	FilesWindowAppModel filesWindowAppModel
	
	@Property
	WorldMapAppModel worldMapAppModel
	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem
	}
	
}