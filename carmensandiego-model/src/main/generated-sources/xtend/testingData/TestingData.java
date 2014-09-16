package testingData;

import country.Country;
import country.InterestPlace;
import country.Places;
import gameCase.Case;
import java.util.List;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import villain.Gender;
import villain.Hobbie;
import villain.Villain;

@SuppressWarnings("all")
public class TestingData {
  private GameSystem gameSystem = new GameSystem();
  
  public GameSystem createGameSystem() {
    final Procedure1<GameSystem> _function = new Procedure1<GameSystem>() {
      public void apply(final GameSystem it) {
        Villain _createVillain1 = TestingData.this.createVillain1("Villano 1");
        it.addVillains(_createVillain1);
        Villain _createVillain2 = TestingData.this.createVillain2("Nastrow Banks");
        it.addVillains(_createVillain2);
        Villain _createVillain3 = TestingData.this.createVillain3("Jhonny Q");
        it.addVillains(_createVillain3);
        Country _createCountry1 = TestingData.this.createCountry1();
        it.addCountries(_createCountry1);
        Country _createCountry2 = TestingData.this.createCountry2();
        it.addCountries(_createCountry2);
      }
    };
    return ObjectExtensions.<GameSystem>operator_doubleArrow(
      this.gameSystem, _function);
  }
  
  public Country createCountry1() {
    Country _country = new Country();
    final Procedure1<Country> _function = new Procedure1<Country>() {
      public void apply(final Country it) {
        it.setName("Afganistan");
        List<String> _characteristics = it.getCharacteristics();
        _characteristics.add("Hablan arabe");
        List<String> _characteristics_1 = it.getCharacteristics();
        _characteristics_1.add("Son Islamistas");
        List<InterestPlace> _places = it.getPlaces();
        InterestPlace _interestPlace = new InterestPlace();
        final Procedure1<InterestPlace> _function = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Banco);
          }
        };
        InterestPlace _doubleArrow = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace, _function);
        _places.add(_doubleArrow);
      }
    };
    return ObjectExtensions.<Country>operator_doubleArrow(_country, _function);
  }
  
  public Country createCountry2() {
    Country _country = new Country();
    final Procedure1<Country> _function = new Procedure1<Country>() {
      public void apply(final Country it) {
        it.setName("Inglaterra");
        List<String> _characteristics = it.getCharacteristics();
        _characteristics.add("Hablan ingles");
        List<String> _characteristics_1 = it.getCharacteristics();
        _characteristics_1.add("Tienen Reina");
        List<InterestPlace> _places = it.getPlaces();
        InterestPlace _interestPlace = new InterestPlace();
        final Procedure1<InterestPlace> _function = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Club);
          }
        };
        InterestPlace _doubleArrow = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace, _function);
        _places.add(_doubleArrow);
        List<InterestPlace> _places_1 = it.getPlaces();
        InterestPlace _interestPlace_1 = new InterestPlace();
        final Procedure1<InterestPlace> _function_1 = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Embajada);
          }
        };
        InterestPlace _doubleArrow_1 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_1, _function_1);
        _places_1.add(_doubleArrow_1);
      }
    };
    return ObjectExtensions.<Country>operator_doubleArrow(_country, _function);
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
  
  public void saveData(final GameSystem model) {
    List<Country> _worldMap = model.getWorldMap();
    this.gameSystem.setWorldMap(_worldMap);
    List<Villain> _files = model.getFiles();
    this.gameSystem.setFiles(_files);
    List<Case> _cases = model.getCases();
    this.gameSystem.setCases(_cases);
  }
}
