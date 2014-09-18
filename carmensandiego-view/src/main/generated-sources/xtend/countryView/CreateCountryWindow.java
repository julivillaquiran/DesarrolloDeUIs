package countryView;

import appmodel.CreateCountryAppModel;
import country.Country;
import country.InterestPlace;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
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
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class CreateCountryWindow extends SimpleWindow<CreateCountryAppModel> {
  private String buttonCaption;
  
  public CreateCountryWindow(final WindowOwner parent, final CreateCountryAppModel model, final String title, final String buttonCaption) {
    super(parent, model);
    this.setTitle(title);
    this.buttonCaption = buttonCaption;
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("country.name");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Conexiones:");
    List<Object> _list = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function_1 = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("country.connections");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.<Object, ControlBuilder>bindValueToProperty("takenConnection");
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function_1);
    Selector<Object> _selector = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function_2 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("possibleConnections");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.<Object, ControlBuilder>bindValueToProperty("newConnection");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_2);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar Conexión");
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.addConnection();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_3);
    Button _button_1 = new Button(mainPanel);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Quitar Conexión");
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.takeConnection();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_4);
    Label _label_2 = new Label(mainPanel);
    _label_2.setText("Caracteristicas:");
    List<Object> _list_1 = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function_5 = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        it.bindItemsToProperty("country.characteristics");
        it.<Object, ControlBuilder>bindValueToProperty("takenCharacteristic");
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list_1, _function_5);
    Label _label_3 = new Label(mainPanel);
    _label_3.setText("Escriba una nueva caracteristica:");
    TextBox _textBox_1 = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_6 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("newCharacteristic");
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_6);
    Button _button_2 = new Button(mainPanel);
    final Procedure1<Button> _function_7 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar Caracteristica");
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.addCharacteristic();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_7);
    Button _button_3 = new Button(mainPanel);
    final Procedure1<Button> _function_8 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Quitar Caracteristica");
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.takeCharacteristic();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_3, _function_8);
    Label _label_4 = new Label(mainPanel);
    _label_4.setText("Lugares de interes:");
    List<Object> _list_2 = new List<Object>(mainPanel);
    final Procedure1<List<Object>> _function_9 = new Procedure1<List<Object>>() {
      public void apply(final List<Object> it) {
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("country.places");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(InterestPlace.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.<Object, ControlBuilder>bindValueToProperty("takenPlace");
      }
    };
    ObjectExtensions.<List<Object>>operator_doubleArrow(_list_2, _function_9);
    Label _label_5 = new Label(mainPanel);
    _label_5.setText("Escoja un nuevo lugar:");
    Selector<Object> _selector_1 = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function_10 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("gameSystem.interestPlaces");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(InterestPlace.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
        it.<Object, ControlBuilder>bindValueToProperty("newPlace");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector_1, _function_10);
    Button _button_4 = new Button(mainPanel);
    final Procedure1<Button> _function_11 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Agregar Lugar de Interes:");
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.addPlace();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_4, _function_11);
    Button _button_5 = new Button(mainPanel);
    final Procedure1<Button> _function_12 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Quitar Lugar de Interes");
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.takePlace();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_5, _function_12);
    Button _button_6 = new Button(mainPanel);
    final Procedure1<Button> _function_13 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption(CreateCountryWindow.this.buttonCaption);
        final Action _function = new Action() {
          public void execute() {
            CreateCountryAppModel _modelObject = CreateCountryWindow.this.getModelObject();
            _modelObject.addCountry();
            CreateCountryWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_6, _function_13);
  }
}
