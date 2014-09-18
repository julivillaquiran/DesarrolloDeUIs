package country;

import country.InterestPlace;
import java.util.List;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Country {
  private String _name;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private List<String> _characteristics = CollectionLiterals.<String>newArrayList();
  
  public List<String> getCharacteristics() {
    return this._characteristics;
  }
  
  public void setCharacteristics(final List<String> characteristics) {
    this._characteristics = characteristics;
  }
  
  private List<InterestPlace> _places = CollectionLiterals.<InterestPlace>newArrayList();
  
  public List<InterestPlace> getPlaces() {
    return this._places;
  }
  
  public void setPlaces(final List<InterestPlace> places) {
    this._places = places;
  }
  
  private List<Country> _connections = CollectionLiterals.<Country>newArrayList();
  
  public List<Country> getConnections() {
    return this._connections;
  }
  
  public void setConnections(final List<Country> connections) {
    this._connections = connections;
  }
  
  public void addCharacteristics(final String newCharacteristic) {
    List<String> _characteristics = this.getCharacteristics();
    _characteristics.add(newCharacteristic);
    List<String> _characteristics_1 = this.getCharacteristics();
    ObservableUtils.firePropertyChanged(this, "characteristics", _characteristics_1);
  }
  
  public void takeCharacteristics(final String characteristic) {
    List<String> _characteristics = this.getCharacteristics();
    _characteristics.remove(characteristic);
    List<String> _characteristics_1 = this.getCharacteristics();
    ObservableUtils.firePropertyChanged(this, "characteristics", _characteristics_1);
  }
  
  public void addPlaces(final InterestPlace place) {
    List<InterestPlace> _places = this.getPlaces();
    int _size = _places.size();
    boolean _lessEqualsThan = (_size <= 2);
    if (_lessEqualsThan) {
      List<InterestPlace> _places_1 = this.getPlaces();
      _places_1.add(place);
    }
    List<InterestPlace> _places_2 = this.getPlaces();
    ObservableUtils.firePropertyChanged(this, "places", _places_2);
  }
  
  public void takePlaces(final InterestPlace place) {
    List<InterestPlace> _places = this.getPlaces();
    _places.remove(place);
    List<InterestPlace> _places_1 = this.getPlaces();
    ObservableUtils.firePropertyChanged(this, "places", _places_1);
  }
  
  public void addConnections(final Country country) {
    List<Country> _connections = this.getConnections();
    _connections.add(country);
    List<Country> _connections_1 = this.getConnections();
    ObservableUtils.firePropertyChanged(this, "connections", _connections_1);
  }
  
  public void takeConnections(final Country country) {
    List<Country> _connections = this.getConnections();
    _connections.remove(country);
    List<Country> _connections_1 = this.getConnections();
    ObservableUtils.firePropertyChanged(this, "connections", _connections_1);
  }
  
  public List<Country> getPossibleConnections(final GameSystem system) {
    List<Country> _worldMap = system.getWorldMap();
    final Function1<Country, Boolean> _function = new Function1<Country, Boolean>() {
      public Boolean apply(final Country c) {
        List<Country> _connections = Country.this.getConnections();
        boolean _contains = _connections.contains(c);
        return Boolean.valueOf((!_contains));
      }
    };
    Iterable<Country> _filter = IterableExtensions.<Country>filter(_worldMap, _function);
    return IterableExtensions.<Country>toList(_filter);
  }
}
