package view;

import appmodel.NewCaseWindowAppModel;
import appmodel.SolveCaseWindowAppModel;
import cases.SolveCaseWindow;
import gameCase.Case;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class NewCaseWindow extends SimpleWindow<NewCaseWindowAppModel> {
  public NewCaseWindow(final WindowOwner parent, final NewCaseWindowAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    actionsPanel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar Caso");
        final Action _function = new Action() {
          public void execute() {
            NewCaseWindowAppModel _modelObject = NewCaseWindow.this.getModelObject();
            GameSystem _gameSystem = _modelObject.getGameSystem();
            NewCaseWindowAppModel _modelObject_1 = NewCaseWindow.this.getModelObject();
            Case _thisCase = _modelObject_1.getThisCase();
            SolveCaseWindowAppModel _solveCaseWindowAppModel = new SolveCaseWindowAppModel(_gameSystem, _thisCase);
            SolveCaseWindow _solveCaseWindow = new SolveCaseWindow(NewCaseWindow.this, _solveCaseWindowAppModel);
            _solveCaseWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Rechazar Caso");
        final Action _function = new Action() {
          public void execute() {
            NewCaseWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    NewCaseWindowAppModel _modelObject = this.getModelObject();
    Case _thisCase = _modelObject.getThisCase();
    String _caseName = _thisCase.getCaseName();
    this.setTitle(_caseName);
    Label _label = new Label(mainPanel);
    _label.setText("Bienvenido Detective, tenemos un nuevo caso para usted:");
    Label _label_1 = new Label(mainPanel);
    _label_1.<Object, ControlBuilder>bindValueToProperty("thisCase.description");
  }
}
