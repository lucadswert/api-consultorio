
import { Link } from "react-router-dom";
import "./index.css";

export default function Header(){

    return(
        <header>
            <Link className="logo" to="/">
                <img className = "logoBranca" src="/LogoClinicaBranca.png" alt="LogoBranca"></img>
            </Link>
            <Link className="botaoHeader" to="/cadastros">Cadastrar</Link>
            <Link className="botaoHeader" to="/listar">Listar</Link>
            <Link className="botaoHeader" to="/consultas">Consultas</Link>
        </header>
    )
}