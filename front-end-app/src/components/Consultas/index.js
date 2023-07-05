import "./index.css";
export default function Consulta(){
    return(
        <div>
            <h1 className="Titulo">O que deseja fazer?</h1>
            <div className="consultas">
                <div className="imgBotao">
                    <img className = "imagem" src="marcar-consulta.png" alt="Marcar Consulta"/>
                    <div class="button">
                        <a href="/marcar-consulta">
                            <button className="botao">Marcar Consulta</button>
                        </a>
                    </div>
                </div>
                <div className="imgBotao">
                    <img className = "imagem" src="desmarcar-consulta.jpg" alt="Desmarcar Consulta"/>
                    <div class="button">
                        <a href="/cancelar-consulta">
                            <button className="botao">Desmarcar Consulta</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    )
}