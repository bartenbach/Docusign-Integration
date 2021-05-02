import React from "react";
import AddProjectForm from "./AddProjectForm";
import {Project} from "./Project";
import ProjectTable from "./ProjectTable";

const Projects = (props: {
    projects: Array<Project>;
    setProjects: (arg: Array<Project>) => void;
}) => {
    const addProject = (project: Project) => {
        props.setProjects([...props.projects, project]);
    };
    const deleteProject = (projectName: string) => {
        props.setProjects(
            props.projects.filter(
                (project: { projectName: string }) =>
                    project.projectName !== projectName
            )
        );
    };

    return (
        <div className="container">
            <h1>Manage Projects</h1>
            <div className="flex-row">
                <div className="flex-large">
                    <h2>Create</h2>
                    <AddProjectForm addProject={addProject}/>
                </div>
                <div className="flex-large">
                    <h2>Projects</h2>
                    <ProjectTable
                        projects={props.projects}
                        deleteProject={deleteProject}
                    />
                </div>
            </div>
        </div>
    );
};

export default Projects;
