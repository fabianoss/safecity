import React, { Component } from 'react';
import {FaAlignJustify, FaBeer, FaCog, FaFilter, FaMicrophoneAlt, FaSearch} from 'react-icons/fa';
//import './App.css';
import AppNavbar from './AppNavBar';

import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import {MapContainer} from "./App";

class Home extends Component {

    render() {
        return (
            <div>
                <AppNavbar/>
                <body>
                    <div className="s01">
                        <form>
                            <fieldset>
                                <legend><FaFilter /> Filtro </legend>
                            </fieldset>
                            <div className="inner-form">

                                <div className="input-field first-wrap">
                                    <input id="search" type="text" placeholder="What are you looking for?"/>
                                </div>

                                <div className="input-field third-wrap">
                                    <button className="btn-search" type="button"><Link to="/categorias"><FaSearch /> Search </Link></button>
                                </div>
                            </div><br/>
                            <Container fluid >
                                <div className="motherBtn">
                                    <button className="btn" type="button" ><Link to="/categorias"><FaCog /> Categorias</Link></button>
                                    <button className="btn" type="button" ><Link to="/reclamacoes"><FaMicrophoneAlt /> Reclamações</Link></button>
                                </div>
                                </Container><br/>
                        </form>
                    </div>

                </body>
            </div>

        );
    }

}
export default Home;

