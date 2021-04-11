import BtButton from "../shared/BtButton";

const ProjectTable = (props: { projects: any[]; deleteProject: any }) => (
  <table>
    <thead>
      <tr>
        <th>Name</th>
        <th>Id</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {props.projects.length > 0 ? (
        props.projects.map((data) => (
          <tr key={data.projectId}>
            <td>{data.projectName}</td>
            <td>{data.projectId}</td>
            <td>
              <BtButton text="Edit" link="/" />
              <BtButton text="Delete" link="/" />
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No projects</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default ProjectTable;
