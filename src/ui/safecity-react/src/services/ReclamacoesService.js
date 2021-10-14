import axios from 'axios'

const RECLAMACOES_API_URL = 'http://localhost:8082/safecity/v1/reclamacoes/reclamacoes';
const RECLAMACOES_NEW_API_URL = 'http://localhost:8082/safecity/v1/reclamacoes/new';

class ReclamacoesService {

    getReclamacoes(){
        return axios.get(RECLAMACOES_API_URL);
    }

    novaReclamacao(){
        return axios.get(RECLAMACOES_NEW_API_URL);
    }
}

// Exportando o objeto desta classe
export default new ReclamacoesService();
