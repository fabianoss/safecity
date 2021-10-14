import './App.css';
import React, { Component } from 'react'
import AppNavbar from './AppNavBar';


import {BrowserRouter as Router, Link, Route, Switch} from 'react-router-dom';

import CategoriaEdit from './CategoriaEdit';
import CategoriaList from './CategoriaList';
import ReclamacoesComponent from './components/ReclamacoesComponent';
import {Button, Container, Navbar, NavbarBrand} from "reactstrap";
import Home from "./Home";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/categorias' exact={true} component={CategoriaList}/>
            <Route path='/categorias/:id' component={CategoriaEdit}/>
            <Route path='/reclamacoes' exact={true} component={ReclamacoesComponent}/>
          </Switch>
        </Router>
    )
  }
}
export default App;
/*
const mapStyles = {
    width: '100%',
    height: '100%'
};

export class MapContainer extends Component {
    render() {
        return (

            <Map
                google={this.props.google}
                zoom={14}
                style={mapStyles}
                initialCenter={
                    {
                        lat: -1.2884,
                        lng: 36.8233
                    }
                }
            />
        );
    }
}

export default GoogleApiWrapper({
    googleMapURL:"https://maps.googleapis.com/maps/api/js?key=AIzaSyC4R6AN7SmujjPUIGKdyao2Kqitzr1kiRg&v=3.exp&libraries=geometry,drawing,places",

})(MapContainer);*/
/*export default GoogleApiWrapper({
  apiKey: 'YOUR_GOOGLE_MAPS_API_KEY_GOES_HERE'
})(MapContainer);*/

