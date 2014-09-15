package application;

import appmodel.CreateVillainAppModel;
import model.GameSystem;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import villain.Villain;
import villainView.CreateVillainWindow;

@SuppressWarnings("all")
public class CreateVillainApplication extends Application {
  private GameSystem gameSystem = new GameSystem();
  
  private Villain villain = new Villain();
  
  protected Window<?> createMainWindow() {
    CreateVillainWindow _xblockexpression = null;
    {
      CreateVillainAppModel model = new CreateVillainAppModel(this.gameSystem, this.villain, true);
      _xblockexpression = new CreateVillainWindow(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    CreateVillainApplication _createVillainApplication = new CreateVillainApplication();
    _createVillainApplication.start();
  }
}
