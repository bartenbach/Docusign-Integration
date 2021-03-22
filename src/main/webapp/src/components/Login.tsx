import BtButton from "./BtButton";

const token_url: string = "/api/auth";

const Login = () => {
  const onClick = () => {
    console.log("clicked!");
  };

  return (
    <div className="App">
      <h2>Login</h2>
      <BtButton text="Homeowner" onClick={() => onClick} href={token_url} />
      <BtButton text="Builder" onClick={() => onClick} href={token_url} />
    </div>
  );
};

export default Login;
