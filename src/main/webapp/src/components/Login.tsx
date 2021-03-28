import { BrowserRouter as Router, Link, Route, Switch } from "react-router-dom";
import BtButton from "./BtButton";
import { Builder } from "./Builder";
import { HomeOwner } from "./HomeOwner";

export default function Login() {
  return (
    <Router>
      <div className="App">
        <Link to="/homeowner">
          <BtButton text="Homeowner" />
        </Link>
        <Link to="/builder">
          <BtButton text="Builder" />
        </Link>
        <hr />
        <Switch>
          <Route exact path="/">
            <Login />
          </Route>
          <Route path="/homeowner">
            <HomeOwner />
          </Route>
          <Route path="/builder">
            <Builder />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}
