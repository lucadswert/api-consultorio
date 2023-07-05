import "./index.css";

export default function Cadastro(){
    return(
        <div>
            <h1 className="Titulo">Escolha o tipo de Cadastro</h1>
            <div className="cadastros">
                <div className="imgBotao">
                    <img className = "fotoPaciente" src="cadastrar-paciente.jpg" alt="Cadastrar Paciente"/>
                    <div class="button">
                        <a href="/cadastrar-paciente">
                            <button className="cadastrarPaciente">Cadastrar Paciente</button>
                        </a>
                    </div>
                </div>

                <div className="imgBotao">
                    <img className = "fotoMedico" src="cadastrar-medico.jpg" alt="Cadastrar Médico"/>
                    <div class="button">
                        <a href="/cadastrar-medico">
                            <button className="cadastrarMedico">Cadastrar Médico</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    )
}