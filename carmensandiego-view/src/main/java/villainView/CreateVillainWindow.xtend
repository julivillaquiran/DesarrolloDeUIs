package villainView

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
		if(modelObject.edit)
			title = "Editar Villano"
		else
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
		
		//Control over Hobbies property
		new Label(mainPanel).text="Hobbies asignados:"
		new List(mainPanel) => [
			bindItemsToProperty("villain.hobbies")
			bindValueToProperty("takenHobbie")
		]
		new Label(mainPanel).text="Seleccione nuevo hobbie:"
		new Selector(mainPanel) => [
			bindItemsToProperty("hobbies")
			bindValueToProperty("newHobbie")
		]
		new Button(mainPanel)=>[
			caption = "Agregar Hobbie"
			onClick = [| modelObject.addHobbie ]
//			onClick = [ | new NewHobbieWindow(this, this.modelObject.villainAppModel).open ]
		]
		new Button(mainPanel)=>[
			caption = "Quitar Hobbie"
			onClick = [| modelObject.takeHobbie ]
		]
		
		//Control over Signs property
		new Label(mainPanel).text="Señas:"
		new List(mainPanel) => [
			bindItemsToProperty("villain.signs")
			bindValueToProperty("takenSign")
		]
		new Label(mainPanel).text="Escriba una nueva caracteristica:"
		var newSign = new TextBox(mainPanel)=>[bindValueToProperty("newSign")]
		new Button(mainPanel)=>[
			caption = "Agregar caracteristica"
			onClick = [| modelObject.addSign ]
			//add action of clear newSign TextBox, how is done?	
//			onClick = [ | new NewSignWindow(this, this.modelObject.villainAppModel).open ]
		]
		new Button(mainPanel)=>[
			caption = "Quitar caracteristica"
			onClick = [| modelObject.takeSign ]
		]
		
		
		new Button(mainPanel)=>[
			if(modelObject.edit)
			caption = "Terminar Edicion"
		else
			caption = "Crear Villano"
			onClick = [ |
				this.modelObject.addVillain
				this.close
			]
		]
	}
	
}