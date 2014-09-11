package application

import org.uqbar.arena.Application
import view.GameSystemWindow
import appmodel.GameSystemAppModel
import model.GameSystem

class MainApplication extends Application {
	GameSystem gameSystem = new GameSystem()

	
	override protected createMainWindow() {
		var model = new GameSystemAppModel(gameSystem)
		new GameSystemWindow(this, model) 
	}
	
	def static void main(String[] args) {
		new MainApplication().start()
	}
	
}