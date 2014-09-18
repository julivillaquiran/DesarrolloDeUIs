package cases

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import appmodel.SolveCaseWindowAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button

class MessageDialog extends Dialog<SolveCaseWindowAppModel>{
	
	new(WindowOwner owner, SolveCaseWindowAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		var title = new String("Resolviendo" + modelObject.thisCase.caseName)
		this.title = title
		
		new Label(mainPanel).text = "Estas visitando:"
		new Label(mainPanel).bindValueToProperty("whichPlace.name")
		
		new Label(mainPanel).bindValueToProperty("message")
		
		new Button(mainPanel)=>[
			caption = "Continuar"
			onClick = [ | this.close
			]
		]
		
	}
	
	
	
}