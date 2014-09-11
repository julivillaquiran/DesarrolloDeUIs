package model;

import java.util.List;
import model.Gender;
import model.Hobbie;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Villain {
  private String _name;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private Gender _sex;
  
  public Gender getSex() {
    return this._sex;
  }
  
  public void setSex(final Gender sex) {
    this._sex = sex;
  }
  
  private List<String> _signs = CollectionLiterals.<String>newArrayList();
  
  public List<String> getSigns() {
    return this._signs;
  }
  
  public void setSigns(final List<String> signs) {
    this._signs = signs;
  }
  
  private String _newSign;
  
  public String getNewSign() {
    return this._newSign;
  }
  
  public void setNewSign(final String newSign) {
    this._newSign = newSign;
  }
  
  private List<Hobbie> _hobbies = CollectionLiterals.<Hobbie>newArrayList();
  
  public List<Hobbie> getHobbies() {
    return this._hobbies;
  }
  
  public void setHobbies(final List<Hobbie> hobbies) {
    this._hobbies = hobbies;
  }
  
  public void addHobbies(final Hobbie newHobbie) {
    List<Hobbie> _hobbies = this.getHobbies();
    _hobbies.add(newHobbie);
    List<Hobbie> _hobbies_1 = this.getHobbies();
    ObservableUtils.firePropertyChanged(this, "hobbies", _hobbies_1);
  }
  
  public void addNewSign(final String newSign) {
    List<String> _signs = this.getSigns();
    _signs.add(newSign);
    List<String> _signs_1 = this.getSigns();
    ObservableUtils.firePropertyChanged(this, "signs", _signs_1);
  }
}
