package appmodel;

import gameCase.Case;
import java.util.List;
import java.util.Random;
import model.GameSystem;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class NewCaseWindowAppModel {
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  private Case _thisCase;
  
  public Case getThisCase() {
    return this._thisCase;
  }
  
  public void setThisCase(final Case thisCase) {
    this._thisCase = thisCase;
  }
  
  public NewCaseWindowAppModel(final GameSystem gameSystem) {
    this.setGameSystem(gameSystem);
    Case _chooseCase = this.chooseCase();
    this.setThisCase(_chooseCase);
  }
  
  public Case chooseCase() {
    GameSystem _gameSystem = this.getGameSystem();
    List<Case> _cases = _gameSystem.getCases();
    return NewCaseWindowAppModel.<Case>random(_cases);
  }
  
  public static <E extends Object> E random(final List<E> col) {
    E _xblockexpression = null;
    {
      Random _random = new Random();
      int _size = col.size();
      final int index = _random.nextInt(_size);
      _xblockexpression = col.get(index);
    }
    return _xblockexpression;
  }
}
