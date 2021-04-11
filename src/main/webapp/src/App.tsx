import { Divider } from "@material-ui/core";
import { useEffect, useState } from "react";
import "./App.css";
import Login from "./components/auth/Login";
import { Project } from "./components/projects/Project";
import Projects from "./components/projects/Projects";

function App() {
  const [projectState, setProjectState] = useState<Project[]>([]);

  useEffect(() => {
    fetch("/api/projects/100")
      .then((res) => res.json())
      .then((data) => {
        setProjectState(data);
      })
      .catch(console.log);
  }, [setProjectState]);

  return (
    <div className="App">
      <h1>Docusign Prototype</h1>
      <Login />
      <Divider />
      <Projects projects={projectState} setProjects={setProjectState} />
    </div>
  );
}

export default App;
