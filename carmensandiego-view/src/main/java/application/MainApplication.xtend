package application

import org.uqbar.arena.Application
import view.GameSystemWindow
import appmodel.GameSystemAppModel

class MainApplication extends Application {

	
	override protected createMainWindow() {
		var model = new GameSystemAppModel()
		new GameSystemWindow(this, model) 
	}
	
	def static void main(String[] args) {
		new MainApplication().start()
	}
	
}