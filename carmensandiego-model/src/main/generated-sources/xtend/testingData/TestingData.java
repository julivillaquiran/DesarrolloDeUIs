package testingData;

import java.util.List;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import villain.Gender;
import villain.Hobbie;
import villain.Villain;

@SuppressWarnings("all")
public class TestingData {
  public GameSystem createGameSystem() {
    GameSystem _gameSystem = new GameSystem();
    final Procedure1<GameSystem> _function = new Procedure1<GameSystem>() {
      public void apply(final GameSystem it) {
        Villain _createVillain1 = TestingData.this.createVillain1("Villano 1");
        it.addVillains(_createVillain1);
        Villain _createVillain2 = TestingData.this.createVillain2("Nastrow Banks");
        it.addVillains(_createVillain2);
        Villain _createVillain3 = TestingData.this.createVillain3("Jhonny Q");
        it.addVillains(_createVillain3);
      }
    };
    return ObjectExtensions.<GameSystem>operator_doubleArrow(_gameSystem, _function);
  }
  
  public Villain createVillain1(final String villainName) {
    Villain _villain = new Villain();
    final Procedure1<Villain> _function = new Procedure1<Villain>() {
      public void apply(final Villain it) {
        it.setName(villainName);
        it.setSex(Gender.Femenino);
        List<Hobbie> _hobbies = it.getHobbies();
        _hobbies.add(Hobbie.Beber);
        List<Hobbie> _hobbies_1 = it.getHobbies();
        _hobbies_1.add(Hobbie.Fumar);
        List<String> _signs = it.getSigns();
        _signs.add("Alta");
        List<String> _signs_1 = it.getSigns();
        _signs_1.add("Morena");
      }
    };
    return ObjectExtensions.<Villain>operator_doubleArrow(_villain, _function);
  }
  
  public Villain createVillain2(final String villainName) {
    Villain _villain = new Villain();
    final Procedure1<Villain> _function = new Procedure1<Villain>() {
      public void apply(final Villain it) {
        it.setName(villainName);
        it.setSex(Gender.Masculino);
        List<Hobbie> _hobbies = it.getHobbies();
        _hobbies.add(Hobbie.Golf);
        List<Hobbie> _hobbies_1 = it.getHobbies();
        _hobbies_1.add(Hobbie.Fumar);
        List<String> _signs = it.getSigns();
        _signs.add("Chaparro");
        List<String> _signs_1 = it.getSigns();
        _signs_1.add("Sueco");
      }
    };
    return ObjectExtensions.<Villain>operator_doubleArrow(_villain, _function);
  }
  
  public Villain createVillain3(final String villainName) {
    Villain _villain = new Villain();
    final Procedure1<Villain> _function = new Procedure1<Villain>() {
      public void apply(final Villain it) {
        it.setName(villainName);
        it.setSex(Gender.Masculino);
        List<Hobbie> _hobbies = it.getHobbies();
        _hobbies.add(Hobbie.Golf);
        List<Hobbie> _hobbies_1 = it.getHobbies();
        _hobbies_1.add(Hobbie.Programar);
        List<String> _signs = it.getSigns();
        _signs.add("Likes Bling");
        List<String> _signs_1 = it.getSigns();
        _signs_1.add("Heavy Gun");
      }
    };
    return ObjectExtensions.<Villain>operator_doubleArrow(_villain, _function);
  }
}
