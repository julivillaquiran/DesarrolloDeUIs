package testingData;

import country.Country;
import country.InterestPlace;
import country.Places;
import gameCase.Case;
import java.util.List;
import java.util.Random;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import villain.Gender;
import villain.Hobbie;
import villain.Villain;

@SuppressWarnings("all")
public class TestingData {
  private int index;
  
  private Random r1;
  
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
        Country _createCountry3 = TestingData.this.createCountry3();
        it.addCountries(_createCountry3);
        Country _createCountry4 = TestingData.this.createCountry4();
        it.addCountries(_createCountry4);
        Case _createCase1 = TestingData.this.createCase1();
        it.addCases(_createCase1);
        Case _createCase2 = TestingData.this.createCase2();
        it.addCases(_createCase2);
      }
    };
    return ObjectExtensions.<GameSystem>operator_doubleArrow(
      this.gameSystem, _function);
  }
  
  public Case createCase1() {
    Case _xblockexpression = null;
    {
      Random _random = new Random();
      this.r1 = _random;
      List<Villain> _files = this.gameSystem.getFiles();
      int _size = _files.size();
      int _nextInt = this.r1.nextInt(_size);
      this.index = _nextInt;
      List<Villain> _files_1 = this.gameSystem.getFiles();
      Villain _get = _files_1.get(this.index);
      Case _case = new Case(_get);
      final Procedure1<Case> _function = new Procedure1<Case>() {
        public void apply(final Case it) {
          it.setCaseName("El Collar Real");
          it.setDescription("El Collar real ha sido robado");
          List<Country> _escapeRoute = it.getEscapeRoute();
          List<Country> _worldMap = TestingData.this.gameSystem.getWorldMap();
          Country _get = _worldMap.get(2);
          _escapeRoute.add(_get);
          List<Country> _escapeRoute_1 = it.getEscapeRoute();
          List<Country> _worldMap_1 = TestingData.this.gameSystem.getWorldMap();
          Country _get_1 = _worldMap_1.get(1);
          _escapeRoute_1.add(_get_1);
          List<Country> _escapeRoute_2 = it.getEscapeRoute();
          List<Country> _worldMap_2 = TestingData.this.gameSystem.getWorldMap();
          Country _get_2 = _worldMap_2.get(0);
          final Procedure1<Country> _function = new Procedure1<Country>() {
            public void apply(final Country it) {
              List<InterestPlace> _places = it.getPlaces();
              InterestPlace _get = _places.get(2);
              _get.setIsHere(true);
            }
          };
          Country _doubleArrow = ObjectExtensions.<Country>operator_doubleArrow(_get_2, _function);
          _escapeRoute_2.add(_doubleArrow);
        }
      };
      _xblockexpression = ObjectExtensions.<Case>operator_doubleArrow(_case, _function);
    }
    return _xblockexpression;
  }
  
  public Case createCase2() {
    Case _xblockexpression = null;
    {
      Random _random = new Random();
      this.r1 = _random;
      List<Villain> _files = this.gameSystem.getFiles();
      int _size = _files.size();
      int _nextInt = this.r1.nextInt(_size);
      this.index = _nextInt;
      List<Villain> _files_1 = this.gameSystem.getFiles();
      Villain _get = _files_1.get(this.index);
      Case _case = new Case(_get);
      final Procedure1<Case> _function = new Procedure1<Case>() {
        public void apply(final Case it) {
          it.setCaseName("El cetro del faraon");
          it.setDescription("El cetro del gan faraón ha sido robado");
          List<Country> _escapeRoute = it.getEscapeRoute();
          List<Country> _worldMap = TestingData.this.gameSystem.getWorldMap();
          Country _get = _worldMap.get(2);
          _escapeRoute.add(_get);
          List<Country> _escapeRoute_1 = it.getEscapeRoute();
          List<Country> _worldMap_1 = TestingData.this.gameSystem.getWorldMap();
          Country _get_1 = _worldMap_1.get(1);
          _escapeRoute_1.add(_get_1);
          List<Country> _escapeRoute_2 = it.getEscapeRoute();
          List<Country> _worldMap_2 = TestingData.this.gameSystem.getWorldMap();
          Country _get_2 = _worldMap_2.get(0);
          _escapeRoute_2.add(_get_2);
        }
      };
      _xblockexpression = ObjectExtensions.<Case>operator_doubleArrow(_case, _function);
    }
    return _xblockexpression;
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
        List<InterestPlace> _places_1 = it.getPlaces();
        InterestPlace _interestPlace_1 = new InterestPlace();
        final Procedure1<InterestPlace> _function_1 = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Embajada);
          }
        };
        InterestPlace _doubleArrow_1 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_1, _function_1);
        _places_1.add(_doubleArrow_1);
        List<InterestPlace> _places_2 = it.getPlaces();
        InterestPlace _interestPlace_2 = new InterestPlace();
        final Procedure1<InterestPlace> _function_2 = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Club);
          }
        };
        InterestPlace _doubleArrow_2 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_2, _function_2);
        _places_2.add(_doubleArrow_2);
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
        List<InterestPlace> _places_2 = it.getPlaces();
        InterestPlace _interestPlace_2 = new InterestPlace();
        final Procedure1<InterestPlace> _function_2 = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Banco);
          }
        };
        InterestPlace _doubleArrow_2 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_2, _function_2);
        _places_2.add(_doubleArrow_2);
        List<Country> _connections = it.getConnections();
        List<Country> _worldMap = TestingData.this.gameSystem.getWorldMap();
        Country _get = _worldMap.get(0);
        _connections.add(_get);
      }
    };
    return ObjectExtensions.<Country>operator_doubleArrow(_country, _function);
  }
  
  public Country createCountry3() {
    Country _country = new Country();
    final Procedure1<Country> _function = new Procedure1<Country>() {
      public void apply(final Country it) {
        it.setName("Canada");
        List<String> _characteristics = it.getCharacteristics();
        _characteristics.add("Hablan ingles");
        List<String> _characteristics_1 = it.getCharacteristics();
        _characteristics_1.add("Hablan Frances");
        List<InterestPlace> _places = it.getPlaces();
        InterestPlace _interestPlace = new InterestPlace();
        final Procedure1<InterestPlace> _function = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Biblioteca);
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
        List<InterestPlace> _places_2 = it.getPlaces();
        InterestPlace _interestPlace_2 = new InterestPlace();
        final Procedure1<InterestPlace> _function_2 = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Club);
          }
        };
        InterestPlace _doubleArrow_2 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_2, _function_2);
        _places_2.add(_doubleArrow_2);
        List<Country> _connections = it.getConnections();
        List<Country> _worldMap = TestingData.this.gameSystem.getWorldMap();
        Country _get = _worldMap.get(0);
        _connections.add(_get);
        List<Country> _connections_1 = it.getConnections();
        List<Country> _worldMap_1 = TestingData.this.gameSystem.getWorldMap();
        Country _get_1 = _worldMap_1.get(1);
        _connections_1.add(_get_1);
      }
    };
    return ObjectExtensions.<Country>operator_doubleArrow(_country, _function);
  }
  
  public Country createCountry4() {
    Country _country = new Country();
    final Procedure1<Country> _function = new Procedure1<Country>() {
      public void apply(final Country it) {
        it.setName("Japon");
        List<String> _characteristics = it.getCharacteristics();
        _characteristics.add("Involucrados en WWII");
        List<String> _characteristics_1 = it.getCharacteristics();
        _characteristics_1.add("Origen de los Yakuza");
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
        List<InterestPlace> _places_2 = it.getPlaces();
        InterestPlace _interestPlace_2 = new InterestPlace();
        final Procedure1<InterestPlace> _function_2 = new Procedure1<InterestPlace>() {
          public void apply(final InterestPlace it) {
            it.setName(Places.Banco);
          }
        };
        InterestPlace _doubleArrow_2 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_2, _function_2);
        _places_2.add(_doubleArrow_2);
        List<Country> _connections = it.getConnections();
        List<Country> _worldMap = TestingData.this.gameSystem.getWorldMap();
        Country _get = _worldMap.get(0);
        _connections.add(_get);
        List<Country> _connections_1 = it.getConnections();
        List<Country> _worldMap_1 = TestingData.this.gameSystem.getWorldMap();
        Country _get_1 = _worldMap_1.get(1);
        _connections_1.add(_get_1);
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
