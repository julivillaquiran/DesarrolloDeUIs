package application;

import model.GameSystem;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class CreateVillainApplication extends Application {
  private GameSystem gameSystem = new GameSystem();
  
  protected Window<?> createMainWindow() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor CreateVillainAppModel(GameSystem, Villain, boolean) is not applicable for the arguments (GameSystem)");
  }
  
  public static void main(final String[] args) {
    CreateVillainApplication _createVillainApplication = new CreateVillainApplication();
    _createVillainApplication.start();
  }
}
