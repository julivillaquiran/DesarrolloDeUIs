package view;

import appmodel.CreateVillainAppModel;
import model.Villain;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CreateVillainWindow extends SimpleWindow<CreateVillainAppModel> {
  public CreateVillainWindow(final WindowOwner parent, final CreateVillainAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Crear Nuevo Villano");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("villain.name");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Genero:");
    Selector<Object> _selector = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function_1 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.bindItemsToProperty("gender");
        it.<Object, ControlBuilder>bindValueToProperty("villain.sex");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_1);
    Label _label_2 = new Label(mainPanel);
    _label_2.setText("Hobbies:");
    List<Object> _list = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function_2 = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        it.bindItemsToProperty("villain.hobbies");
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function_2);
    Selector<Object> _selector_1 = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function_3 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.bindItemsToProperty("hobbies");
        it.<Object, ControlBuilder>bindValueToProperty("villain.newHobbie");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector_1, _function_3);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Nuevo Hobbie");
        final Action _function = new Action() {
          public void execute() {
            CreateVillainAppModel _modelObject = CreateVillainWindow.this.getModelObject();
            Villain _villain = _modelObject.getVillain();
            _villain.addHobbie();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_4);
    Label _label_3 = new Label(mainPanel);
    _label_3.setText("Señas:");
    TextBox _textBox_1 = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_5 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("villain.signs");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_5);
    Label _label_4 = new Label(mainPanel);
    _label_4.setText("Files:");
    List<Object> _list_1 = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function_6 = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        it.bindItemsToProperty("gameSystem.files");
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list_1, _function_6);
    Button _button_1 = new Button(mainPanel);
    final Procedure1<Button> _function_7 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            CreateVillainAppModel _modelObject = CreateVillainWindow.this.getModelObject();
            _modelObject.addVillain();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_7);
  }
}
