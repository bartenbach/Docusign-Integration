import React, { useState } from "react";
import BtButton from "../shared/BtButton";

const AddProjectForm = (props: any) => {
  const initialFormState = { projectName: "" };
  const [project, setProject] = useState(initialFormState);

  const handleInputChange = (event: { target: { name: any; value: any } }) => {
    const { name, value } = event.target;
    setProject({ ...project, [name]: value });
  };
  return (
    <form
      onSubmit={(event: { preventDefault: () => void }) => {
        event.preventDefault();
        if (!project.projectName) {
          console.log("returning");
          return;
        }
        console.log("adding project");
        props.addProject(project);
        setProject(initialFormState);
      }}
    >
      <label>Name</label>
      <input
        type="text"
        name="projectName"
        value={project.projectName}
        onChange={handleInputChange}
        placeholder="Project name"
      />
      <BtButton type="submit" text="Submit" link="" />
    </form>
  );
};

export default AddProjectForm;
