import "./index.css";

export default function Cadastro(){
    return(
        <div>
            <h1 className="Titulo">Escolha a lista que deseja acessar</h1>
            <div className="cadastros">
                <div className="imgBotao">
                    <img className = "fotoPaciente" src="cadastrar-paciente.jpg" alt="Listar Pacientes"/>
                    <div class="button">
                        <a href="/listar-pacientes">
                            <button className="listarPacientes">Ver Lista de Pacientes</button>
                        </a>
                    </div>
                </div>

                <div className="imgBotao">
                    <img className = "fotoMedico" src="cadastrar-medico.jpg" alt="Listar Médicos"/>
                    <div class="button">
                        <a href="/listar-medicos">
                            <button className="listarMedicos">Ver Lista de Médicos</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    )
}