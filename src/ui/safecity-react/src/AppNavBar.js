import React, {Component} from 'react';
import {Navbar, NavbarBrand} from 'reactstrap';
import {Link} from 'react-router-dom';
import {FaAlignJustify} from "react-icons/fa";

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar className="changeColor">
            <NavbarBrand className="homeNav" tag={Link} to="/"><FaAlignJustify /> Home</NavbarBrand>
        </Navbar>
            ;
    }
}



