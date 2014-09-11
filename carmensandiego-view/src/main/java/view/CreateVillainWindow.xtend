package view

import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import appmodel.CreateVillainAppModel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.List

class CreateVillainWindow extends SimpleWindow<CreateVillainAppModel> {
	
	new(WindowOwner parent, CreateVillainAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//no queremos usar este template default
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Crear Nuevo Villano"
		mainPanel.layout = new VerticalLayout 
		
		new Label(mainPanel).text="Nombre:"
		new TextBox(mainPanel)=>[
			bindValueToProperty("villain.name")
			width=200
		]
		
		new Label(mainPanel).text="Genero:"
		new Selector(mainPanel) => [
			bindItemsToProperty("gender")
			bindValueToProperty("villain.sex")
		]
		
		new Label(mainPanel).text="Hobbies:"
		new List(mainPanel) => [
			bindItemsToProperty("villain.hobbies")
		]
		new Selector(mainPanel) => [
			bindItemsToProperty("hobbies")
			bindValueToProperty("newHobbie")
		]
		
		new Button(mainPanel)=>[
			caption = "Nuevo Hobbie"
			onClick = [| modelObject.addHobbie ]
//			onClick = [ | new NewHobbieWindow(this, this.modelObject.villainAppModel).open ]
		]
		
		
		new Label(mainPanel).text="Señas:"
//		new TextBox(mainPanel)=>[
//			bindValueToProperty("villain.signs")
//			width=200
//		]
		
		new Label(mainPanel).text="Files:"
		new List(mainPanel) => [
			bindItemsToProperty("gameSystem.files")
		]
		
		new Button(mainPanel)=>[
			caption = "Aceptar"
			onClick = [ |
				this.modelObject.addVillain
				//this.close
			]
		]
	}
	
}