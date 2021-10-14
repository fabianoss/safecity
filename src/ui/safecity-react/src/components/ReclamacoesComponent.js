
import React from 'react';
import ReclamacoesService from '../services/ReclamacoesService';
import AppNavbar from "../AppNavBar";
import {Button, Container} from "reactstrap";
import {Link} from "react-router-dom";
import {FaPlus} from "react-icons/all";
import {FaReply} from "react-icons/fa";

class ReclamacoesComponent extends React.Component{

    constructor(props){
        super(props)
        this.state = {
            reclamacoes:[]
        }
    }

    componentDidMount(){
        ReclamacoesService.getReclamacoes().then((response) => {
            this.setState({ reclamacoes: response.data})
        });
    }

    render(){
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button className="btnAdcCat" color="success" tag={Link} to="/categorias/new"><FaPlus/> Categoria</Button>
                        <Button className="btnAdcCat" color="success" tag={Link} to="/reclamacoes/new"><FaPlus/> Categoria</Button>
                        <button className="btnBackCat" size="sm"><Link to="/"><FaReply /> Voltar</Link></button>
                    </div>
                    <h4 className = "text-center"> Lista de reclamações</h4><br/>

                    <table className = "table table-striped">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Titulo</td>
                                <td>Categoria</td>
                                <td>Descrição</td>
                                <td>Data Cadastro</td>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.reclamacoes.map(
                                    reclamacao =>
                                    <tr key = {reclamacao.idReclamacao}>
                                        <td> {reclamacao.idReclamacao} </td>
                                        <td> {reclamacao.titulo}</td>
                                        <td> {reclamacao.idCategoria} </td>
                                        <td> {reclamacao.descricaoReclamacao} </td>
                                        <td> {reclamacao.dataCadastro} </td>
                                    </tr>
                                    )
                                }
                            </tbody>
                        </table>
                </Container>
            </div>
        )
    }
}

export default ReclamacoesComponent
