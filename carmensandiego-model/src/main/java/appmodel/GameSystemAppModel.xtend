package appmodel

import org.uqbar.commons.utils.Observable
import model.GameSystem
import java.util.Random

@Observable
class GameSystemAppModel {

	@Property
	GameSystem gameSystem
	
	@Property
	FilesWindowAppModel filesWindowAppModel
	
	@Property
	WorldMapAppModel worldMapAppModel
	
	@Property
	Random r1 = new Random

	
	new(GameSystem gameSystem){
		this.gameSystem = gameSystem
	}
	
}