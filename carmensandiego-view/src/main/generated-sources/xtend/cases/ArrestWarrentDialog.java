package cases;

import appmodel.ArrestWarrentDialogAppModel;
import appmodel.SolveCaseWindowAppModel;
import gameCase.Case;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import villain.Villain;

@SuppressWarnings("all")
public class ArrestWarrentDialog extends Dialog<ArrestWarrentDialogAppModel> {
  public ArrestWarrentDialog(final WindowOwner owner, final ArrestWarrentDialogAppModel model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    ArrestWarrentDialogAppModel _modelObject = this.getModelObject();
    SolveCaseWindowAppModel _solveCaseWindowAppModel = _modelObject.getSolveCaseWindowAppModel();
    Case _thisCase = _solveCaseWindowAppModel.getThisCase();
    String _caseName = _thisCase.getCaseName();
    String _plus = ("Resolviendo " + _caseName);
    String _plus_1 = (_plus + ": Emisión orden de Arresto");
    String title = new String(_plus_1);
    this.setTitle(title);
    ArrestWarrentDialogAppModel _modelObject_1 = this.getModelObject();
    SolveCaseWindowAppModel _solveCaseWindowAppModel_1 = _modelObject_1.getSolveCaseWindowAppModel();
    Villain _captureOrder = _solveCaseWindowAppModel_1.getCaptureOrder();
    String _name = _captureOrder.getName();
    String _plus_2 = ("Orden de arresto emitida contra: " + _name);
    String arrestWarrant = new String(_plus_2);
    Label _label = new Label(mainPanel);
    _label.setText(arrestWarrant);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Villano:");
    Selector<Object> _selector = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.<Object, ControlBuilder>bindValueToProperty("warrent");
        Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("solveCaseWindowAppModel.gameSystem.files");
        PropertyAdapter _propertyAdapter = new PropertyAdapter(Villain.class, "name");
        _bindItemsToProperty.setAdapter(_propertyAdapter);
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Emitir Orden");
        final Action _function = new Action() {
          public void execute() {
            ArrestWarrentDialogAppModel _modelObject = ArrestWarrentDialog.this.getModelObject();
            _modelObject.sendWarrent();
            ArrestWarrentDialog.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
}
