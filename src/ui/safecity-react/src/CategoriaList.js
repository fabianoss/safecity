import React, { Component } from 'react';
import AppNavbar from './AppNavBar';
import { Link } from 'react-router-dom';
import { ButtonGroup, Container, Button, Table } from 'reactstrap';
import {
    FaAlignJustify,
    FaBeer,
    FaCog,
    FaEdit,
    FaFilter,
    FaMicrophoneAlt,
    FaReply,
    FaSearch,
    FaTrash
} from 'react-icons/fa';
import {FaPlus} from "react-icons/all";
//import AppNavbar from './AppNavBar';

class CategoriaList extends Component{

    constructor(props){
        super(props)
        this.state = {categorias: []}
        this.remove = this.remove.bind(this);
    }

    componentDidMount(){
        fetch('/categorias')
            .then(response => response.json())
            .then(data => this.setState({categorias: data}));
    }

    async remove(id) {
        window.location.reload(false)

        await fetch(`/categorias/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
           

        }).then(() => {
            let updatedCategorias = [...this.state.categorias].filter(i => i.id !== id);
            this.setState({categorias: updatedCategorias});
        });
        
    }


render() {
    const {categorias} = this.state;

  
    const categoriaList = categorias.map(categoria => {
        return <tr key={categoria.idCategoria}>
            <td style={{whiteSpace: 'nowrap'}}>{categoria.descricaoCategoria}</td>
          
            <td>
                <ButtonGroup>
                    <Button className="actionCat" size="sm" color="primary" tag={Link} to={"/categorias/" + categoria.idCategoria}><FaEdit/> Edit</Button>
                    <Button className="actionCat" size="sm" color="danger" onClick={() => this.remove(categoria.idCategoria)}><FaTrash/> Excluir</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <div className="float-right">
                    <Button className="btnAdcCat" color="success" tag={Link} to="/categorias/new"><FaPlus/> Categoria</Button>
                    <button className="btnBackCat" size="sm"><Link to="/"><FaReply /> Voltar</Link></button>
                </div>
                <h3>Categoria</h3>
                <Table className="mt-4">
                    <thead>
                        <tr>
                            <th width="30%">Descricão Categoria</th>
                            <th width="40%"></th>
                        </tr>
                    </thead>
                    <tbody>
                    {categoriaList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
}

}

export default CategoriaList;


