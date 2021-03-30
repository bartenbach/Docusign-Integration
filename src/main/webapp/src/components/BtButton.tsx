import { Button } from "@material-ui/core";

export const BtButton: React.FC<Props> = (props) => {
  return <Button>{props.text}</Button>;
};

interface Props {
  text: string;
}

export default BtButton;
