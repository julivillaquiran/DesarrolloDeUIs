package view

import org.uqbar.commons.utils.Observable
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import appmodel.VillainAppModel

@Observable
class NewHobbieWindow extends Dialog<VillainAppModel> {
	
	new(WindowOwner owner, VillainAppModel model) {
		super(owner,  new VillainAppModel())
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Nuevo Hobbie"
		mainPanel.layout = new VerticalLayout 
		
		new Label(mainPanel).text="Nombre:"
		new TextBox(mainPanel)=>[
			bindValueToProperty("newHobbie")
			width=200
		]
		new Button(mainPanel)=>[
			caption = "Aceptar"
			onClick = [ |
				this.close
			]
		]
	}
	
}