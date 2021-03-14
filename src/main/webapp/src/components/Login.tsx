import BtButton from "./BtButton";

const Login = () => {
  const onClick = () => {
    console.log("clicked!");
  };

  return (
    <div className="App">
      <h2>Login</h2>
      <BtButton text="Homeowner" onClick={() => onClick} />
      <BtButton text="Builder" onClick={() => onClick} />
    </div>
  );
};

export default Login;
