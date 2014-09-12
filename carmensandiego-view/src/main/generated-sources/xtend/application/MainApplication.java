package application;

import appmodel.GameSystemAppModel;
import model.GameSystem;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import testingData.TestingData;
import view.GameSystemWindow;

@SuppressWarnings("all")
public class MainApplication extends Application {
  private GameSystem gameSystem = new GameSystem();
  
  protected Window<?> createMainWindow() {
    GameSystemWindow _xblockexpression = null;
    {
      GameSystemAppModel model = new GameSystemAppModel(this.gameSystem);
      TestingData _testingData = new TestingData();
      GameSystem _createGameSystem = _testingData.createGameSystem();
      model.setGameSystem(_createGameSystem);
      _xblockexpression = new GameSystemWindow(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    MainApplication _mainApplication = new MainApplication();
    _mainApplication.start();
  }
}
