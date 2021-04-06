import BtButton from "./BtButton";

export default function Login() {
  return (
    <div>
      <BtButton text="Homeowner" link="/login" />
      <BtButton text="Builder" link="/login" />
    </div>
  );
}
