package appmodel

import model.GameSystem
import org.uqbar.commons.utils.Observable
import villain.Villain

@Observable
class FilesWindowAppModel {
	@Property
	GameSystem gameSystem
	
	@Property
	Villain selectedVillain

	@Property
	boolean toEdit
	
	new(GameSystem gameSystem, boolean toEdit){
		this.toEdit = toEdit
		this.gameSystem = gameSystem
	}
	
}