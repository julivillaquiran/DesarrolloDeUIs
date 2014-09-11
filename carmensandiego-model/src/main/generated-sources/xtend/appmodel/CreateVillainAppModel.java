package appmodel;

import java.util.Arrays;
import java.util.List;
import model.GameSystem;
import model.Gender;
import model.Hobbie;
import model.Villain;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class CreateVillainAppModel {
  private Villain _villain;
  
  public Villain getVillain() {
    return this._villain;
  }
  
  public void setVillain(final Villain villain) {
    this._villain = villain;
  }
  
  private Hobbie _newHobbie;
  
  public Hobbie getNewHobbie() {
    return this._newHobbie;
  }
  
  public void setNewHobbie(final Hobbie newHobbie) {
    this._newHobbie = newHobbie;
  }
  
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  public CreateVillainAppModel(final GameSystem gameSystem) {
    this.setGameSystem(gameSystem);
    Villain _villain = new Villain();
    this.setVillain(_villain);
  }
  
  public void addVillain() {
    GameSystem _gameSystem = this.getGameSystem();
    Villain _villain = this.getVillain();
    _gameSystem.addVillains(_villain);
  }
  
  public void addHobbie() {
    Villain _villain = this.getVillain();
    Hobbie _newHobbie = this.getNewHobbie();
    _villain.addHobbies(_newHobbie);
  }
  
  public List<Gender> getGender() {
    Gender[] _values = Gender.values();
    return Arrays.<Gender>asList(_values);
  }
  
  public List<Hobbie> getHobbies() {
    Hobbie[] _values = Hobbie.values();
    return Arrays.<Hobbie>asList(_values);
  }
  
  public List<String> getSigns() {
    Villain _villain = this.getVillain();
    return _villain.getSigns();
  }
  
  public List<Villain> getFiles() {
    GameSystem _gameSystem = this.getGameSystem();
    return _gameSystem.getFiles();
  }
}
