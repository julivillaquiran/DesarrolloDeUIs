package cases;

import appmodel.SolveCaseWindowAppModel;
import gameCase.Case;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class MessageDialog extends Dialog<SolveCaseWindowAppModel> {
  public MessageDialog(final WindowOwner owner, final SolveCaseWindowAppModel model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    SolveCaseWindowAppModel _modelObject = this.getModelObject();
    Case _thisCase = _modelObject.getThisCase();
    String _caseName = _thisCase.getCaseName();
    String _plus = ("Resolviendo" + _caseName);
    String title = new String(_plus);
    this.setTitle(title);
    Label _label = new Label(mainPanel);
    _label.setText("Estas visitando:");
    Label _label_1 = new Label(mainPanel);
    _label_1.<Object, ControlBuilder>bindValueToProperty("whichPlace.name");
    Label _label_2 = new Label(mainPanel);
    _label_2.<Object, ControlBuilder>bindValueToProperty("message");
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Continuar");
        final Action _function = new Action() {
          public void execute() {
            MessageDialog.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
