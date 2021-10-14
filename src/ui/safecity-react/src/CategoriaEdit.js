import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavBar';

class CategoriaEdit extends Component {

    emptyItem = {        
        descricaoCategoria: ''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount() {
        if (this.props.match.params.id !== 'new') {


            const categoria = await (await fetch(`/categorias/${this.props.match.params.id}`)).json();

            console.log('component Did')
            console.log(this.props.match.params.id)
            console.log(categoria)

            this.setState({item: categoria});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;
        
        console.log(event);
    
        await fetch('/categorias' + (item.idCategoria ? '/' + item.idCategoria : ''), {
                        
            method: (item.idCategoria) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
            
        });
        this.props.history.push('/categorias');

        console.log('fetch')
        console.log(item.idCategoria)
    }



    render() {
        const {item} = this.state;
        const title = <h2>{item.idCategoria ? 'Editar categoria' : 'Adicionar categoria'}</h2>;
        console.log('render')
        console.log(item)
        console.log(item.idCategoria)
        console.log('this.state')
        console.log(this.state)
    
        return <div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="descricaoCategoria">Descrição</Label>
                        <Input type="text" name="descricaoCategoria" id="descricaoCategoria" value={item.descricaoCategoria || ''}
                               onChange={this.handleChange} autoComplete="descricaoCategoria"/>
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" className="btnAdcCat" type="submit">Salvar</Button>{' '}
                        <Button color="secondary" className="btnAdcCat" tag={Link} to="/categorias">Cancelar</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    }

}

export default withRouter(CategoriaEdit);