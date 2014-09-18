package cases

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.PropertyAdapter
import villain.Villain
import appmodel.ArrestWarrentDialogAppModel
import org.uqbar.arena.widgets.Button

class ArrestWarrentDialog extends Dialog<ArrestWarrentDialogAppModel>{
	
	new(WindowOwner owner, ArrestWarrentDialogAppModel model) {
		super(owner, model)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		var title = new String("Resolviendo " + modelObject.solveCaseWindowAppModel.thisCase.caseName + ": Emisión orden de Arresto")
		this.title = title
		
		var arrestWarrant = new String("Orden de arresto emitida contra: " + modelObject.solveCaseWindowAppModel.captureOrder.name)
		new Label(mainPanel).text = arrestWarrant
		
		new Label(mainPanel).text = "Villano:"
		new Selector(mainPanel) =>[
			bindValueToProperty("warrent")
			bindItemsToProperty("solveCaseWindowAppModel.gameSystem.files").adapter = new PropertyAdapter(Villain, "name")
		]
		
		new Button(mainPanel)=>[
			caption = "Emitir Orden" 
			onClick=[ | 
				modelObject.sendWarrent
				this.close
			]
		]
	}

}