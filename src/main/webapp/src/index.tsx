import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import "./index.css";
import EmbeddedSigning from "./pages/esignature/EmbeddedSigning";
import EmbeddedSending from "./pages/esignature/EmbeddedSending";
import EmbeddedConsole from "./pages/esignature/EmbeddedConsole";
import Powerforms from "./pages/esignature/Powerforms";
import { HashRouter as Router, Route, Link, Switch } from "react-router-dom";

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <div>
        <nav>
          <Link to="/">App </Link>
          <Link to="/EmbeddedSigning">EmbeddedSigning </Link>
          <Link to="/EmbeddedSending">EmbeddedSending </Link>
          <Link to="/EmbeddedConsole">EmbeddedConsole </Link>
          <Link to="/Powerforms">Powerforms </Link>
        </nav>
        <Switch>
          <Route exact path="/" component={App} /> 
          <Route exact path="/EmbeddedSigning" component={EmbeddedSigning} />
          <Route exact path="/EmbeddedSending" component={EmbeddedSending} />
          <Route exact path="/EmbeddedConsole" component={EmbeddedConsole} />
          <Route exact path="/Powerforms" component={Powerforms} />
        </Switch>
      </div>
    </Router>
  </React.StrictMode>,
  document.getElementById("root")
);
