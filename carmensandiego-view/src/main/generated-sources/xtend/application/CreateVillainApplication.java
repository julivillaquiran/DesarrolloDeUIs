package application;

import appmodel.CreateVillainAppModel;
import model.GameSystem;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import view.CreateVillainWindow;

@SuppressWarnings("all")
public class CreateVillainApplication extends Application {
  private GameSystem gameSystem = new GameSystem();
  
  protected Window<?> createMainWindow() {
    CreateVillainWindow _xblockexpression = null;
    {
      CreateVillainAppModel model = new CreateVillainAppModel(this.gameSystem);
      _xblockexpression = new CreateVillainWindow(this, model);
    }
    return _xblockexpression;
  }
}
