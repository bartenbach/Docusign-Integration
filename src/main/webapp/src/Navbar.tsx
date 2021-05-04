import App from "./App";
import EmbeddedSigning from "./pages/esignature/EmbeddedSigning";
import EmbeddedSending from "./pages/esignature/EmbeddedSending";
import EmbeddedConsole from "./pages/esignature/EmbeddedConsole";
import Powerforms from "./pages/esignature/Powerforms";
import Envelopes from "./components/docusign/Envelopes";
import { HashRouter as Router, Route, Switch } from "react-router-dom";
import { Nav } from "react-bootstrap";
import "./Navbar.css";

export default function Navbar(){
    return (
        <Router>
        <Nav fill variant="pills" className="justify-content-center" defaultActiveKey="1" >
          <Nav.Item>
            <Nav.Link href="#/" eventKey="1">App</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="#/EmbeddedSigning" eventKey="2">EmbeddedSigning</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="#/EmbeddedSending" eventKey="3">EmbeddedSending</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="#/EmbeddedConsole" eventKey="4">EmbeddedConsole</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="#/Powerforms" eventKey="5">Powerforms</Nav.Link>
          </Nav.Item>  
          <Nav.Item>
            <Nav.Link href="#/Envelopes" eventKey="6">Envelopes</Nav.Link>
          </Nav.Item>          
        </Nav>
        <Switch>
          <Route exact path="/" component={App} /> 
          <Route exact path="/EmbeddedSigning" component={EmbeddedSigning} />
          <Route exact path="/EmbeddedSending" component={EmbeddedSending} />
          <Route exact path="/EmbeddedConsole" component={EmbeddedConsole} />
          <Route exact path="/Powerforms" component={Powerforms} />
          <Route exact path="/Envelopes" component={Envelopes} />
        </Switch>
    </Router>
    );
};
